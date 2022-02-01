package com.kirstreltsov.service;

import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirstreltsov.dao.ShortlinkRepository;
import com.kirstreltsov.util.RandomShortlinkGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shortlinkService")
@Transactional
public class ShortlinkService {

    Logger LOGGER = LoggerFactory.getLogger(ShortlinkService.class);
    private final String DOMAIN_NAME = "http://localhost:8080/";

    @Autowired
    ShortlinkRepository dao;

    @Autowired
    RandomShortlinkGenerator shortlinkGenerator;

    public String findLongURLbyShort(String shortUrl){
       String longUrl = dao.findURLByShortName(shortUrl).getLongUrl();
       return longUrl;
    }

    public String saveUrltoDB(String originalUrl) throws IOException{

        String shortUrl = shortlinkGenerator.generateShortUrl();
        dao.saveOriginalAndShortUrltoDB(shortUrl, prepareUrl(originalUrl));
        return DOMAIN_NAME + shortUrl;
    }

    private String prepareUrl(String originalUrl) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(originalUrl);
        return jsonNode.path("userLink").asText(); 
    }
}

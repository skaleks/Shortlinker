package com.kirstreltsov.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirstreltsov.dao.ShortlinkJDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("shortlinkService")
@Transactional
public class ShortlinkService {

    Logger LOGGER = LoggerFactory.getLogger(ShortlinkService.class);

    @Autowired
    ShortlinkJDBC dao;

    public String findLongURLbyShort(String shortUrl){
       String longUrl = dao.findURLByShortName(shortUrl).getLongUrl();
       return longUrl;
    }

    public String saveUrltoDB(String originalUrl) throws JsonParseException, JsonMappingException, IOException{

        String shortUrl = generateShortUrl();
        dao.saveOriginalAndShortUrltoDB(shortUrl, prepareUrl(originalUrl));
        return shortUrl;
    }

    private String generateShortUrl() {
        return "govno";
    }

    private String prepareUrl(String originalUrl) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(originalUrl);
        return jsonNode.path("targetUrl").asText(); 
    }
}

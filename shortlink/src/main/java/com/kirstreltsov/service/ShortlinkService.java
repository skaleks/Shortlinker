package com.kirstreltsov.service;

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
       LOGGER.info(longUrl);
       return longUrl;
    }

    private String generateShortUrl() {
        return "";
    }
}

package com.kirstreltsov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("shortlinkJDBC")
public class ShortlinkJDBCImpl implements Shortlinkrepo{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String findURLByShortName(String shortUrl) {

        return jdbcTemplate.queryForObject(
                "select longUrl from url where shortUrl = ?",
                new Object[]{shortUrl},
                String.class);
    }

    @Override
    public int saveLongURLtoDB(String longUrl) {
        return jdbcTemplate.update("insert into url (shortUrl, longUrl) values(?,?)", generateShortUrl() ,longUrl);
    }

    private String generateShortUrl() {
        return "";
    }
    
}

package com.kirstreltsov.dao;

import com.kirstreltsov.model.URLS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("shortlinkJDBC")
public class ShortlinkJDBCImpl implements ShortlinkJDBC{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public URLS findURLByShortName(String shortUrl) {

        return jdbcTemplate.queryForObject(
                "SELECT long_url FROM URLS WHERE short_url = ?",
                new Object[]{shortUrl}, new BeanPropertyRowMapper<URLS>(URLS.class));
    }

    @Override
    public int saveOriginalAndShortUrltoDB(String shortUrl, String originalUrl) {
        return jdbcTemplate.update("INSERT INTO URLS (short_Url, long_Url) VALUES(?,?)", shortUrl ,originalUrl);
    }
}

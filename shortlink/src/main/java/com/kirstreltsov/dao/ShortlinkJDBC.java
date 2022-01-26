package com.kirstreltsov.dao;

import com.kirstreltsov.model.URLS;

public interface ShortlinkJDBC{

    public URLS findURLByShortName(String shortUrl);

    public int saveLongURLtoDB(String shortUrl,String longUrl);
}
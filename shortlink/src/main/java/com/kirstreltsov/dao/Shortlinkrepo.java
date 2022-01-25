package com.kirstreltsov.dao;

public interface Shortlinkrepo{

    public String findURLByShortName(String shortUrl);

    public int saveLongURLtoDB(String longUrl);
}
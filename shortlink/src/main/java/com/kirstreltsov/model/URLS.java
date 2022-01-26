package com.kirstreltsov.model;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class URLS implements Serializable{

    private Long id;
    private String shortUrl;
    private String longUrl;
}
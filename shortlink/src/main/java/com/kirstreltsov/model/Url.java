package com.kirstreltsov.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Url implements Serializable{

    private Long id;
    private String shortUrl;
    private String longUrl;
}
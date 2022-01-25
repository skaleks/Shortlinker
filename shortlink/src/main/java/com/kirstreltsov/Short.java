package com.kirstreltsov;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Short{

    private Long id;
    private String shortUrl;
    private String longUrl;
}
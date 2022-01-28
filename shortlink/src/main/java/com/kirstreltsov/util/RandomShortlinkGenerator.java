package com.kirstreltsov.util;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component("LinkGenerator")
public class RandomShortlinkGenerator {

    public String generateShortUrl() {

        RandomStringGenerator stringGenerator = new RandomStringGenerator.Builder()
                .filteredBy(codePoint -> checkRange(codePoint))
                .build();

        return stringGenerator.generate(5,10);
    }
    
    private boolean checkRange(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z') || ('0' <= codePoint && codePoint <= '9');
    }
}

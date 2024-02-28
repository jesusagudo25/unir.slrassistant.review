package com.unir.slrassistant.review.util;

import org.springframework.stereotype.Component;

@Component
public class UUIDUtil {
    public String generateUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}

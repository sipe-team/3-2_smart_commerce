package com.smart.commerce.ceo.modules.commodity.infrastructure;

import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PurgomalumClient {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String PURGOMALUM_URL = "https://www.purgomalum.com/service/containsprofanity?text=";

    public PurgomalumClient() {
    }

    public static boolean containsSwearWords(String text) throws UnsupportedEncodingException {
        String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
        String url = PURGOMALUM_URL + encodedText;
        String response = restTemplate.getForObject(url, String.class);
        return Boolean.parseBoolean(response); //containsprofanity는 일반 텍스트로 true, false를 반환한다.
    }
}

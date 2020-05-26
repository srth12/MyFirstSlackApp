package com.example.slack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class BroadcastService {

    @Value("${slack.url}")
    private String URL;

    //TODO Consider upgrading to WebClient
    private final RestTemplate restTemplate;

    @Autowired
    public BroadcastService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private static HttpEntity getHttpEntity(String message){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> body = new HashMap<>();
        body.put("text", message);
        return new HttpEntity<>(body, httpHeaders);
    }

    public ResponseEntity<String> broadcastMessage(String message){

        var httpEntity = getHttpEntity(message);
        return restTemplate.exchange(URL, HttpMethod.POST, httpEntity, String.class);
    }
}

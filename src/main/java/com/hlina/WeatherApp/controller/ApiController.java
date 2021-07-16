package com.hlina.WeatherApp.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/")
public class ApiController {

    RestTemplate restTemplate;

    @RequestMapping(value = "/hello/")
    public String restTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange("https://www.mocky.io/v2/5185415ba171ea3a00704eed", HttpMethod.GET, entity, String.class).getBody();
    }
}

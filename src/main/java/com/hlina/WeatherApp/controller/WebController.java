package com.hlina.WeatherApp.controller;

import com.hlina.WeatherApp.entity.Weather;
import com.hlina.WeatherApp.repository.WeatherRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class WebController {
    @Autowired
    private WeatherRepository weatherRepository;
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }
    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Weather> messages = weatherRepository.findAll();
        model.put("messages", messages);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Weather> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = weatherRepository.findByCity(filter);
        } else {
            messages = weatherRepository.findAll();
        }

        model.put("messages", messages);

        return "main";
    }
}
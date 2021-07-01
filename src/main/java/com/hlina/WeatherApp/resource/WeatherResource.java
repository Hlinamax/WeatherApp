package com.hlina.WeatherApp.resource;

import com.hlina.WeatherApp.entity.Weather;
import com.hlina.WeatherApp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/rest/weather")
public class WeatherResource {

    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping(value = "/all")
    public List<Weather> getAll() {
        return weatherRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Weather> persist(@RequestBody final Weather weather) {
        weatherRepository.save(weather);
        return weatherRepository.findAll();
    }
}

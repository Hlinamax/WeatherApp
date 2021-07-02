package com.hlina.WeatherApp.resource;

import com.hlina.WeatherApp.entity.Weather;
import com.hlina.WeatherApp.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @RequestMapping(value = "/city/{id}")
    public Optional<Weather> getCityById(@PathVariable("id") Long id) {
        return weatherRepository.findById(id);
    }

    @RequestMapping(value = "/{city}")
    public List<Weather> findByCity(@PathVariable("city") String city) {
        return weatherRepository.findByCity(city);
    }
}

package com.hlina.WeatherApp.repository;

import com.hlina.WeatherApp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    public List<Weather> findByCity(String city);
}

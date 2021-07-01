package com.hlina.WeatherApp.repository;

import com.hlina.WeatherApp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}

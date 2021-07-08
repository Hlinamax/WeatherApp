package com.hlina.WeatherApp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "city_weather", schema = "weather", catalog = "")
public class Weather {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "id_city")
    private Long idCity;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "temp_now")
    private BigDecimal tempNow;
    @Column(name = "temp_max")
    private BigDecimal tempMax;
    @Column(name = "temp_min")
    private BigDecimal tempMin;
    @Column(name = "humidity")
    private BigDecimal humidity;
    @Column(name = "speed")
    private BigDecimal speed;
    @Column(name = "deg")
    private BigDecimal deg;

    public Long getId() {
        return id;
    }

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity)  {
        this.idCity = idCity;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public BigDecimal getTempNow() {
        return tempNow;
    }

    public void setTempNow(BigDecimal tempNow) {
        this.tempNow = tempNow;
    }



    public BigDecimal getTempMax() {
        return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
        this.tempMax = tempMax;
    }



    public BigDecimal getTempMin() {
        return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
        this.tempMin = tempMin;
    }



    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }



    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }



    public BigDecimal getDeg() {
        return deg;
    }

    public void setDeg(BigDecimal deg) {
        this.deg = deg;
    }
}

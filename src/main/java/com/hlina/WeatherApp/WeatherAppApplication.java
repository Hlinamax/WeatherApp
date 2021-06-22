package com.hlina.WeatherApp;

import com.hlina.WeatherApp.view.MainView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args) {
		MainView.getInstance().run();
		SpringApplication.run(WeatherAppApplication.class, args);
	}

}

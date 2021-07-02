package com.hlina.WeatherApp.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.*;     //Java library in Maven
import com.google.gson.reflect.*;

public class GetDB {
    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        return map;
    }
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(ДБ) Введите название города: ");
        String LOCATION = scanner.nextLine();
        String urlString = "http://localhost:8080/rest/weather/" + LOCATION;
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();
            System.out.println("Проверка вывода: " + result); //вывод результата запроса
            /*
            Map<String, Object> respMap = jsonToMap(result.toString());
            System.out.println("---------------");
            System.out.println(respMap);
            */
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

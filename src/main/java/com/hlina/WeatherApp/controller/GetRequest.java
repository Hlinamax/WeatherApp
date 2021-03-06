package com.hlina.WeatherApp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.*;     //Java library in Maven
import com.google.gson.reflect.*;

public class GetRequest {


    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
        return map;
    }
    public static void run() {
        String API_KEY = "b18c7414745435f032ff5bba3b78efa1";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название города: ");
        String LOCATION = scanner.nextLine();
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY +
                "&units=metric";
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
            System.out.println(result); //вывод результата запроса
            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
            System.out.println("---------------");
            //System.out.println("ID: " + respMap.get("id"));
            System.out.println("Страна: " + sysMap.get("country") + ", Город: " + respMap.get("name"));
            System.out.println("Текущая Температура: " + mainMap.get("temp") + " градусов по цельсию "
                    + "(макс t: " + mainMap.get("temp_max") + ", мин t: " + mainMap.get("temp_min") + ")");
            System.out.println("Текущая Влажность: " + mainMap.get("humidity") + "%");
            System.out.println("Скорость Ветра: " + windMap.get("speed") + " метров в секунду");
            System.out.println("Угол Ветра: " + windMap.get("deg") + " градусов");

            //Заполнение в БД
            String urlDB = "http://localhost:8080/rest/weather/load";
            String fill = "{\"id\":" + respMap.get("id") + ",\"idCity\":" + respMap.get("id") + ",\"city\":\"" + respMap.get("name") + "\",\"country\":\""+ sysMap.get("country") +"\",\"tempNow\":" + mainMap.get("temp") + ",\"tempMax\":"+ mainMap.get("temp_max") +",\"tempMin\":"+ mainMap.get("temp_min") +",\"humidity\":"+ mainMap.get("humidity") +",\"speed\":"+ windMap.get("speed") +",\"deg\":"+ windMap.get("deg") +"}";
            URL urls = new URL(urlDB);
            URLConnection con = urls.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

            byte[] out = fill .getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(out);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}



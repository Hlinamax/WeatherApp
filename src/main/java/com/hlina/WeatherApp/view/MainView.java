package com.hlina.WeatherApp.view;

import com.hlina.WeatherApp.entity.GetRequest;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {

    private static MainView mainView;

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Текущая информация о погоде");
            System.out.println("2. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runToday();
                    break;
                case 2:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 2, пожалуйста");
            }
        }
    }

    private void runToday() {
        GetRequest.run();
    }
}
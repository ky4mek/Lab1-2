package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// Класс для хранения информации о футбольных командах
class FootballTeam {
    String name; // Название команды
    String city; // Город команды
    int rank; // Место команды в лиге
    int wins; // Количество победы команды
}

public class Main { // Главный класс с методами
    public static void main(String[] args) { // Главный метод (точка входа в программу)
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        // Ввод информации о командах
        System.out.println("Введите количество команд: ");
        int n = sc.nextInt(); // Количество команд
        FootballTeam[] footballTeams = new FootballTeam[n];
        System.out.println("Введите информацию про команды:");
        for (int i = 0; i < footballTeams.length; i++) {
            sc.nextLine(); // очистка буфера
            footballTeams[i] = new FootballTeam();
            System.out.print("Название " + (i + 1) + "-ой команды: ");
            footballTeams[i].name = sc.nextLine();
            System.out.print("Город " + (i + 1) + "-ой команды: ");
            footballTeams[i].city = sc.nextLine();
            System.out.print("Место " + (i + 1) + "-ой команды в лиге: ");
            footballTeams[i].rank = sc.nextInt();
            System.out.print("Количество побед " + (i + 1) + "-ой команды: ");
            footballTeams[i].wins = sc.nextInt();
        }

        // Вывод полученной информации
        System.out.println("\nИнформация о футбольных командах:");
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
        for (FootballTeam team : footballTeams) {
            System.out.println(team.name + "\t" + team.city
                    + "\t" + team.rank + "\t" + team.wins);
        }

        // Команда с максимальным количеством побед
        int nommax = 0; // номер элемента для команды с максимальным количеством побед (начальное значение)
        double max = footballTeams[nommax].wins; // максимальное количество побед (начальное значение)
        for (int i = 0; i < footballTeams.length; i++)
            if (footballTeams[i].wins > max) {
                max = footballTeams[i].wins;
                nommax = i;
            }
        System.out.println("\nКоманда с максимальным количеством побед:");
        System.out.println(footballTeams[nommax].name + "\t" + footballTeams[nommax].city
                + "\t" + footballTeams[nommax].rank + "\t" + footballTeams[nommax].wins);

        // Команды с количеством побед больше среднего
        int s = 0; // суммарное количество побед
        for (FootballTeam footballTeam : footballTeams) s += footballTeam.wins;
        int sr = s / footballTeams.length; // среднее количество побед команд
        System.out.println("Среднее количество побед команд = " + sr);
        System.out.println("\nКоманды с количеством побед больше среднего");
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
        for (FootballTeam team : footballTeams) {
            if (team.wins > sr) {
                System.out.println(team.name + "\t" + team.city
                        + "\t" + team.rank + "\t" + team.wins);
            }
        }

        // Сортировка массива команд по убыванию мест в лиге
        for (int i = 0; i < footballTeams.length - 1; i++)
            for (int j = 0; j < footballTeams.length - i - 1; j++)
                if (footballTeams[j].rank < footballTeams[j + 1].rank) {
                    FootballTeam t = footballTeams[j]; // t – переменная для перестановки
                    footballTeams[j] = footballTeams[j + 1];
                    footballTeams[j + 1] = t;
                }
        System.out.println("\nОтсортированный список команд по убыванию мест в лиге:");
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
        for (FootballTeam team : footballTeams) {
            System.out.println(team.name + "\t" + team.city
                    + "\t" + team.rank + "\t" + team.wins);
        }

        // Поиск по названию команды
        sc.nextLine(); // Очистка буфера
        int nom = 1; // 1 – команда с таким названием отсутствует
        System.out.println("Введите название команды для поиска: ");
        String teamName = sc.nextLine();
        for (int i = 0; i < footballTeams.length; i++)
            // Если введенное название команды соответствует названию команды из массива команд (игнорируя чувствительность к регистру)
            if (teamName.equalsIgnoreCase(footballTeams[i].name))
                nom = i;
        while (nom == 1) { // Если команда не найдена
            System.out.println("Такой команды не найдено в списке! Введите название команды для поиска: ");
            teamName = sc.nextLine();
            for (int i = 0; i < footballTeams.length; i++)
                // Если введенное название команды соответствует названию команды из массива команд (игнорируя чувствительность к регистру)
                if (teamName.equalsIgnoreCase(footballTeams[i].name))
                    nom = i;
        }
        System.out.println("Такая команда успешно найдена. Это "
                + footballTeams[nom].name + "\t" + footballTeams[nom].city
                + "\t" + footballTeams[nom].rank + "\t" + footballTeams[nom].wins);

        // Исправление одного из полей команды
        System.out.println("Введите номер поля команды, что нужно редактировать (1 - название, 2 - город, 3 - место, 4 - победы): ");
        int fieldNumber = sc.nextInt();
        sc.nextLine(); // Очистка буфера
        switch (fieldNumber) {
            case 1 -> {
                System.out.println("Введите новое значение для поля 'Название': ");
                footballTeams[nom].name = sc.nextLine();
            }
            case 2 -> {
                System.out.println("Введите новое значение для поля 'Город': ");
                footballTeams[nom].city = sc.nextLine();
            }
            case 3 -> {
                System.out.println("Введите новое значение для поля 'Место': ");
                footballTeams[nom].rank = sc.nextInt();
            }
            default -> {
                System.out.println("Введите новое значение для поля 'Название': ");
                footballTeams[nom].name = sc.nextLine();
            }
        }
        // Вывод полной информации о команде после редактирования
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
        System.out.println(footballTeams[nom].name + "\t" + footballTeams[nom].city
                + "\t" + footballTeams[nom].rank + "\t" + footballTeams[nom].wins);
    }
}
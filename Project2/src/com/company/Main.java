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
    // МЕТОДЫ ДЛЯ ВСЕХ ПОДЗАДАЧ для работы с объектами класса FootballTeam

    public static FootballTeam[] setFootballTeamArr(int k, Scanner sc) { // Ввод массива футбольных команд
        // Ввод информации о командах
        FootballTeam[] footballTeams = new FootballTeam[k];
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
        return footballTeams;
    }

    public static void showArray(FootballTeam[] footballTeams) { // Вывод массива с футбольными командами
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
        for (FootballTeam team : footballTeams) {
            System.out.println(team.name + "\t" + team.city
                    + "\t" + team.rank + "\t" + team.wins);
        }
    }

    public static void showTeam(FootballTeam team) { // Вывод определенной футбольной команды
        System.out.println(team.name + "\t" + team.city
                + "\t" + team.rank + "\t" + team.wins);
        System.out.println("Название" + "\t" + "Город"
                + "\t" + "Место в лиге" + "\t" + "Количество побед");
    }

    public static int NomMax(FootballTeam[] footballTeams) {  // Номер команды с максимальным количеством побед
        int nommax = 0; // номер элемента для команды с максимальным количеством побед (начальное значение)
        int max = footballTeams[nommax].wins; // максимальное количество побед (начальное значение)
        for (int i = 0; i < footballTeams.length; i++)
            if (footballTeams[i].wins > max) {
                max = footballTeams[i].wins;
                nommax = i;
            }
        return nommax;
    }

    public static int avgWins(FootballTeam[] footballTeams) { // Среднее количество побед команд
        int s = 0; // Суммарное количество побед
        for (FootballTeam footballTeam : footballTeams) s += footballTeam.wins;
        return s / footballTeams.length; // Среднее количество побед команд
    }

    public static FootballTeam[] getBestTeams(FootballTeam[] footballTeams) {  // Команды с количеством побед больше среднего
        int sr = avgWins(footballTeams);
        int kol = 0; // Количество команд

        for (FootballTeam team : footballTeams) {
            if (team.wins > sr) {
                ++kol;
            }
        }
        if (kol != 0) {
            FootballTeam[] bestTeams = new FootballTeam[kol];
            int n = -1;
            for (FootballTeam footballTeam : footballTeams) {
                if (footballTeam.wins > sr) {
                    bestTeams[++n] = footballTeam;
                }
            }
            return bestTeams;
        }
        return null;
    }

    public static void sortRankInDesc(FootballTeam[] footballTeams) {         // Сортировка массива команд по убыванию мест в лиге
        for (int i = 0; i < footballTeams.length - 1; i++)
            for (int j = 0; j < footballTeams.length - i - 1; j++)
                if (footballTeams[j].rank < footballTeams[j + 1].rank) {
                    FootballTeam t = footballTeams[j]; // t – переменная для перестановки
                    footballTeams[j] = footballTeams[j + 1];
                    footballTeams[j + 1] = t;
                }
    }

    public static int findForTeam(FootballTeam[] footballTeams, String teamName) { // Поиск команды в массиве футбольных команд
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        sc.nextLine();
        int nom = 1; // 1 – команда с таким названием отсутствует
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
        return nom; // Возвращает индекс найденного элемента массива
    }

    public static void editTeamField(FootballTeam[] footballTeams, int teamIdx) { // Редактирование одного из полей команды
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Введите номер поля команды, что нужно редактировать (1 - название, 2 - город, 3 - место, 4 - победы): ");
        int fieldNumber = sc.nextInt();
        sc.nextLine(); // Очистка буфера
        switch (fieldNumber) {
            case 1 -> {
                System.out.println("Введите новое значение для поля 'Название': ");
                footballTeams[teamIdx].name = sc.nextLine();
            }
            case 2 -> {
                System.out.println("Введите новое значение для поля 'Город': ");
                footballTeams[teamIdx].city = sc.nextLine();
            }
            case 3 -> {
                System.out.println("Введите новое значение для поля 'Место': ");
                footballTeams[teamIdx].rank = sc.nextInt();
            }
            case 4 -> {
                System.out.println("Введите новое значение для поля 'Победы': ");
                footballTeams[teamIdx].wins = sc.nextInt();
            }
            default -> {
                System.out.println("Введите новое значение для поля 'Название': ");
                footballTeams[teamIdx].name = sc.nextLine();
            }
        }
    }


    public static void main(String[] args) { // Главный метод (точка входа в программу)
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Введите количество команд: ");
        int n = sc.nextInt(); // Количество команд

        FootballTeam[] footballTeams = setFootballTeamArr(n, sc);
        showArray(footballTeams); // Вывод массива футбольных команд

        // Команда с максимальным количеством побед
        int nommax = NomMax(footballTeams);
        System.out.println("\nКоманда с максимальным количеством побед:");
        showTeam(footballTeams[nommax]); // Вывод команду с максимальным количеством побед

        System.out.println("Среднее количество побед команд = " + avgWins(footballTeams));
        System.out.println("\nКоманды с количеством побед больше среднего:");
        FootballTeam[] bestTeams = getBestTeams(footballTeams); // Массив команд с количеством побед больше среднего
        showArray(bestTeams); // Вывод массива команд с количеством побед больше среднего

        // Сортировка массива по убыванию мест в лиге
        sortRankInDesc(footballTeams);
        System.out.println("\nОтсортированный список команд по убыванию мест в лиге:");
        showArray(footballTeams);

        // Поиск по названию команды
        System.out.println("Введите название команды для поиска: ");
        String teamName = sc.nextLine();
        int teamIdx = findForTeam(footballTeams, teamName); // Индекс найденной команды
        showTeam(footballTeams[teamIdx]); // Вывод найденной команды на экран

        // Исправление одного из полей команды
        editTeamField(footballTeams, teamIdx);

        // Вывод полной информации о команде после редактирования
        showTeam(footballTeams[teamIdx]);
    }
}
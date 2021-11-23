package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Strana {
    String name; // назва країни
    double square; // площа країни
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        // Виведення інформації про країни
        System.out.println("Введіть кількість країн ");
        int n = sc.nextInt(); // кількість країн
        Strana country[] = new Strana[n];
        System.out.println("Введіть інформацію про країни: ");
        for (int i = 0; i < country.length; i++) {
            sc.nextLine(); // очистка буфера
            country[i] = new Strana();
            System.out.print("Назва " + (i + 1) + "-ої країни");
            country[i].name = sc.nextLine();
            System.out.print("Площа " + (i + 1) + "-ої країни => ");
            country[i].square = sc.nextDouble();
        }
        // Виведення отриманої інформації
        System.out.println("\nХарактеристики країн:");
        for (Strana strana : country) {
            System.out.println("" + strana.name + "\t" + strana.square
                    + " млн кв. км");
        }
        // Країна з максимальною площею
        int nommax = 0; // номер елемента для країни з максимальною площею (початкове значення)
        double max = country[nommax].square; // максимальна площа (початкове значення)
        for (int i = 0; i < country.length; i++)
            if (country[i].square > max) {
                max = country[i].square;
                nommax = i;
            }
        System.out.println("\nКраїна з максимальною площею:");
        System.out.println("" + country[nommax].name + "\t" + country[nommax].square
                + "млн кв. км");
        // Сортування країн за площею
        for (int i = 0; i < country.length - 1; i++)
            for (int j = 0; j < country.length - 1 - i; j++)
                if (country[j].square > country[j + 1].square) {
                    Strana rab = country[j]; // rab – робоча змінна для перестановки
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }

        System.out.println("\nВідсортований список по площі:");//
        for (Strana strana : country) {
            System.out.println("" + strana.name + "\t" + strana.square + "млн кв. км");
        }
        // Сортування країн за назвою
        for (int i = 0; i < country.length - 1; i++)
            for (int j = 0; j < country.length - i - 1; j++)
                if (country[j].name.compareTo(country[i + 1].name) > 0) {
                    Strana rab = country[j]; //rab – робоча змінна для перестановки
                    country[j] = country[j + 1];
                    country[j + 1] = rab;
                }
        System.out.println("\nВідсортований список за назвами:");
        for (Strana strana : country) {
            System.out.println("" + strana.name + "\t" + strana.square
                    + " млн кв. км");
        }
        // Площа більша за середню
        double s = 0; // сумарна площа
        for (Strana strana : country) s += strana.square;
        double sr = s / country.length; // середня площа
        System.out.println("Середня площа =" + sr);
        System.out.println("\nКраїни з площею більшою за середню");
        for (Strana strana : country) {
            if (strana.square > sr)
                System.out.println(strana.name + "\t" + strana.square + " млн кв. км");
        }
        // Пошук по назві
        sc.nextLine(); // очистка буфера
        System.out.println("Введіть назву країни для пошуку");
        String name = sc.nextLine();
        int nom = 1; // 1 – країна з такою назвою відсутня
        for (int i = 0; i < country.length; i++)
            if (name.equalsIgnoreCase(country[i].name))
                nom = i;
        if (nom != 1) {
            System.out.println("Така країна є в списку. Це"
                    + country[nom].name + " " + country[nom].square + " млн кв. км");

        } else System.out.println("Такої країни нема в списку");
    }
}
package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Strana {
    String name; // назва країни
    double square; // площа країни
}

public class Main {
    // Методи для роботи з об’єктами класу Strana
    public static Strana[] setCountryArr(int k) { // Ведення масиву країн
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        Strana[] country = new Strana[k];
        System.out.println("Введіть інформацію про країни: ");
        for (int i = 0; i < country.length; i++) {
            country[i] = new Strana();
            System.out.print("Назвае " + (i + 1) + "-ої країни");
            country[i].name = sc.nextLine();
            System.out.print("Площа " + (i + 1) + "-ої країни");
            country[i].square = sc.nextDouble();
            sc.nextLine(); // очистка буфера

        }
        return country;
    }

    public static void showArray(Strana[] cntr) {
        // Виведення масиву
        for (Strana strana : cntr) {
            System.out.println("" + strana.name + " \t" + strana.square + " млн кв. км");
        }
    }

    // Інформація про одну країну
    public static void showCountry(Strana cntr) {
        System.out.println("" + cntr.name + "\t" + cntr.square + " млн кв. км");
    }

    // Номер країни з максимальною площею
    public static int NomMax(Strana[] st) {
        int nommax = 0; // номер елемента країни з макс. площею (початкове значення)
        double max = st[nommax].square; // макс. площа (початкове значення)
        for (int i = 0; i < st.length; i++)
            if (st[i].square > max) {
                max = st[i].square;
                nommax = i;
            }
        return nommax;
    }

    // Сортування країн за площею
    public static void sortSquare(Strana[] cntr) {
        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - 1 - i; j++)
                if (cntr[j].square > cntr[j + 1].square) {
                    Strana rab = cntr[j]; // rab – робоча змінна для перестановки
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    // Сортування країн за назвою
    public static void sortName(Strana[] cntr) {

        for (int i = 0; i < cntr.length - 1; i++)
            for (int j = 0; j < cntr.length - i - 1; j++)
                if (cntr[j].name.compareTo(cntr[i + 1].name) > 0) {
                    Strana rab = cntr[j]; // rab – робоча змінна для перестановки
                    cntr[j] = cntr[j + 1];
                    cntr[j + 1] = rab;
                }
    }

    public static double avgSquare(Strana[] cntr) { // Середня площа
        double s = 0; // сумарна площа
        for (Strana strana : cntr) s += strana.square;
        double sr = s / cntr.length; // середня площа
        return sr;
    }

    // Країни з площею більшою за середню
    public static Strana[] Bigger(Strana[] cntr) {
        double sred = avgSquare(cntr);
        int kol = 0; // кількість країн
        for (Strana strana : cntr) {
            if (strana.square > sred)
                ++kol;
        }
        if (kol != 0) {
            Strana[] bigCountry = new Strana[kol];
            int n = -1;
            for (Strana strana : cntr)
                if (strana.square > sred) {
                    bigCountry[++n] = strana;
                }
            return bigCountry;
        } else return null;
    }

    // Пошук за назвою
    public static Strana findForName(Strana[] cntr, String name) {

        int n = -1; // -1 – країна із заданою назвою відсутня
        for (int i = 0; i < cntr.length; i++)
            if (name.equals(cntr[i].name))
                n = i;
        if (n != -1) {
            return cntr[n];
        } else return null;
    }

    public static void main(String[] args) { // Головний клас з методами
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість країн");
        int n = sc.nextInt(); // кількість країн
        Strana[] country = setCountryArr(n); // введіть інформацію про країни
        System.out.println("\nХарактеристики країн:");
        showArray(country); // виведення отриманої інформації
        // країна з максимальною площею
        int nommax = NomMax(country);
        System.out.println("\nКраїна з максимальною площею:");
        showCountry(country[nommax]);
        // сортування країн за площею
        sortSquare(country);
        System.out.println("\nВідсортований список за площею");
        showArray(country);
        // сортування країн за назвою
        sortName(country);
        System.out.println("\nВідсортований список за назвою");
        showArray(country);
        // cередня площа
        System.out.println("Середня площа =" + avgSquare(country));
        // площа більша за середню
        System.out.println("\nКраїни з площею більшою за середню");
        Strana[] larger = Bigger(country);

        showArray(larger);
        // пошук країни
        System.out.println("\nПошук країни \n Введіть назву країни ");
        sc.nextLine();
        String sname = sc.nextLine();
        Strana sfind = findForName(country, sname);
        if (sfind != null) {
            showCountry(sfind);
        } else {
            System.out.println("Такої країни немає в списку!");
        }
    }
}

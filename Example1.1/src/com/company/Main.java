package com.company;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class Sotrudnik { // класс в виде структуры с полями fam, im, otch, doljnost, oklad
    String fam, im, otch, doljnost;
    int oklad;
}

public class Main { // главный класс
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("Введите количество сотрудников => ");
        int kol = sc.nextInt();
        sc.nextLine();    // очистка буфера после ввода числа

        Sotrudnik[] sotr = new Sotrudnik[kol]; // получена	ссылка	на	массив сотрудников

        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new Sotrudnik();    // получена ссылка на i-тый элемент

// Присвоение значений полям
            System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введите его оклад => ");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine(); //очистка буфера
        } // end for

        // Вывод информации о сотрудниках
        System.out.println("\n	Сотрудники	фирмы:	\n	фам	\t	имя	\t	отч  \t должность \tОклад");
        for (Sotrudnik s : sotr) {
            System.out.print(s.fam + "\t" + s.im + "\t" + s.otch
                    + "\t " + s.doljnost + "\t\t" + s.oklad + "\n");
        }
    }
}

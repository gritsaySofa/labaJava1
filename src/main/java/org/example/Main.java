package org.example;
import org.example.ContainerNum;

import java.awt.*;
import java.util.*;
import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        ContainerNum container = new ContainerNum();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = getIntInput(scanner, "Выберите действие: ");

            switch (choice) {
                case 1:
                    addMultipleToFirst(container, scanner);
                    break;

                case 2:
                    addMultipleToLast(container, scanner);
                    break;

                case 3:
                    addSingleToIndex(container, scanner);
                    break;

                case 4:
                    try {
                        int removed = container.takeFirst();
                        System.out.println("Удалено из начала: " + removed);
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        int removed = container.takeLast();
                        System.out.println("Удалено из конца: " + removed);
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;

                case 6:
                    removeByIndex(container, scanner);
                    break;

                case 7:
                    System.out.println("Текущее содержимое контейнера:");
                    container.print();
                    break;

                case 8:
                    System.out.println("Размер контейнера: " + container.getSize());
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void addMultipleToFirst(ContainerNum container, Scanner scanner) {
        while (true) {
            System.out.println("\nТекущее содержимое:");
            container.print();

            String input = getStringInput(scanner,
                    "Введите число для добавления в начало (или 'q' для выхода): ");

            if (input.equalsIgnoreCase("q")) {
                return;
            }

            try {
                int value = Integer.parseInt(input);
                container.addToFirst(value);
                System.out.println("Добавлено: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или 'q'!");
            }
        }
    }

    private static void addMultipleToLast(ContainerNum container, Scanner scanner) {
        while (true) {
            System.out.println("\nТекущее содержимое:");
            container.print();

            String input = getStringInput(scanner,
                    "Введите число для добавления в конец (или 'q' для выхода): ");

            if (input.equalsIgnoreCase("q")) {
                return;
            }

            try {
                int value = Integer.parseInt(input);
                container.addToLast(value);
                System.out.println("Добавлено: " + value);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или 'q'!");
            }
        }
    }

    private static void addSingleToIndex(ContainerNum container, Scanner scanner) {
        int value = getIntInput(scanner, "Введите число: ");
        int index = getIntInput(scanner, "Введите индекс: ");
        container.addToIndex(value, index);
    }

    private static void removeByIndex(ContainerNum container, Scanner scanner) {
        int index = getIntInput(scanner, "Введите индекс для удаления: ");
        try {
            int removed = container.takeIndex(index);
            System.out.println("Удалено: " + removed);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить в начало");
        System.out.println("2. Добавить в конец");
        System.out.println("3. Добавить по индексу");
        System.out.println("4. Удалить из начала");
        System.out.println("5. Удалить из конца");
        System.out.println("6. Удалить по индексу");
        System.out.println("7. Просмотреть содержимое");
        System.out.println("8. Показать размер");
        System.out.println("0. Выход");
    }

    private static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }
    }

    private static String getStringInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
package org.example;
import org.example.ContainerNum;

import java.awt.*;
import java.util.*;
import java.util.Scanner;

/**
 * Демонстрация работы контейнера
 */
public class Main{
    /**
     * Создает экземпляр контейнера и запускает меню
     * @param args аргументы командной строки
     */
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

    /**
     * Добавляет несколько элементов в начало контейнера, так как мне не нравилось что постоянно нужно выходить в меню
     * @param container контейнер для добавления элементов
     * @param scanner объект для чтения пользовательского ввода
     */
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

    /**
     * Добавляет несколько элементов в конец контейнера, по тем же причинам что и в прошлом
     * @param container контейнер для добавления элементов
     * @param scanner объект для чтения пользовательского ввода
     */
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

    /**
     * Добавляем один элемент по указанному индексу
     * @param container контейнер для добавления
     * @param scanner бъект для чтения ввода
     */
    private static void addSingleToIndex(ContainerNum container, Scanner scanner) {
        int value = getIntInput(scanner, "Введите число: ");
        int index = getIntInput(scanner, "Введите индекс: ");
        container.addToIndex(value, index);
    }

    /**
     * Удаляет элемент по индексу
     * @param container контейнер для удаления
     * @param scanner объект для чтения ввода
     */
    private static void removeByIndex(ContainerNum container, Scanner scanner) {
        int index = getIntInput(scanner, "Введите индекс для удаления: ");
        try {
            int removed = container.takeIndex(index);
            System.out.println("Удалено: " + removed);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    /**
     * Менюшка, что еще сказать
     */
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

    /**
     * Обработка исключения на неправильный ввод
     * @param scanner объект для ввода
     * @param message сообщение для ввода
     * @return введенное пользователем число
     */
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

    /**
     * Получает строковый ввод от пользователя с консоли
     * @param scanner объект для ввода
     * @param message сообщение для ввода
     * @return введенная пользователем строка
     */
    private static String getStringInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}
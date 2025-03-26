package org.example;

/**
 * Класс контейнер для работы с числами
 */
public class ContainerNum {
    /**
     * Внутренний класс, представляющий узел связного списка
     */
    public static class ContainerNumbers {
        /**
         * Числовое значение, хранимое в узле списка
         */
        public int number;
        /**
         * Ссылка на следующий узел в связном списке
         */
        public ContainerNumbers next;

        /**
         * Создаем элемент связного списка, который будут хранить переданное число
         * @param number вот это вот число, в узле списка
         */
        public ContainerNumbers(int number) {
            this.number = number;
            this.next = null;
        }
    }

    private ContainerNumbers first;
    private ContainerNumbers last;
    private int size;

    /**
     *Возвращаем текущее количество элементов в контейнере
     * @return вот вернули получается
     */
    public int getSize() {
        return size;
    }

    /**
     * Возвращаем узел по указанному индексу
     * @param index позиция искомого узла
     * @return узел на заданной позиции или null
     */
    public ContainerNumbers getIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ContainerNumbers current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     *Создаем пустой контейнер
     */
    public ContainerNum() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     *Добавляем число в начало списка
     * @param number число для добавления в начало
     */
    public void addToFirst(int number) {
        ContainerNumbers NewFirst = new ContainerNumbers(number);
        if (first == null) {
            first = NewFirst;
            last = NewFirst;
        } else {
            NewFirst.next = first;
            first = NewFirst;
        }
        size++;
    }

    /**
     * Добавляем число в конец списка
     * @param number число для добавления в конец
     */
    public void addToLast(int number) {
        ContainerNumbers NewLast = new ContainerNumbers(number);
        if (last == null) {
            last = NewLast;
            first = NewLast;
        } else {
            last.next = NewLast;
            last = NewLast;
        }
        size++;
    }

    /**
     * Добавление числа в список по индексу
     * @param number число для добавления в список
     * @param index позиция для вставки этого числа
     */
    public void addToIndex(int number, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == size) {
            addToLast(number);
        } else if (index == 0) {
            addToFirst(number);
        } else {
            ContainerNumbers NewFirst = new ContainerNumbers(number);
            ContainerNumbers prev = getIndex(index - 1);
            NewFirst.next = prev.next;
            prev.next = NewFirst;
            size++;
        }
    }

    /**
     * Удаление из начала списка
     */
    public void deleteFromFirst() {
        if (first == null) {
            return;
        }
        first = first.next;
        size--;
    }

    /**
     * Удаление из конца списка
     */
    public void deleteFromLast() {
        if (last == null) {
            return;
        }
        if (first == last) {
            first = null;
            last = null;
        } else {
            ContainerNumbers current = first;
            while (current.next != last) {
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        size--;
    }

    /**
     * Удаление по конкретному индексу из списка
     * @param index индекс числа для удаления
     */
    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            deleteFromFirst();
        }else if(index == size - 1) {
            deleteFromLast();
        }else {
            ContainerNumbers prev = getIndex(index - 1);
            prev.next = prev.next.next;
            size--;
        }
    }

    /**
     *Извлекает и удаляет первый элемент списка
     * @return значение первого элемента или IllegalStateException если список пуст
     */
    public int takeFirst(){
        if (first == null) {
            throw new IllegalStateException("Container is empty");
        }
        int takingValue = first.number;
        first = first.next;
        size--;
        return takingValue;
    }

    /**
     * Извлекает и удаляет последний элемент списка
     * @return значение последнего элемента или IllegalStateException если список пуст
     */
    public int takeLast() {
        if (last == null) {
            throw new IllegalStateException("Container is empty");
        }
        int takingValue = last.number;
        if (first == last) {
            first = null;
            last = null;
        } else {
            ContainerNumbers current = first;
            while (current.next != last) {
                current = current.next;
            }
            current.next = null;
            last = current;
        }
        size--;
        return takingValue;
    }

    /**
     * Извлекает и удаляет элемент по указанному индексу
     * @param index позиция элемента для извлечения
     * @return значение удаленного элемента
     */
    public int takeIndex(int index)
    {
        if (index < 0 || index >= size) {
        throw new IllegalStateException("Container is empty");
    }
        if (index == 0) {
            takeFirst();
        }else if(index == size - 1) {
            takeLast();
        }else{
            ContainerNumbers prev = getIndex(index - 1);
            ContainerNumbers elementToTake = prev.next;
            prev.next = elementToTake.next;
            size--;
            return elementToTake.number;
        }
        return index;
    }

    /**
     * Выводит элементы в конце с пустой строкой
     */
    public void print() {
        ContainerNumbers current = first;
        while (current != null) {
            System.out.println(current.number + " ");
            current = current.next;
        }
        System.out.println();
    }
}
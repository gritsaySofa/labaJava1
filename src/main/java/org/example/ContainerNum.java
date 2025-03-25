package org.example;

public class ContainerNum {
    public static class ContainerNumbers {
        public int number;
        public ContainerNumbers next;

        public ContainerNumbers(int number) {
            this.number = number;
            this.next = null;
        }
    }

    private ContainerNumbers first;
    private ContainerNumbers last;
    private int size;

    public int getSize() {
        return size;
    }

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

    public ContainerNum() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

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

    public void deleteFromFirst() {
        if (first == null) {
            return;
        }
        first = first.next;
        size--;
    }
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
    public int takeFirst(){
        if (first == null) {
            throw new IllegalStateException("Container is empty");
        }
        int takingValue = first.number;
        first = first.next;
        size--;
        return takingValue;
    }
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
    public void print() {
        ContainerNumbers current = first;
        while (current != null) {
            System.out.println(current.number + " ");
            current = current.next;
        }
        System.out.println();
    }
}
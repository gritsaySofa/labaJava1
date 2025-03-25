package org.example;
import org.example.ContainerNum;

import java.awt.*;
import java.util.*;


public class Main{
    public static void main(String[] args) {
        ContainerNum containers = new ContainerNum();
        containers.addToFirst(1);
        containers.addToFirst(3);
        containers.addToFirst(5);
        containers.addToFirst(7);
        containers.addToFirst(9);

        containers.print();

        containers.addToLast(10);
        containers.addToLast(8);
        containers.addToLast(6);
        containers.addToLast(4);
        containers.addToLast(2);

        containers.print();

        containers.addToIndex(11,1);
        containers.addToIndex(12,2);

        containers.print();

        int takingFirstNumValue = containers.takeFirst();
        System.out.println(takingFirstNumValue);

        int takingLastNumValue = containers.takeLast();
        System.out.println(takingLastNumValue);

        int takingIndexValue = containers.takeIndex(5);
        System.out.println(takingIndexValue);

        containers.print();

        containers.deleteFromFirst();
        containers.print();

        containers.deleteFromLast();
        containers.print();

        containers.deleteFromIndex(7);
        containers.print();

    }


}
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        System.out.println(colors.get(1));

        colors.set(1,"Yellow");

        colors.remove("Red");
        System.out.println(colors);

        colors.remove(1);
        System.out.println(colors);

        for(String color: colors){
            System.out.println(color);
        }

        String[] colorsArray = {"Red","Green","Blue"};

        ArrayList<String> colorsList = new ArrayList<>(Arrays.asList(colorsArray));

        Collections.sort(colorsList);

        Collections.sort(colorsList,(s1, s2) -> s1.compareTo(s2));
        System.out.println(colorsList);

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(3,7));
        points.add(new Point(3,6));
        points.add(new Point(5,2));

        Comparator<Point> x_y_compare = new Comparator<Point>() {
            @Override
//            public int compare(Point p1, Point p2) {
//                return Integer.compare(p1.getX(),p2.getX());
//            }
            public int compare(Point p1, Point p2) {
                int tmp = Integer.compare(p1.getX(), p2.getX());
                if(tmp == 0){
                    return Integer.compare(p1.getY(),p2.getY());
                }
                return Integer.compare(p1.getX(),p2.getX());
            }

//            public int compare(Point p1, Point p2) {
//                return Integer.compare(p1.getX() + p1.getY(), p2.getX()) + p2.getY();
//            }
        };

        points.sort(x_y_compare);

        for (Point point:points){
            System.out.println(point);
        }


    }
}
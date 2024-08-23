package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream1 {
    public static void main(String[] args) {
        test_stream_point();
    }
    public static void test_stream_point(){
        List<Point> points = new ArrayList<>();
        points.add(new Point(7,2));
        points.add(new Point(3,4));
        points.add(new Point(2,6));
        points.add(new Point(7,1));
        System.out.println("#Total#");
        int total = points.stream()
                .flatMapToInt(point -> Arrays.stream(new int[]{point.getX(),point.getY()}))
                .sum();
        System.out.println("Total: " + total);
        System.out.println("#Total of hoanh do#");
        int sumX = points.stream()
                .mapToInt(Point::getX)
                .sum();
        System.out.println("SumX: " + sumX);
        System.out.println("#Total of hoanh do > 5#");
        int sumX2 = points.stream()
                .filter(point -> point.getX() > 5)
                .mapToInt(Point::getX)
                .sum();
        System.out.println("SumX2: " + sumX2);

        System.out.println("#Total of x^2+1-y with x > 5#");
        int sumX3 = points.stream()
                .filter(point -> point.getX()  > 5)
                .mapToInt(point ->{
                    return point.getX()*point.getX()+1-point.getY();
                })
                .sum();
        System.out.println("SumX3: " + sumX3);
        System.out.println("#In ra tung kq x^2+1-y with x > 1#");
        points.stream()
                .filter(point -> point.getX()  > 4)
                .mapToInt(point ->{
                    return point.getX()*point.getX()+1-point.getY();
                })
                .forEach(System.out::println);

        System.out.println("#Tinh tich toan bo x^2+1-y with x > 1#");
        long total5  = points.stream()
                .filter(point -> point.getX() > 1)
                .mapToLong(point ->{
                    return point.getX()*point.getX()+1-point.getY();
                }).reduce(1l,(kq,item)-> kq*item);
        System.out.println("Total5: "+total5);
        System.out.println("#Tinh tich toan bo 1/(x^2+y)#");
        double total6 = points.stream()
                .mapToDouble(point ->{
                    int x = point.getX();
                    int y = point.getY();
                    return ((double) 1 /(x*x +y));
                }).reduce(1d,(kq,item)-> kq*item);

        System.out.println("Total6: "+total6);
        System.out.println("#In ra toan bo x+y > 7#");
        points.stream()
                .filter(point -> (point.getX() + point.getY()) > 7)
                .forEach(System.out::println);
        System.out.println("#In ra ds x > 5 va y > 1#");
        points.stream()
                .filter(point -> (point.getX() > 5 && point.getY() >1))
                .forEach(System.out::println);
    }
}

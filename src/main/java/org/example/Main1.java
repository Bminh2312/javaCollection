package org.example;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("###################");
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(3,5));
        points.add(new Point(2,6));
        points.add(new Point(5,2));
        points.add(new Point(6,0));
        System.out.println("Predicate");
        Predicate<Point> sumPoint = point -> point.getX() + point.getY() > 7;
        Predicate<Point> sumPoint2 = point -> {
            if(point.getX() > 5){
                return point.getX() +point.getY() > 7;
            }else{
                return point.getX() +point.getY() > 6;
            }
        };
        for (Point point: points){
            if(sumPoint2.test(point)){
                System.out.println(point.toString());
            }
        }
        System.out.println("Function");
        Function<Point,String> sumPoint3 = point -> {
            if(point.getX() > 5){
                return ">5"+point.toString();
            }else{
                return "<=5"+point.toString();
            }
        };

        for (Point point: points){
                System.out.println(sumPoint3.apply(point));
        }
        System.out.println("Consumer");
        Consumer<Point> printMessage = point -> {
            if(point.getX() > point.getY()){
                System.out.println(point.getY() - point.getX());
            }else{
                System.out.println(point.getY() - point.getX());
            }
        };

        for (Point point: points){
            printMessage.accept(point);
        }
        System.out.println("Stream");
        points.stream().filter(point -> point.getX()> 3).forEach(System.out::println);
    }
}

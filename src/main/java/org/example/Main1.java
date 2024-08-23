package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        System.out.println("#######################");
        List<String> names = Arrays.asList("John","Alice","Bob","Anna");

        //Lọc các tên bắt đầu bằng chữ A
        names.stream()
                .filter(name -> name.startsWith("A") )
                .forEach(System.out::println);

        List<String> filteredNames =  names.stream()
                .filter(name -> name.startsWith("A") )
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredNames);

        //Ánh xạ các tên thành chữ hoa
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("#Sorted#");
        names.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("#reverseOrder#");
        //Sắp xếp theo thứ tự giảm dần
        names.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("#Sum#");
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: "+sum );
        System.out.println("#AVR#");
        double avr = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("AVR: "+avr);

        System.out.println("#Tìm giá trị lớn nhất#");
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("Max: " + (max.isPresent() ?max.getAsInt():"Not present"));

        System.out.println("#Tìm giá trị nhỏ nhất#");
        OptionalInt min = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();
        System.out.println("Min: " + (min.isPresent() ?min.getAsInt():"Not present"));

        System.out.println("#Sử dụng reduce để tính tổng#");
        int sum1 = numbers.stream()
                .reduce(0,Integer::sum);
        System.out.println("Sum: " + sum1);

        System.out.println("#Sử dụng reduce để tìm tích#");
        int product = numbers.stream()
                .reduce(1,(a,b) -> a*b);

        System.out.println("Prodcut using reduce: "+ product);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a","b","c"),
                Arrays.asList("d","e","f"),
                Arrays.asList("g","h","i")
        );

        System.out.println("#Sử dụng flatmap để kết hợp các danh sách con thành 1 danh sách#");
        List<String> combinedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(combinedList);
    }
}

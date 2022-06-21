package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        extendsGeneric();
        superGeneric();
        maskExtendsGeneric();
        pecs();
    }

    public static void extendsGeneric(){
        System.out.format("Extends Generic%n");
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        List<? extends Number> numbers = integers;
        showWholePart(numbers);
    }

    public static void superGeneric(){
        System.out.format("Super Generic%n");
        List<Number> numbers = new ArrayList<Number>();
        numbers.add(0.1);
        numbers.add(1);
        List<? super Integer> integers = numbers;
        numbers.add(2);
        showWholePart((List<? extends Number>) integers);
        showWholePart(numbers);
    }

    public static void maskExtendsGeneric(){
        System.out.format("Show Generic%n");
        List<Double> cash = new ArrayList<>();
        cash.add(5.3);
        showWholePart(cash);
        List<Integer> ages = new ArrayList<>();
        ages.add(5);
        showWholePart(ages);
    }

    private static void showWholePart(List<? extends Number> numbers) {
        for (Number num : numbers) {
            System.out.format("Number = %d%n", num.longValue());
        }
    }

    public static void pecs(){
        System.out.format("Demo PECS%n");
        List<Number> numbers = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1,2);
        copy(integers, numbers);
        showWholePart(numbers);
    }

    private static <T> void copy(List<? extends T> source, List<? super T> destination){
        for (int i = 0; i < source.size(); i++) {
            T element = source.get(i);
            destination.add(element);
        }
    }

    class MyType<T extends Number & Comparable<T>> {
        private T variable;

        public MyType(T variable) {
            this.variable = variable;
        }

        public <E> T method(E element) {
            return variable;
        }
    }

    private static void wrongPecs(){
        List<? extends Number> list1 = new ArrayList<Integer>();
        list1.add(null);
        Number n = list1.get(0);
        Object o = list1.get(0);

        /* //Errors
        list1.add(2.3);
        list1.add(5);
        list1.add(new Object());
        Integer i = list1.get(0);
        */

        List<? super Number> list2 = new ArrayList<Number>();
        list2.add(null);
        list2.add(2.3);
        list2.add(5);
        Object o2 = list2.get(0);

        /* //Errors
        list2.add(new Object());
        Number n2 = list2.get(0);
        Integer i2 = list2.get(0);
        */
    }
}

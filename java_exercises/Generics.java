package hackerrank.java_exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Java exercises related to Generic Classes, Methods and Interfaces
 */

public class Generics {

    public static void main(String[] args){
        Integer[] ints = {1,2,3,4,5};
        String[] weekDays = {"Monday, Tuesday, Wednesday, Thursday, Friday"};
        print(ints);
        print(weekDays);
        System.out.println(countGreaterThan(ints, 3));

        GenericList<String> list = new GenericList<>();
        list.add("Some string");
        GenericList<Integer> integerList = new GenericList<>();
        integerList.add(1);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Red");
        stringList.add("Red");
        stringList.add("Green");
        stringList.add("Blue");
        stringList.add("Blue");
        stringList.add("Yellow");
        stringList.add("Orange");

        ArrayList<String> noDuplicates = removeDuplicates(stringList);
        System.out.println(noDuplicates);
        noDuplicates = removeDuplicates2(stringList);
        System.out.println(noDuplicates);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        // check empty list
        if(list.size() == 0)
            return list;

        ArrayList<E> newList = new ArrayList<>();

        for(E e: list){
            // check duplicate
            if(newList.indexOf(e) == -1)
                newList.add(e);
        }
        return newList;
    }

    public static <E extends Comparable<E>> ArrayList<E> removeDuplicates2(ArrayList<E> list){
        // check empty list
        if(list.size() == 0) {
            return list;
        }

        ArrayList<E> newList = new ArrayList<>();
        Boolean found = false;

        for(E e1: list){
            for(E e2: newList){
                if(e1.compareTo(e2) == 0){
                    found = true;
                    break;
                }
            }
            if(!found){
                newList.add(e1);
            }
            found = false;
        }
        return newList;
    }

    public static class GenericList<T> implements GenericInterface<T> {
        public List<T> list = new ArrayList<>();

        @Override
        public void add(T t) {
            list.add(t);
        }
    }

    public interface GenericInterface<T> {
        void add(T t);
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] list, T e){
        int count = 0;
        for(T element:list) {
            if (element.compareTo(e) > 0)
                count++;
        }
        return count;
    }

    public static <E> void print(E[] list){
        for(E element:list)
            System.out.print(element + " ");
        System.out.println();
    }
}

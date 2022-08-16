package Lesson3_Java2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public abstract class Apple extends Fruit {
        public class apple extends Fruit {
            @Override
            float getWeight() {
                return 1.0f;
            }
        }
    }


    public class Banana extends Fruit {
        @Override
        float getWeight() {
            return 1.5f;
        }
    }

import java.util.ArrayList;
import java.util.Arrays;

    public class Box<T extends Fruit> {
        private ArrayList<T> box = new ArrayList<>();

        //    public Box(T...fruits){
//        box = new ArrayList<>(Arrays.asList(fruits));
//    }
        public Box() {

        }

        //почему нельзя переопределить метод getWeight в этом классе, если он
        //наследует Fruits?
        public float getWeight() {
            float weight = 0.0f;
//        почему цикл fori подчеркивает length?
//        for (int i = 0; i < box.length; i++) {}
            for (T o : box) {
                weight += o.getWeight();
            }
            return weight;
        }

        public boolean compare(Box anotherBox) {
            if (getWeight() == anotherBox.getWeight()) return true;
            return false;
        }

        public void pourTo(Box<T> anotherBox) {
            anotherBox.box.addAll(box);
            box.clear();
        }

        //еще способ добавить фрукты
        public void addFruit(T fruit, int amount) {
            for (int i = 0; i < amount; i++) {
                box.add(fruit);
            }
        }
    }


    public abstract class Fruit {
        abstract float getWeight();
    }


import java.util.ArrayList;
import java.util.Arrays;

    public class Main {

        public static void main(String[] args) {

            Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
            String arr2[] = {"A", "B", "C"};
            swap(arr1, 1, 4);
            swap(arr2, 0, 2);

            String[] arrayOfStrings = {"A", "B", "C", "D"};
            asList(arrayOfStrings);

            Box<Banana> or = new Box<>();
            Box<Banana> or1 = new Box<>();
            Box<Apple> ap = new Box<Apple>();
            Box<Apple> ap1 = new Box<>();
            System.out.println("Task3");
            System.out.println("'g' - addFruit: ");
            or.addFruit(new Banana(), 10);
            or1.addFruit(new Banana(), 12);
            ap.addFruit(new Apple() {
                @Override
                float getWeight() {
                    return 0;
                }
            }, 8);
            ap1.addFruit(new Apple() {
                @Override
                float getWeight() {
                    return 0;
                }
            }, 4);
            System.out.println("Box 1: " + or.getWeight());
            System.out.println("Box 2: " + or1.getWeight());
            System.out.println("Box 3: " + ap.getWeight());
            System.out.println("Box 4: " + ap1.getWeight());
            System.out.println("'e' - compare(): ");
            System.out.println("Box 1 equals box 3: " + or.compare(ap));
            System.out.println("Box 2 equals box 4: " + or1.compare(ap1));
            System.out.println("'f' - pourTo(): ");
            or.pourTo(or1);
            ap.pourTo(ap1);
            System.out.println("'d' - getWeight(): ");
            System.out.println("Box 1: " + or.getWeight());
            System.out.println("Box 2: " + or1.getWeight());
            System.out.println("Box 3: " + ap.getWeight());
            System.out.println("Box 4: " + ap1.getWeight());
        }

        public static void swap(Object[] arr, int n1, int n2) {
            System.out.println("Task1: " + Arrays.toString(arr));
            Object sw = arr[n1];
            arr[n1] = arr[n2];
            arr[n2] = sw;
            System.out.println("The result of the replacement: " + Arrays.toString(arr) + "\n================================");
        }

        public static <T> void asList(T[] arr) {

            ArrayList<T> alt = new ArrayList<>(Arrays.asList(arr));
            System.out.println("Task2 and the result of the conversion : " + alt + "\n================================");
        }
    }
}

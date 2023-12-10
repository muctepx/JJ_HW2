package org.example.HW2;


/*
Задача:
Создайте абстрактный класс "Animal" с полями "name" и "age".
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
Выведите на экран информацию о каждом объекте.
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.

Дополнительная задача:

Доработайте метод генерации запроса на удаление объекта из таблицы БД (DELETE FROM <Table> WHERE ID = '<id>')
В классе QueryBuilder который мы разработали на семинаре.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Animal[] animals = {new Cat("Barsic", 2, "Black"),
                new Dog("Sharic", 1, 0.8)};


        for (Animal animal : animals) {
            analyzeClass(animal);
            System.out.println();
        }
;
        System.out.print("Вызов метода makeSound у существующих классов:\n");
        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            try {
                Method checkMethod = clazz.getDeclaredMethod("makeSound");
                checkMethod.invoke(animal);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.out.print("У класса " + clazz.getSimpleName() + " нет такого метода\n");
            }
        }

    }


    public static void analyzeClass(Object o) {
        Class<?> clazz = o.getClass();
        System.out.println("Имя класса: " + clazz.getSimpleName());

        System.out.println("Поля класса: ");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("\t" + field.getName());
        }

        System.out.println("Родительский класс: " + clazz.getSuperclass().getSimpleName());

        System.out.println("Поля родительского класса: ");
        Field[] fieldz = clazz.getSuperclass().getDeclaredFields();
        for (Field field : fieldz) {
            System.out.println("\t" + field.getName());
        }

        System.out.println("Методы класса: ");

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("\t" + method.getName());
        }


    }
}
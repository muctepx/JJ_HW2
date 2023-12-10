package org.example.HW2;

public class Cat extends Animal{
    String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    private void walk(){
        System.out.println("Run");
    }

}

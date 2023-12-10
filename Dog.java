package org.example.HW2;

import javax.xml.namespace.QName;

public class Dog extends Animal{
    double height;

    public Dog(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    public void makeSound(){
        System.out.println("Dog Bark");
    }

}


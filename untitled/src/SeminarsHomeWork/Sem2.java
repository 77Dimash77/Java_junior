package SeminarsHomeWork;

import java.lang.reflect.Method;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

}

class Cat extends Animal {
    private boolean hasTail;

    public Cat(String name, int age, boolean hasTail) {
        super(name, age);
        this.hasTail = hasTail;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

}

public class Sem2 {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Buddy", 3, "Golden Retriever"),
                new Cat("Whiskers", 2, true)
        };

        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName());
            System.out.println("Age: " + animal.getAge());

            try {
                Method makeSoundMethod = animal.getClass().getMethod("makeSound");
                makeSoundMethod.invoke(animal);
            } catch (Exception e) {

                System.out.println("makeSound() method not found for " + animal.getClass().getSimpleName());
            }

            System.out.println();
        }
    }
}

// Parent class (Super class)
class Animal {
    String name;
    int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Common behaviors
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void breathe() {
        System.out.println(name + " is breathing.");
    }

    public void showDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Child class (Sub class)
class Dog extends Animal {

    // Constructor
    public Dog(String name, int age) {
        super(name, age); // Call parent constructor
    }

    // Dog-specific behavior
    public void bark() {
        System.out.println(name + " is barking.");
    }
}

public class A {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3);
        myDog.showDetails(); // Inherited
        myDog.eat();         // Inherited
        myDog.sleep();       // Inherited
        myDog.breathe();     // Inherited
        myDog.bark();        // Own method
    }
}

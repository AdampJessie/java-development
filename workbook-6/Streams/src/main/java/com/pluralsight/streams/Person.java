package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName, lastName;
    private int age;


    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  "| First Name: " + firstName + " | Last Name: " + lastName + " | Age: " + age + " |";
    }

    public static List<Person> getList(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Adam", "Jessie", 23));
        people.add(new Person("Judge", "Holden", 43));
        people.add(new Person("John", "Marston", 33));
        people.add(new Person("Jim", "Milton", 33));
        people.add(new Person("Micah", "Bell", 36));
        people.add(new Person("Javier", "Escuella", 31));
        people.add(new Person("Bill", "Williamson", 42));
        people.add(new Person("James", "Brown", 67));
        people.add(new Person("Terrence", "Fletcher", 53));
        people.add(new Person("Andrew", "Neyman", 21));

        return people;
    }

}

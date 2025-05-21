package com.pluralsight.streams;

import java.util.*;

public class Display {
    Scanner scanner = new Scanner(System.in);

    public void Menu(){

        MenuDisplay();

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                processSearchName();
                break;
            case 2:
                processAverageHighestLowest();
                break;
        }
    }
    public void MenuDisplay(){
        System.out.println("Hello!");
        System.out.println("=".repeat(50));
        System.out.println("1. Search for name (First/Last)");
        System.out.println("2. Show average, highest, and lowest");
        System.out.println("=".repeat(50));
        System.out.print("Please select an option (1/2): ");
    }
    public void processSearchName(){
        System.out.print("Please enter a first OR last name to search: ");
        String name = scanner.nextLine();

        System.out.println("=".repeat(50));
        List<Person> results = searchName(name);
        if (!results.isEmpty())
            for (Person result : results) {
                System.out.println(result);
            }
        System.out.println("=".repeat(50));

    }
    public void processAverageHighestLowest(){
        System.out.println("=".repeat(50));
        averageHighestLowest(Person.getList());
        System.out.println("=".repeat(50));
    }
    public List<Person> searchName(String name){
        List<Person> results = new ArrayList<>();
        for (Person i : Person.getList()) {
            if (name.equalsIgnoreCase(i.getFirstName()) || name.equalsIgnoreCase(i.getLastName()))
                results.add(i);
        }
        return results;
    }

    public void averageHighestLowest(List<Person> people){

        double ageTotal = 0;
        int ageHighest = Integer.MIN_VALUE;
        int ageLowest = Integer.MAX_VALUE;

        for (Person person : people) {
            int age = person.getAge();
            ageTotal += age;

            if (age > ageHighest) ageHighest = age;
            if (age < ageLowest) ageLowest = age;
        }

        double ageAverage = ageTotal / people.size();
        System.out.printf("Average Age: %.0f\nHighest Age: %d\nLowest Age: %d\n",
                            ageAverage, ageHighest, ageLowest);

    }

}

package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {

        // Question 1:
        double bobSalary = (Math.random()) * 100000;
        double garySalary = (Math.random()) * 100000;

        double highestSalary = Math.max(bobSalary, garySalary);
        System.out.printf("Highest salary is:\t%.2f$\n", highestSalary);

        // Question 2:
        double carPrice = (Math.random()) * 100000;
        double truckPrice = (Math.random()) * 100000;

        double lowestPrice = Math.max(carPrice, truckPrice);
        System.out.printf("Lowest price is:\t%.2f$\n", lowestPrice);

        // Question 3:
        double circleRadius = 7.25;
        System.out.println("Circle Area:\t"+ ((Math.pow(circleRadius, 2)) * Math.PI));

        // Question 4:
        double sqrtTarget = 5;
        System.out.println("Square Root:\t"+Math.sqrt(sqrtTarget));

        // Question 5:
        int x1 = 5,y1 = 10 , x2 = 85,y2 = 50;

        // Distance Formula (Drawn Out)
        System.out.println("Distance Between Points (Formula):\t\t"+Math.sqrt((Math.pow(x2-x1, 2)) + Math.pow(y2-y1, 2)));

        // Math.hypot (Quick/Easy)
        int x3 = 5, y3 = 10, x4 = 85, y4 = 50;
        System.out.println("Distance Between Points (Hypotenuse):\t" + Math.hypot(x3 - x4, y3 - y4));

        // Question 6:
        double absTarget = 3.8;
        System.out.println("Absolute Value:\t\t\t"+Math.abs(absTarget));

        // Question 7:
        System.out.println("Random Number (0-1):\t"+Math.random());


    }
}

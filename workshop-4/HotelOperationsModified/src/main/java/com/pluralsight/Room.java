package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = false;
        this.isDirty = false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }


    // Modified Room with checking and cleaning.
    public void checkIn(){
        if (!isOccupied && !isDirty) {
            isDirty = true;
            isOccupied = true;
        }
    }
    public void checkOut (){
        isOccupied = false;
    }

    public void cleanRoom (){
        if (isAvailable())
            isDirty = false;
    }

}
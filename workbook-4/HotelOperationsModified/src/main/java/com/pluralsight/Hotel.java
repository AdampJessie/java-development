package com.pluralsight;

public class Hotel {

    private String name;
    private int numberOfSuites, numberOfRooms, bookedSuites = 0, bookedBasicRooms = 0;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedRooms() {
        return bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        /*if (numberOfRooms<=0) return false;
        if (isSuite)
            if(getAvailableSuites() <= numberOfRooms) {
                bookedSuites += numberOfRooms;
                return true;
        }*/// Completed with instructor after exercise.

        return false;
    }


    public int getAvailableSuites() {
        return numberOfSuites-bookedSuites;
    }
    public int getAvailableRooms() {
        return numberOfRooms-bookedBasicRooms;
    }



}

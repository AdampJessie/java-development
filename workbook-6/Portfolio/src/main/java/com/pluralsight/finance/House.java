package com.pluralsight.finance;

public class House  extends FixedAsset{

    private int yearBuild, squareFeet, bedrooms;

    public House(String name, double value, int yearBuild, int squareFeet, int bedrooms) {
        super(name, value);
        this.yearBuild = yearBuild;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    @Override
    public double getValue() {
        return 0;
    }
}



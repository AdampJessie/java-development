package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Portfolio {

    private String name, owner;
    List<Valuable> assets = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Valuable asset){
        assets.add(asset);
    }
    public double getValue(){

        double value = 0;
        for (Valuable asset : assets ) {
            value += asset.getValue();
        }
        return value;
    }

    public Valuable getMostValuable(){

        Valuable mostValuable = null;
        for (Valuable asset: assets){
            if (mostValuable == null || asset.getValue() > mostValuable.getValue()){
                mostValuable = asset;
            }
        }
        return mostValuable;



    }

    public Valuable getLeastValuable(){

        Valuable leastValuable = null;


        for (Valuable asset: assets){
            if (leastValuable == null || asset.getValue() < leastValuable.getValue()){
                leastValuable = asset;
            }

        }
        return leastValuable;

    }



}

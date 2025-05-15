package com.pluralsight.finance;

public class Jewelry  extends FixedAsset{

    private final double karat;

    public Jewelry(String name, double value, double karat) {
        super(name, value);
        this.karat = karat;
    }

    public double getKarat() {
        return karat;
    }

    @Override
    public double getValue() {
        return value;
    }
}

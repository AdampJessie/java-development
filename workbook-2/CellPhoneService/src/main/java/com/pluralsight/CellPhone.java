package com.pluralsight;

public class CellPhone {

    public CellPhone() {
        this.model = "";
        this.carrier = "";
        this.owner = "";
        this.serialNumber = 0;
        this.phoneNumber = "";
    }

    private String model = "" , carrier = "" , phoneNumber = "" , owner = "";
    private int serialNumber = 0;

    public int getSerialNumber() {return serialNumber;}

    public void setSerialNumber(int serialNumber) {this.serialNumber = serialNumber;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public String getCarrier() {return carrier;}

    public void setCarrier(String carrier) {this.carrier = carrier;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getOwner() {return owner;}

    public void setOwner(String owner) {this.owner = owner;}
}

package com.pluralsight;

public class Employee {

    private int employeeId, hoursWorked;
    private double  payRate;
    private String name, department;

    public Employee(int employeeId, int hoursWorked, double payRate, String name, String department) {
        this.employeeId = employeeId;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
        this.name = name;
        this.department = department;
    }

    public double getTotalPay(){

        return (payRate * getRegularHours()) + (payRate * 1.5 * getOvertimeHours());

    }

    public int getRegularHours() {
        if (hoursWorked < 40)
            return hoursWorked;
        else return 40;
    }

    public int getOvertimeHours(){
        if (hoursWorked > 40)
            return hoursWorked - 40;
        else return 0;
    }



















}

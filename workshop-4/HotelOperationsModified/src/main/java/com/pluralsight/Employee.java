package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            return (40 * payRate) + ((hoursWorked - 40) * (payRate * 1.5));
        }
    }

/*    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }*/


    public double getRegularHours() {
        if (hoursWorked <= 40) {
            return hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (hoursWorked > 40) {
            return hoursWorked - 40;
        } else {
            return 0;
        }

    }
    // Modified punch cards
    private double startTime;
    public void punchIn(double time){
        startTime = time;
    }
    public void punchOut(double time){
        hoursWorked += (time - startTime);
    }
    public void timeCard(double time) {
        if (startTime == 0)
            startTime = time;
        else hoursWorked += (time - startTime);
    }
    public void timePunchCard(double startTime, double endTime){
        this.hoursWorked += (endTime-startTime);
    }


    // Overloaded methods
    public void punchIn(){
        LocalDateTime now = LocalDateTime.now();
        double hour = now.getHour();
        double minute = now.getMinute();
        startTime = hour + (minute/60);
    }
    public void punchOut(){

        LocalDateTime now = LocalDateTime.now();
        double hour = now.getHour();
        double minute = now.getMinute();
        double time = hour + (minute/60);

        hoursWorked += (time - startTime);
    }


}
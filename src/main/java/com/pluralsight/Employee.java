package com.pluralsight;

public class Employee {
    private int employeeID;
    private String name;
    private double hoursWorked, payRate;

    public Employee(int employeeID,String name, double hoursWorked, double payRate){
        this.employeeID = employeeID;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate=payRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    // gross pay
    public static double getGrossPay(double payRate,double hoursWorked){
        return payRate*hoursWorked;
    }
}

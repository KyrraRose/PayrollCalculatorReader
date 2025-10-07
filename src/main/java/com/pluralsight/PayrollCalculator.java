package com.pluralsight;

import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);


            String data;
            while((data = buffReader.readLine())!=null){
                String[] employeeData = data.split("|");
                for(int i = 1;i < employeeData.length; i++){
                    int employeeID = Integer.parseInt(employeeData[0]);

                    Employee employee = new Employee(,employeeData[1],Double.parseDouble(employeeData[2]),Double.parseDouble(employeeData[3]));
                    double payRate = employee.getPayRate();
                    double hoursWorked = employee.getHoursWorked();

                    System.out.printf("%s is paid at a rate of $%.2d an hour.\nGross Pay: $%.2d",employee.getName(),employee.getPayRate(),employee.getGrossPay(payRate,hoursWorked));
                }


            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

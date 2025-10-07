package com.pluralsight;

import java.io.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader buffReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("src/main/resources/payrolltest.csv");
            BufferedWriter buffWriter = new BufferedWriter(fileWriter);
            buffWriter.write("id|name|gross pay");


            String data;
            while((data = buffReader.readLine())!=null){
                String[] employeeData = data.split("\\|");
                if(!employeeData[0].equals("id")){
                    int employeeID = Integer.parseInt(employeeData[0]);
                    String name = employeeData[1];
                    double payRate = Double.parseDouble(employeeData[3]);
                    double hoursWorked = Double.parseDouble(employeeData[2]);

                    Employee employee = new Employee(employeeID,name,hoursWorked,payRate);


                    System.out.printf("ID: %d\nName: %s\nGross Pay: $%.2f\n---\n",employee.getEmployeeID(),employee.getName(),employee.getGrossPay());
                }


            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

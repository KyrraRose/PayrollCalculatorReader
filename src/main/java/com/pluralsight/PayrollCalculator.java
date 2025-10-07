package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        try{
            Scanner keyboard = new Scanner(System.in);

            System.out.print("\n=== Welcome to Patricia's Payroll Processor! ===\n");

            while(true){
                System.out.print("What is the name of the file you would like to process?\nType Here: ");
                String fileName = keyboard.nextLine();
                System.out.printf("Got it! Pulling up %s\n---\n",fileName);

                FileReader fileReader = new FileReader("src/main/resources/"+fileName);
                BufferedReader buffReader = new BufferedReader(fileReader);

                System.out.print("What would you like to save the file as?\nType Here: ");
                String saveAs = keyboard.nextLine();
                FileWriter fileWriter = new FileWriter("src/main/resources/"+saveAs);
                BufferedWriter buffWriter = new BufferedWriter(fileWriter);


                String data;
                System.out.print("Are you saving the file as:\n[C] CSV\n[J] JSON\n---\nType Here: ");
                String fileType = keyboard.nextLine().trim().toUpperCase();
                int i = 0;

                    switch (fileType) {
                        case "C":
                            System.out.println("\nSaving the file formatted as a .csv!");
                            buffWriter.write("id|name|gross pay");
                            buffWriter.newLine();
                            while((data = buffReader.readLine())!=null) {
                                String[] employeeData = data.split("\\|");
                                if (!employeeData[0].equals("id")) {
                                    int employeeID = Integer.parseInt(employeeData[0]);
                                    String name = employeeData[1];
                                    double payRate = Double.parseDouble(employeeData[3]);
                                    double hoursWorked = Double.parseDouble(employeeData[2]);
                                    Employee employee = new Employee(employeeID, name, hoursWorked, payRate);

                                    buffWriter.write(employee.getEmployeeID() + "|" + employee.getName() + "|" + employee.getGrossPay());
                                    buffWriter.newLine();

                                }
                            }

                            break;
                        case "J":
                            System.out.println("\nSaving the file formatted as a .json!");
                            buffWriter.write("[\n");
                            buffWriter.newLine();
                            Employee[] newEmployeeArray = new Employee[9];
                            //adjust this when adding, I will learn a better way later
                            while((data = buffReader.readLine())!=null) {
                                String[] employeeData = data.split("\\|");

                                if (!employeeData[0].equals("id")) {
                                    int employeeID = Integer.parseInt(employeeData[0]);
                                    String name = employeeData[1];
                                    double payRate = Double.parseDouble(employeeData[3]);
                                    double hoursWorked = Double.parseDouble(employeeData[2]);
                                    i++;

                                    Employee employee = new Employee(employeeID, name, hoursWorked, payRate);
                                    if (i < newEmployeeArray.length-1) {
                                        buffWriter.write("{ \"id\":" + employee.getEmployeeID() + ",\"name\":\"" + employee.getName() + "\",\"gross pay\":" + employee.getGrossPay() + "},");
                                        buffWriter.newLine();
                                    } else {
                                        buffWriter.write("{ \"id\":" + employee.getEmployeeID() + ",\"name\":\"" + employee.getName() + "\",\"gross pay\":" + employee.getGrossPay() + "}");
                                        buffWriter.newLine();
                                        buffWriter.write("]");

                                    }

                                }
                            }
                            break;

                        default:
                            System.out.println("I didn't recognize that command.\nPress [ENTER] to try again.");
                            keyboard.nextLine();
                    }


                buffWriter.close();

                System.out.printf("\n---\nFile written and saved as %s!\nDo you have another file to process?\n[Y] Yes\n[N] No\nType Here: ",saveAs);
                String keepGoing = keyboard.nextLine().trim().toUpperCase();
                switch (keepGoing){
                    case "N":
                        System.out.println("---\nExiting!");
                        System.exit(0);
                        break;
                }
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

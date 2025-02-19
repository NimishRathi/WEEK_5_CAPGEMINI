package org.example;

import java.io.*;
import java.util.*;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        // Path to the employees CSV file
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\employee.csv";  // Update the path if necessary

        // List to store employee records
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;  // Flag to skip the header row

            // Read the CSV file line by line
            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                // Split each line into columns and add it to the list
                String[] columns = line.split(",");
                employees.add(columns);
            }

            // Sort the employee records by salary (descending order)
            employees.sort((emp1, emp2) -> {
                double salary1 = Double.parseDouble(emp1[3].trim());
                double salary2 = Double.parseDouble(emp2[3].trim());
                return Double.compare(salary2, salary1); // Descending order
            });

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest Paid Employees:");
            System.out.println("ID | Name | Department | Salary");

            // Loop through the sorted list and print the top 5 employees
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                String[] employee = employees.get(i);
                System.out.println(String.join(" | ", employee[0], employee[1], employee[2], employee[3]));
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


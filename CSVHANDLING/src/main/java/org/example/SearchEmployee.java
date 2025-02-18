package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        // Path to the employees CSV file
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\employee.csv"; // Change path if necessary

        // Initialize a scanner to read the employee name from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false; // To check if the employee is found

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // To skip header row

            // Read each line from the CSV file
            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split each line by comma
                String[] columns = line.split(",");

                // Get the employee's name from the CSV file (assuming it's the second column)
                String name = columns[1].trim();

                // Check if the entered name matches the current employee's name
                if (name.equalsIgnoreCase(searchName)) {
                    // Print department and salary if found
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary: " + columns[3]);
                    found = true;
                    break; // Exit the loop once the employee is found
                }
            }

            // If the employee was not found
            if (!found) {
                System.out.println("Employee with name '" + searchName + "' not found.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        scanner.close(); // Close the scanner resource
    }
}

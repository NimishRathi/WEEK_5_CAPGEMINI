package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RecordInCSV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Path to the CSV file
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\employee.csv"; // Change the path if needed

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // To skip the header row
            String searchname = sc.nextLine();

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");
                // Parse marks to an integer
                String name = columns[3].trim();
                // Filter students with marks > 80
                if (name.equalsIgnoreCase(searchname)){
                    System.out.println("Department: " + columns[2]);
                    System.out.println("Salary " + columns[3]);
                    System.out.println("-------");
                }
            }
        }
        catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in CSV file.");
        }
    }
}

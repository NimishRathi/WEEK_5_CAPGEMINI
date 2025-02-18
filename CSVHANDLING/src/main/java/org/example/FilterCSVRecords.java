package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSVRecords {
    public static void main(String[] args) {
        // Path to the CSV file
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\Marks.csv"; // Change the path if needed

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // To skip the header row
            String name;

            System.out.println("Students who scored more than 80 marks:");
            System.out.println("------");

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");

                // Parse marks to an integer
                int marks = Integer.parseInt(columns[3].trim());

                // Filter students with marks > 80
                if (marks > 80) {
                    System.out.println("ID: " + columns[0]);
                    System.out.println("Name: " + columns[1]);
                    System.out.println("Age: " + columns[2]);
                    System.out.println("Marks: " + columns[3]);
                    System.out.println("-------");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in CSV file.");
        }
    }
}

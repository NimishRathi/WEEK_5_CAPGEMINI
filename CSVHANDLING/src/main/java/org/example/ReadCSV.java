package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\students.csv"; // Change this path as needed

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // To skip the first row (header)

            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Split the line into columns using a comma as the delimiter
                String[] columns = line.split(",");

                // Print student details in a structured format
                System.out.println("ID: " + columns[0]);
                System.out.println("Name: " + columns[1]);
                System.out.println("Age: " + columns[2]);
                System.out.println("Marks: " + columns[3]);
                System.out.println("-----");
            }
        } catch (IOException e) {
            // Handle file reading errors
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

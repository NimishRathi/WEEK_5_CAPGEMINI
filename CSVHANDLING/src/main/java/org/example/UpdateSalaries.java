package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateSalaries {
    public static void main(String[] args) {
        // Path to the input CSV file
        String inputFile = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\employee.csv";  // Update the path if necessary
        String outputFile = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\modifiedOutput.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean isHeader = true;  // To handle header row

            // Read the input file line by line
            while ((line = br.readLine()) != null) {
                // Skip the header row
                if (isHeader) {
                    bw.write(line);  // Write header to the output file
                    bw.newLine();
                    isHeader = false;
                    continue;
                }

                // Split the line into columns
                String[] columns = line.split(",");

                // Check if the employee is from the IT department
                if ("IT".equalsIgnoreCase(columns[2].trim())) {
                    // Get the current salary and increase by 10%
                    double salary = Double.parseDouble(columns[3].trim());
                    salary += salary * 0.10;  // Increase by 10%

                    // Update the salary in the columns array
                    columns[3] = String.format("%.2f", salary);  // Format the salary to two decimal places
                }

                // Write the updated line to the new CSV file
                bw.write(String.join(",", columns));
                bw.newLine();
            }

            System.out.println("Salaries updated successfully and saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        }
    }
}

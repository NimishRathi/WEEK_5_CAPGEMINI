package org.example;

import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\CSV_Gmail";  // Update with the actual path of your CSV file

        // Regular expressions for validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";  // Email validation
        String phoneRegex = "^\\d{10}$";  // Phone number should have exactly 10 digits

        // Compile regex patterns
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            System.out.println("Invalid Rows:");
            while ((line = br.readLine()) != null) {
                if (isHeader) {  // Skip the header row
                    isHeader = false;
                    continue;
                }
                String[]columns = line.split(",");

                // Assuming columns are: ID, Name, Email, Phone, Department, Salary
                String email = columns[2].trim();  // Email column
                String phone = columns[3].trim();  // Phone Number column

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                // Print invalid rows with an error message
                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Error in row: " + line);
                    if (!isEmailValid) {
                        System.out.println("   -> Invalid Email: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("   -> Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

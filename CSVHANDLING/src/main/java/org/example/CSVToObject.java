package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Override toString() to print Student objects
    @Override
    public String toString() {
        return "Student{ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + "}";
    }
}

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\JavaObjects"; // Update with the actual path of your CSV file
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            // Read CSV file line by line
            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");

                // Parse data into a Student object
                int id = Integer.parseInt(columns[0].trim());
                String name = columns[1].trim();
                int age = Integer.parseInt(columns[2].trim());
                double marks = Double.parseDouble(columns[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // Print all student objects
        System.out.println("Students List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

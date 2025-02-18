    package org.example;

    import com.opencsv.CSVWriter;
    import java.io.FileWriter;
    import java.io.IOException;
    public class WriteCSVOpenCSV {
        public static void main(String[] args) {
            try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\nimis\\IdeaProjects\\Day24\\src\\main\\java\\org\\example\\output.csv"))) {
                String[] header = {"ID", "Name", "Department", "Salary"};
                String[] emp1 = {"104", "Alice Williams", "Finance", "62000"};
                String[] emp2 = {"105", "Bob Johnson", "Sales", "58000"};
                String[] emp3 = {"106", "Bob Johnson", "Sales", "58000"};
                String[] emp4 = {"107", "Bob Johnson", "Sales", "5800"};
                String[] emp5 = {"108", "Bob Johnson", "Sales", "5000"};
                writer.writeNext(header);
                writer.writeNext(emp1);
                writer.writeNext(emp2);
                writer.writeNext(emp3);
                writer.writeNext(emp4);
                writer.writeNext(emp5);
                System.out.println("CSV file written successfully using OpenCSV!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


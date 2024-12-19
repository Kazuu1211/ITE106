import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Employee {
    private String name;
    private String id;
    private double hourlyWage;
    private double hoursWorked;
    private double overtimeHours;
    private double deductions;

    // Constructor
    public Employee(String name, String id, double hourlyWage, double hoursWorked, double overtimeHours, double deductions) {
        this.name = name;
        this.id = id;
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
        this.overtimeHours = overtimeHours;
        this.deductions = deductions;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getDeductions() {
        return deductions;
    }

    // Method to calculate regular salary (for up to 40 hours)
    public double calculateRegularSalary() {
        return Math.min(hoursWorked, 40) * hourlyWage;
    }

    // Method to calculate overtime pay
    public double calculateOvertimePay() {
        return overtimeHours * hourlyWage * 1.5;
    }

    // Method to calculate total salary
    public double calculateTotalSalary() {
        return calculateRegularSalary() + calculateOvertimePay() - deductions;
    }

    // Convert employee data to a string format (for file writing)
    public String toString() {
        return name + "," + id + "," + hourlyWage + "," + hoursWorked + "," + overtimeHours + "," + deductions;
    }

    // Static method to create an Employee object from a string (for file reading)
    public static Employee fromString(String data) {
        String[] parts = data.split(",");
        return new Employee(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]),
                Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
    }
}

public class PayrollSystemGUI {
    private JFrame frame;
    private JTextField nameField, idField, hourlyWageField, hoursWorkedField, overtimeField, deductionsField;
    private JTextArea resultArea;
    private JButton calculateButton, saveButton, loadButton, displayButton;
    private List<Employee> employeeList = new ArrayList<>();

    public PayrollSystemGUI() {
        // Initialize frame
        frame = new JFrame("Payroll System");
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and arrange components
        nameField = createInputField("Name:");
        idField = createInputField("ID:");
        hourlyWageField = createInputField("Hourly Wage (in Pesos):");
        hoursWorkedField = createInputField("Hours Worked:");
        overtimeField = createInputField("Overtime Hours:");
        deductionsField = createInputField("Deductions (in Pesos):");

        // Text Area for displaying results
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        frame.add(scrollPane);

        // Buttons
        calculateButton = new JButton("Calculate Payroll");
        saveButton = new JButton("Save Employee");
        loadButton = new JButton("Load Employees");
        displayButton = new JButton("Display All Employees");

        // Add components to the frame
        frame.add(calculateButton);
        frame.add(saveButton);
        frame.add(loadButton);
        frame.add(displayButton);

        // Action listeners for buttons
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculatePayroll();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveEmployeeData();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadEmployeeData();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayEmployeeList();
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }

    // Helper method to create labeled input fields
    private JTextField createInputField(String label) {
        JLabel jLabel = new JLabel(label);
        JTextField textField = new JTextField(20);
        frame.add(jLabel);
        frame.add(textField);
        return textField;
    }

    // Method to calculate payroll and display results
    private void calculatePayroll() {
        try {
            String name = nameField.getText();
            String id = idField.getText();
            double hourlyWage = Double.parseDouble(hourlyWageField.getText());
            double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
            double overtime = Double.parseDouble(overtimeField.getText());
            double deductions = Double.parseDouble(deductionsField.getText());

            Employee employee = new Employee(name, id, hourlyWage, hoursWorked, overtime, deductions);
            double totalSalary = employee.calculateTotalSalary();

            // Display results in Pesos
            resultArea.setText("Employee: " + name + "\n" +
                    "ID: " + id + "\n" +
                    "Regular Salary: ₱" + String.format("%.2f", employee.calculateRegularSalary()) + "\n" +
                    "Overtime Pay: ₱" + String.format("%.2f", employee.calculateOvertimePay()) + "\n" +
                    "Deductions: ₱" + String.format("%.2f", deductions) + "\n" +
                    "Total Salary: ₱" + String.format("%.2f", totalSalary));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for all fields.");
        }
    }

    // Method to save employee data to a text file
    private void saveEmployeeData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", true))) {
            String data = new Employee(
                    nameField.getText(),
                    idField.getText(),
                    Double.parseDouble(hourlyWageField.getText()),
                    Double.parseDouble(hoursWorkedField.getText()),
                    Double.parseDouble(overtimeField.getText()),
                    Double.parseDouble(deductionsField.getText())
            ).toString();
            writer.write(data);
            writer.newLine();
            JOptionPane.showMessageDialog(frame, "Employee saved successfully!");
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error saving employee data. Please try again.");
        }
    }

    // Method to load employee data from the file
    private void loadEmployeeData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            employeeList.clear();
            while ((line = reader.readLine()) != null) {
                Employee employee = Employee.fromString(line);
                employeeList.add(employee);
            }
            JOptionPane.showMessageDialog(frame, "Employees loaded successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading employee data.");
        }
    }

    // Method to display all loaded employees
    private void displayEmployeeList() {
        StringBuilder sb = new StringBuilder("Employee List:\n");
        for (Employee emp : employeeList) {
            sb.append("Name: ").append(emp.getName())
                    .append(", ID: ").append(emp.getId())
                    .append("\n");
        }
        resultArea.setText(sb.toString());
    }

    // Main method to start the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PayrollSystemGUI();
            }
        });
    }
}

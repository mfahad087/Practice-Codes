// Java Programming for Book Hierarchy + Employee Hierarchy + Hourly Employee Subclass

import java.util.Scanner;

// ===== Task 1: Book Hierarchy =====

// Parent Class for all types of Books
class Book {
    // Common attributes for all books
    String title;
    int publishYear;
    String author;

    // Constructor to initialize Book attributes
    public Book(String title, int publishYear, String author) {
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
    }

    // Overriding toString() method to display book details
    @Override
    public String toString() {
        return "Title: " + title + ", Year: " + publishYear + ", Author: " + author;
    }
}

// Subclass for Printed Books (inherits Book class)
class PrintBook extends Book {
    // Additional attributes
    String publisher;
    String isbn;

    // Constructor to initialize PrintBook attributes
    public PrintBook(String title, int publishYear, String author, String publisher, String isbn) {
        super(title, publishYear, author); // Calling parent constructor
        this.publisher = publisher;
        this.isbn = isbn;
    }

    // Overriding toString() to add more details
    @Override
    public String toString() {
        return super.toString() + ", Publisher: " + publisher + ", ISBN: " + isbn;
    }
}

// Subclass for Audio Books (inherits Book class)
class AudioBook extends Book {
    // Additional attributes
    double sizeInMB;
    double playLengthInHours;
    String narrator;

    // Constructor to initialize AudioBook attributes
    public AudioBook(String title, int publishYear, String author, double sizeInMB, double playLengthInHours, String narrator) {
        super(title, publishYear, author);
        this.sizeInMB = sizeInMB;
        this.playLengthInHours = playLengthInHours;
        this.narrator = narrator;
    }

    // Overriding toString() to add more details
    @Override
    public String toString() {
        return super.toString() + ", Size: " + sizeInMB + " MB, Length: " + playLengthInHours + " Hours, Narrator: " + narrator;
    }
}

// ===== Task 2 & 3: Employee Hierarchy =====

// Parent Employee Class
class Employee {
    // Common attributes of all employees (Encapsulation applied - private)
    private String firstName;
    private String lastName;
    private String ssn; // Social Security Number

    // Constructor to initialize Employee attributes
    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    // Getter methods (to access private variables)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSSN() {
        return ssn;
    }

    // Overriding toString() to display employee details
    @Override
    public String toString() {
        return "Employee: " + firstName + " " + lastName + ", SSN: " + ssn;
    }
}

// Commission Employee Subclass (inherits Employee)
class CommissionEmployee extends Employee {
    // Additional attributes specific to commission employees
    private double sales;
    private double commissionRate;

    // Constructor to initialize CommissionEmployee attributes
    public CommissionEmployee(String firstName, String lastName, String ssn, double sales, double commissionRate) {
        super(firstName, lastName, ssn); // Call parent constructor
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    // Method to calculate earnings
    public double earnings() {
        return sales * commissionRate;
    }

    // Overriding toString() to add commission details
    @Override
    public String toString() {
        return super.toString() + ", Sales: " + sales + ", Rate: " + commissionRate;
    }
}

// Base Plus Commission Employee (Multilevel Inheritance Example)
class BasePlusCommissionEmployee extends CommissionEmployee {
    // Extra attribute
    private double baseSalary;

    // Constructor to initialize BasePlusCommissionEmployee attributes
    public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, double sales, double commissionRate, double baseSalary) {
        super(firstName, lastName, ssn, sales, commissionRate);
        this.baseSalary = baseSalary;
    }

    // Method to calculate total earnings
    public double totalEarnings() {
        return baseSalary + earnings();
    }

    // Overriding toString() to add base salary detail
    @Override
    public String toString() {
        return super.toString() + ", Base Salary: " + baseSalary;
    }
}

// Hourly Employee Subclass (Task 3)
class HourlyEmployee extends Employee {
    // Attributes specific to hourly employees
    private double hoursWorked;
    private double hourlyWage;

    // Constructor to initialize HourlyEmployee attributes with validation
    public HourlyEmployee(String firstName, String lastName, String ssn, double hourlyWage, double hoursWorked) {
        super(firstName, lastName, ssn);
        // Validation of wage
        if (hourlyWage < 0) {
            this.hourlyWage = 0;
        } else {
            this.hourlyWage = hourlyWage;
        }
        // Validation of working hours (Max hours in a week = 168)
        if (hoursWorked >= 0 && hoursWorked <= 168) {
            this.hoursWorked = hoursWorked;
        } else {
            this.hoursWorked = 0;
        }
    }

    // Getter & Setter for wage
    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        if (hourlyWage >= 0) {
            this.hourlyWage = hourlyWage;
        }
    }

    // Getter & Setter for hours
    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0 && hoursWorked <= 168) {
            this.hoursWorked = hoursWorked;
        }
    }

    // Method to calculate earnings (overtime rule applied)
    public double earnings() {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyWage;
        } else {
            return (40 * hourlyWage) + ((hoursWorked - 40) * hourlyWage * 1.5);
        }
    }

    // Overriding toString() to show details
    @Override
    public String toString() {
        return super.toString() + ", Hours Worked: " + hoursWorked + ", Wage per Hour: " + hourlyWage;
    }
}


// ===== Main Application Class =====
public class AssignmentAllTasks {
    public static void main(String[] args) {

        // ===== Task 1 Output =====
        System.out.println("=== Book Hierarchy ===");
        PrintBook printedBook = new PrintBook("The Alchemist", 1988, "Paulo Coelho", "HarperCollins", "978-0061122415");
        AudioBook audioBook = new AudioBook("Atomic Habits", 2018, "James Clear", 120.5, 5.2, "James Clear");

        System.out.println(printedBook.toString());
        System.out.println(audioBook.toString());

        // ===== Task 2 Output =====
        System.out.println("\n=== Employee Hierarchy ===");
        CommissionEmployee emp1 = new CommissionEmployee("Hasan ", "Raza", "24011598-137", 50000, 0.10);
        BasePlusCommissionEmployee emp2 = new BasePlusCommissionEmployee("Taha", "Mirza", "24011598-138", 40000, 0.08, 5000);

        System.out.println(emp1.toString());
        System.out.println("Earnings: $" + emp1.earnings());
        System.out.println(emp2.toString());
        System.out.println("Total Earnings: $" + emp2.totalEarnings());

        // ===== Task 3 Output =====
        System.out.println("\n=== Hourly Employee ===");
        HourlyEmployee hourlyEmp = new HourlyEmployee("Muhammad ", "Fahad", "24011598-200", 800, 45);
        System.out.println(hourlyEmp.toString());
        System.out.println("Earnings: $" + hourlyEmp.earnings());
    }
}

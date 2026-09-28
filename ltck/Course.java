/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class Course implements ICourse {

    private String id;
    private double feePerStudent;
    private Date startDate;
    private boolean isAvailable;
    private int enrolledStudents;

    protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Course() {
    }

    public Course(String id, double feePerStudent, Date startDate, boolean isAvailable, int enrolledStudents) {
        this.id = id;
        this.feePerStudent = feePerStudent;
        this.startDate = startDate;
        this.isAvailable = isAvailable;
        this.enrolledStudents = enrolledStudents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getFeePerStudent() {
        return feePerStudent;
    }

    public void setFeePerStudent(double feePerStudent) {
        this.feePerStudent = feePerStudent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public void addCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Course ID: ");
        this.id = sc.nextLine();

        System.out.print("Enter fee per student: ");
        this.feePerStudent = Double.parseDouble(sc.nextLine());

        System.out.print("Enter start date (dd/MM/yyyy): ");
        String dateStr = sc.nextLine();
        try {
            this.startDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Setting to current date by default.");
            this.startDate = new Date();
        }

        System.out.print("Is enrollment open? (true/false): ");
        this.isAvailable = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Enter number of enrolled students: ");
        this.enrolledStudents = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void updateCourse() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update fee per student: ");
        this.feePerStudent = Double.parseDouble(sc.nextLine());

        System.out.print("Update start date (dd/MM/yyyy): ");
        String dateStr = sc.nextLine();
        try {
            this.startDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Keeping existing date.");
        }

        System.out.print("Update availability status (true/false): ");
        this.isAvailable = Boolean.parseBoolean(sc.nextLine());

        System.out.print("Update number of enrolled students: ");
        this.enrolledStudents = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void displayDetails() {
        System.out.println("Course ID: " + id);
        System.out.println("Fee per student: " + feePerStudent);
        System.out.println("Start date: " + (startDate != null ? dateFormat.format(startDate) : "N/A"));
        System.out.println("Is available: " + isAvailable);
        System.out.println("Enrolled students: " + enrolledStudents);
    }
}

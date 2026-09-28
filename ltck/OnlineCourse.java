/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltck;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class OnlineCourse extends Course {

    private String platformName;
    private double discountPercent;

    public OnlineCourse() {
        super();
    }

    public OnlineCourse(String id, double feePerStudent, Date startDate, boolean isAvailable, int enrolledStudents, String platformName, double discountPercent) {
        super(id, feePerStudent, startDate, isAvailable, enrolledStudents);
        this.platformName = platformName;
        this.discountPercent = discountPercent;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public void addCourse() {
        super.addCourse();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter platform name: ");
        this.platformName = sc.nextLine();
        System.out.print("Enter discount percent (%): ");
        this.discountPercent = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void updateCourse() {
        super.updateCourse();
        Scanner sc = new Scanner(System.in);
        System.out.print("Update platform name: ");
        this.platformName = sc.nextLine();
        System.out.print("Update discount percent (%): ");
        this.discountPercent = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double calculateTotalFee() {
        return getFeePerStudent() * getEnrolledStudents() * (1.0 - discountPercent / 100.0);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course Type: Online");
        System.out.println("Platform name: " + platformName);
        System.out.println("Discount percent: " + discountPercent + "%");
        System.out.println("Total fee: " + calculateTotalFee());
    }
}

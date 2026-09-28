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
public abstract class OfflineCourse extends Course {

    private String classroomNumber;
    private double materialFeePerStudent;

    public OfflineCourse() {
        super();
    }

    public OfflineCourse(String id, double feePerStudent, Date startDate, boolean isAvailable, int enrolledStudents, String classroomNumber, double materialFeePerStudent) {
        super(id, feePerStudent, startDate, isAvailable, enrolledStudents);
        this.classroomNumber = classroomNumber;
        this.materialFeePerStudent = materialFeePerStudent;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public double getMaterialFeePerStudent() {
        return materialFeePerStudent;
    }

    public void setMaterialFeePerStudent(double materialFeePerStudent) {
        this.materialFeePerStudent = materialFeePerStudent;
    }

    @Override
    public void addCourse() {
        super.addCourse();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter classroom number: ");
        this.classroomNumber = sc.nextLine();
        System.out.print("Enter material fee per student: ");
        this.materialFeePerStudent = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void updateCourse() {
        super.updateCourse();
        Scanner sc = new Scanner(System.in);
        System.out.print("Update classroom number: ");
        this.classroomNumber = sc.nextLine();
        System.out.print("Update material fee per student: ");
        this.materialFeePerStudent = Double.parseDouble(sc.nextLine());
    }

    @Override
    public double calculateTotalFee() {
        return (getFeePerStudent() + materialFeePerStudent) * getEnrolledStudents();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Course Type: Offline");
        System.out.println("Classroom number: " + classroomNumber);
        System.out.println("Material fee per student: " + materialFeePerStudent);
        System.out.println("Total fee: " + calculateTotalFee());
    }
}

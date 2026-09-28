/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltck;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CourseArrayList {

    private ArrayList<Course> courses;

    public CourseArrayList() {
        this.courses = new ArrayList<>();
    }

    public void addCourseToArrayList(Course course) {
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public void updateCourseById(String id) {
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                c.updateCourse();
                System.out.println("Course updated successfully!");
                return;
            }
        }
        System.out.println("Course with ID " + id + " not found.");
    }

    public void deleteCourseById(String id) {
        Course target = null;
        for (Course c : courses) {
            if (c.getId().equalsIgnoreCase(id)) {
                target = c;
                break;
            }
        }
        if (target != null) {
            courses.remove(target);
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Course with ID " + id + " not found.");
        }
    }

    public void displayAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("Course list is empty.");
            return;
        }
        for (Course c : courses) {
            System.out.println("-----------------------------------");
            c.displayDetails();
        }
    }

    public void displayAvailableCourses() {
        boolean found = false;
        for (Course c : courses) {
            if (c.isAvailable()) {
                System.out.println("-----------------------------------");
                c.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available courses found.");
        }
    }

    public double calculateTotalFees() {
        if (courses.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Course c : courses) {
            total += c.calculateTotalFee();
        }
        return total;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ltck;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Processor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseArrayList manager = new CourseArrayList();
        int choice;

        do {
            System.out.println("\n========== COURSE ENROLLMENT MANAGEMENT ==========");
            System.out.println("1. Add a new course (Online/Offline)");
            System.out.println("2. Update a course by ID");
            System.out.println("3. Delete a course by ID");
            System.out.println("4. Display all courses");
            System.out.println("5. Display available courses for enrollment");
            System.out.println("6. Calculate total fees for all courses");
            System.out.println("0. Exit program");
            System.out.print("Choose an option: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Select course type (1: Online, 2: Offline): ");
                    int type = Integer.parseInt(sc.nextLine());
                    if (type == 1) {
                        OnlineCourse oc = new OnlineCourse() {
                        };
                        oc.addCourse();
                        manager.addCourseToArrayList(oc);
                    } else if (type == 2) {
                        OfflineCourse off = new OfflineCourse() {
                        };
                        off.addCourse();
                        manager.addCourseToArrayList(off);
                    } else {
                        System.out.println("Invalid course type!");
                    }
                    break;
                case 2:
                    System.out.print("Enter Course ID to update: ");
                    String updateId = sc.nextLine();
                    manager.updateCourseById(updateId);
                    break;
                case 3:
                    System.out.print("Enter Course ID to delete: ");
                    String deleteId = sc.nextLine();
                    manager.deleteCourseById(deleteId);
                    break;
                case 4:
                    System.out.println("\n--- ALL COURSES ---");
                    manager.displayAllCourses();
                    break;
                case 5:
                    System.out.println("\n--- AVAILABLE COURSES ---");
                    manager.displayAvailableCourses();
                    break;
                case 6:
                    System.out.println("Total fees for all courses: " + manager.calculateTotalFees());
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 0);

        sc.close();
    }
}

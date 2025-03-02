package com.ths.studentmgmt.services;

import java.util.Scanner;

public class ExecuteStudent extends ProcessStudents {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tharun Techno Schools Maintained by SMS!!!!");
		System.out.println("Please enter your class strength!!!");
		sc = new Scanner(System.in);
		int totalStudentsInClass = sc.nextInt();
		students = new StudentDetails[totalStudentsInClass];
		
        while (true) {
        	sc.nextLine();
    		System.out.println("\nPlease enter your choice!!!");
            System.out.println("1. Add Student");
            System.out.println("2. update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. display Student");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                      addStudent();
                    break;
                case 2:
                      updateStudent();
                    break;
                case 3:
                      deleteStudent();

                    break;
                case 4:
                       displayStudentRecords();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
	
}

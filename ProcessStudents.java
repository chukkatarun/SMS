package com.ths.studentmgmt.services;

import java.util.Scanner;

public class ProcessStudents {

	public static Scanner sc;
	public static StudentDetails[] students;
	public static int studentCount;
	public static boolean isValid = true;

	public static void addStudent() {
		if(studentCount >= students.length) {
			System.out.println("Class strength is Full!!!");
		} else  {
			System.out.println("Enter student id :");
			int studentId = sc.nextInt();

			while (isValid) {
				validateStudentId(studentId);
				if (isValid) {
					System.out.println("\nEnter student id again :");
					studentId = sc.nextInt();
				}
			}

			isValid = true;
			StudentDetails student = new StudentDetails();
			student.setStudentId(studentId);
			sc.nextLine();
			
			student.setStudentName(validateStudentNameCase2());
			student.setSubjectWiseMarks(addOrUpdateSubjectWiseStudentMarks());
			student.setTotalMarks(calculateTotalMarks(student));

			for(int i =0; i<students.length;i++) {
				if(students[i]==null) {
					System.out.println("There null palace is present");

					students[i]=student;
					studentCount++;
					System.out.println("Student added into the system successfully!!!!");

				calculateGrade(student);
					break;
				}
			}
		
			
		}
	}
	
	public static String validateStudentNameCase1() {
		String name;
		while (true) {
			System.out.println("Enter student name :");
			name = sc.next();
			if (name.matches("[a-zA-Z ]+")) {   //Regex - regular expressions
				return name;
			} else {
				System.out.println("**Note: Name should contain alphabets only\n");
			}

		}
	}
	
	public static String validateStudentNameCase2() {
		String name = null;
		boolean isValid = true;
		
		while (isValid) {
			System.out.println("Enter student name :");
			name = sc.next();
			for(Character ch : name.toCharArray()) {
				if(Character.isDigit(ch)) {
					isValid = false;
				}
			}
			
			if(!isValid) {
				System.out.println("**Note: Name should contain alphabets only\n");
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return name;
	}

 	public static boolean validateStudentId(int studentId) {
		if (studentId <= 0) {
			System.out.println("Invalid Student Id!!!, Only Positive values are allowed");
			isValid = false;
		} else {
			for (int i = 0; i < students.length; i++) {
				if (studentCount <= 0) {
					break;
				} else if (null != students[i] && students[i].getStudentId() == studentId) {
					System.out.println("Entered student id - " + studentId
							+ " is already exists!!!! \nPlease enter new Id, if you are adding a new student!!!");
					isValid = false;
					break;
				}
			}
		}

		if (!isValid) {
			isValid = true;
		} else {
			isValid = false;
		}

		return isValid;
	}

	public static int[] addOrUpdateSubjectWiseStudentMarks() {
		int[] marks = new int[6];
		System.out.println("Enter marks of following subject :");

		System.out.println("Maths :");
		marks[0] = validateStudentMarks();
		
		System.out.println("Science :");
		marks[1] = validateStudentMarks();

		System.out.println("English :");
		marks[2] = validateStudentMarks();

		System.out.println("Hindi :");
		marks[3] = validateStudentMarks();

		System.out.println("Social :");
		marks[4] = validateStudentMarks();

		System.out.println("Telugu :");
		marks[5] = validateStudentMarks();

		return marks;
	}
	
	public static int validateStudentMarks() {
		int marks;
		while (true) {
			marks = sc.nextInt();
			if (marks >= 0 && marks <= 100) {
				return marks;
			} else {
				System.out.println("**Note: Marks should be in between 0 to 100 only!!!\n");
			}
		}
	}

	public static int calculateTotalMarks(StudentDetails studentDetails) {
		int totalMarks = 0;
		for (Integer marks : studentDetails.getSubjectWiseMarks()) {
			totalMarks += marks;
		}
		return totalMarks;
	}

	public static void calculateGrade(StudentDetails student) {
		int totalMarks = student.getTotalMarks();
		int numberOfSubjects = student.getSubjectWiseMarks().length;
		int avg = totalMarks / numberOfSubjects;
		char grade;

		if (avg >= 90) {
			grade = 'A';
		} else if (avg >= 80 && avg <= 89) {
			grade = 'B';
		} else if (avg >= 70 && avg <= 79) {
			grade = 'C';

		} else if (avg >= 60 && avg <= 69) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		student.setGrade(grade);
	}

	public static void updateStudent() {
		System.out.println("Enter studentId to update :");
		int id = sc.nextInt();
		for (int i = 0; i < studentCount; i++) {
			if (students[i].getStudentId() == id) {
				System.out.println("What do you want to update ");
				System.out.println("1. Name");
				System.out.println("2. Marks of student");
				System.out.println("Please enter your choice, only numbers allowed!!!");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter Student Name to add for the existing Id in the system!!!");
					students[i].setStudentName(validateStudentNameCase2());
					System.out.println("Added a new Student : " + students[i].getStudentName()
							+ " Into the system successfully\n");

					System.out.println("Enter Subject wise marks to update\n");
					students[i].setSubjectWiseMarks(addOrUpdateSubjectWiseStudentMarks());
					students[i].setTotalMarks(calculateTotalMarks(students[i]));
					System.out.println(
							"Latest Marks added into the system for student : " + students[i].getStudentName());
					break;
				case 2:
					System.out.println("Enter Subject wise marks to update\n");
					students[i].setSubjectWiseMarks(addOrUpdateSubjectWiseStudentMarks());
					students[i].setTotalMarks(calculateTotalMarks(students[i]));
					System.out.println(
							"Latest Marks added into the system for student : " + students[i].getStudentName());
					break;
				default:
					System.out.println("Invalid Entry!!!!");
					break;
				}

			} else {
				System.out.println("Entered StudentId not found in the system!!!");
			}
		}
	}
	
	public static void deleteStudent() {
		Boolean flag = true;
		if (studentCount == 0) {
			System.out.println("Student Records Not Found in the system!!!!\n");
		} else {
			System.out.println("Enter studentId to delete :");
			int id = sc.nextInt();
			for (int i = 0; i < students.length; i++) {
				if (null != students[i] && students[i].getStudentId() == id) {
					String name = students[i].getStudentName();
					students[i] = null;
					studentCount -= 1;
					flag = false;
					System.out.println("Student : " + name + " record removed from the system successfully!!!!\n");
				}
			}
			if(flag) {
				System.out.println("Student with Id : " + id + " Not Found in the system!!!!\n");
			}
		}
	}
	
	public static void sortStudentRecordsBasedOnId() {
		for (int i = 0; i < studentCount - 1; i++) {
			for (int j = 0; j < studentCount - i - 1; j++) {
				if (students[j].getStudentId() > students[j + 1].getStudentId()) {
					StudentDetails temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
	}

	public static void sortStudentRecordsBasedOnMarks() {
		for (int i = 0; i < studentCount - 1; i++) {
			for (int j = 0; j < studentCount - i - 1; j++) {
				if (students[j].getTotalMarks() < students[j + 1].getTotalMarks()) {
					StudentDetails temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}
	}

	public static void displayStudentRecords() {
		System.out.println("1.Get Id in Asscending Order");
		System.out.println("2.Get Marks in High to Low Order");

		int select =sc.nextInt();
		switch (select) {
		case 1:
			sortStudentRecordsBasedOnId();
			break;
		case 2:
			sortStudentRecordsBasedOnMarks();

		default:
			System.out.println("Invalid choice!");
			break;
		}
		System.out.println("----------Student Report----------");
		System.out.println("Student Details as Follows:");


		
		for (int i = 0; i < students.length; i++) {
			if (studentCount <= 0) {
				System.out.println("~~~~ No Students Found in the system!!!!! ~~~~~");
				break;
			} else {
				StudentDetails stu = students[i];
				if(null != stu) {
					System.out.println((i+1)+"."+" Id : " + stu.getStudentId());
					System.out.println(" Name : " + stu.getStudentName());
					System.out.println(" Grade : " + stu.getGrade());
					System.out.println(" Total Marks : " + stu.getTotalMarks());
					System.out.println(" Subject wise Marks:");
					int[] marks = stu.getSubjectWiseMarks();
					String [] subject = {" Maths"," Scince"," English"," Hindh"," Social"," Telugu"};
					for (int j = 0; j < marks.length; j++) {
						System.out.print(subject[j]+" : "+marks[j] + "\n");
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			}
		}
	}

}

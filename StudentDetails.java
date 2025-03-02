package com.ths.studentmgmt.services;

import java.util.Arrays;

public class StudentDetails {

	private int studentId;
	private String studentName;
	private int totalMarks;
	private int[] subjectWiseMarks;
	private char grade;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int[] getSubjectWiseMarks() {
		return subjectWiseMarks;
	}

	public void setSubjectWiseMarks(int[] subjectWiseMarks) {
		this.subjectWiseMarks = subjectWiseMarks;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", studentName=" + studentName + ", totalMarks=" + totalMarks
				+ ", subjectWiseMarks=" + Arrays.toString(subjectWiseMarks) + ", grade=" + grade + "]";
	}

}
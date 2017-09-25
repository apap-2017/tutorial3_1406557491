package com.example.demo.model;

public class StudentModel {
	private String npm;
	private String name;
	private double gpa;

	public StudentModel (String name, String npm, double gpa) {
		this.name = name;
		this.npm = npm;
		this.gpa = gpa;
	}

	public String getNpm() {
		return this.npm;
	}

	public String getName() {
		return this.name;
	}

	public double getGpa() {
		return this.gpa;
	}

	public void setNpm(String npm) {
		this.npm = npm;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
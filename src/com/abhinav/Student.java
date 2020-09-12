package com.abhinav;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Student {


	private String name;
	private int age;
	private int marks;
	private String rollNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}

	private static Map<String, Comparator<Student>> comparators = new HashMap<>();
	
	public Student(String name, int age, int marks, String rollNumber) {
		
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.rollNumber = rollNumber;
	}
	
	static {
		comparators.put("name", Comparator.comparing(Student::getName));
		comparators.put("age", Comparator.comparing(Student::getAge));
		comparators.put("marks", Comparator.comparing(Student::getMarks));
		comparators.put("rollNumber", Comparator.comparing(Student::getRollNumber));
	}
	
	public static Comparator<Student> getComparator(String criterion) {
		return comparators.get(criterion);
	}
}

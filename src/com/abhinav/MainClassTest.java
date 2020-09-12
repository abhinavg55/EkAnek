package com.abhinav;


import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	void testBasicSorting() {
		Student s1 = new Student("gupta", 10, 100, "r1");
		Student s2 = new Student("abhinav", 5, 100, "r1");
		Set<Student> students = new HashSet<>();
		students.add(s1);
		students.add(s2);
		Collection<Student> sorted = Problem1.sort(students, new String[] {"name"});
		assertEquals("Sorting by name: ", sorted.iterator().next().getName(), "abhinav");
		
	}
	
	@Test
	void testDoubleSorting() {
		Student s1 = new Student("gupta", 30, 100, "r1");
		Student s2 = new Student("abhinav", 5, 100, "r1");
		Student s3 = new Student("gupta", 20, 100, "r1");
		Set<Student> students = new HashSet<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		Collection<Student> sorted = Problem1.sort(students, new String[] {"name", "age"});
		Iterator<Student> iterator = sorted.iterator();
		assertEquals("Sorting by name: ", iterator.next().getName(), "abhinav");
		assertEquals("Sorting by marks: ", iterator.next().getAge(), 20);
		
	}
	
	

}

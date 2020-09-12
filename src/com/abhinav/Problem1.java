package com.abhinav;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1 {
	
	/**
	 * Space complexity n, time complexity n
	 * @param students
	 * @param criteria
	 * @return
	 */
	static Collection<Student> sort(Collection<Student> students, String[] criteria) {
		if (students == null) {
			return students;
		}
		if (criteria == null || criteria.length == 0) {
			// Should be logged instead of sysout
			System.out.println("Empty criteria.");
			return students;
		}
		List<Student> studentsList = new ArrayList<>(students);
		Comparator<Student> comparator = null;
		for (String criterion : criteria) {
			Comparator<Student> criterionComparator = Student.getComparator(criterion);
			if (criterionComparator == null) {
				throw new IllegalArgumentException("No comparator found matching string: " + criterion);
			}
			if (comparator == null) {
				comparator = criterionComparator;
			} else {
				comparator =  comparator.thenComparing(criterionComparator);
			}
		}
		Collections.sort(studentsList, comparator);
		return studentsList;
	}
}

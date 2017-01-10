package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {

	public List<Course> coursesToSelect;
	
	private Scanner console;
	
	public Student student; 
	
	public SetTest() {
		coursesToSelect = new ArrayList<Course>();
		console = new Scanner(System.in);
	}
	
	/**
	 * used to add courses into coursesToSelect list
	 */
	public void testAdd() {
		// create a course object, and invoke add() function to add it into the coursesToSelect list
		Course cr1 = new Course("1", "Data structure");
		coursesToSelect.add(cr1);
		//Course temp = (Course) coursesToSelect.get(0); 
		//System.out.println("Add a course: " + temp.id + ". " + temp.name);
		
		Course cr2 = new Course("2", "C language"); 
		coursesToSelect.add(0, cr2);
		//Course temp2 = (Course) coursesToSelect.get(0); 
		//System.out.println("Add a course: " + temp2.id + ". " + temp2.name);
		
		Course[] course = {new Course("3", "Discrete mathematics"), new Course("4", "Assembly language")};
		coursesToSelect.addAll(Arrays.asList(course));
		//Course temp3 = (Course) coursesToSelect.get(2); 
		//Course temp4 = (Course) coursesToSelect.get(3); 
		//System.out.println("Add two courses: " + temp3.id + ". " + temp3.name + "; " + temp4.id + ". " + temp4.name);
		
		Course[] course2 = {new Course("5", "Advanced mathematics"), new Course("6", "English")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		//Course temp5 = (Course) coursesToSelect.get(2); 
		//Course temp6 = (Course) coursesToSelect.get(3); 
		//System.out.println("Add two courses: " + temp5.id + ". " + temp5.name + "; " + temp6.id + ". " + temp6.name);
		
	}
	
	/**
	 * get the element in the list via for each method 
	 * @param args
	 */
	public void testForEach() {
		System.out.println("Courses are listed below (using for each method):");
		for(Course cr : coursesToSelect) {
			System.out.println("Course: " + cr.id + ". " + cr.name);
		}
	}
	
	public void testForEachForSet(Student std) {
		// print out the courses selected by the student1
		System.out.println("The number of selected courses: " + std.courses.size());
		for(Course cr : std.courses) {
			System.out.println("Selected courses: " + cr.id + ". " + cr.name);
		}
	}

	/**
	 * Check whether there is such a course in coursesToSelect list
	 * Test contains() method of List, return true or false
	 * @param args
	 */
	public void testListContains() {
		// get an existing course, and then check contains()
		Course course = coursesToSelect.get(0);
		System.out.println("Get the course: " + course.name);
		System.out.println("Whether courses to select contain this course: " + coursesToSelect.contains(course));
		
		// let the user enter the name of the course, and then check contains()
		System.out.println("Enter the name of the course which is going to be checked: ");
		String courseName = console.next();
		Course course2 = new Course();
		course2.name = courseName;  // we should use set() method to set name, but we do so in order to demonstrate easier
		System.out.println("Create the new course: " + course2.name);
		System.out.println("Whether courses to select contain this course: " + coursesToSelect.contains(course2));
		
		// use indexOf() method to get the index of an element in the set
		if (coursesToSelect.contains(course2)) {
			System.out.println("The index of this course is: " + coursesToSelect.indexOf(course2));
		}
	}
	
	/**
	 * create a student object and select courses
	 */
	public void createStudentAndSelectCourse() {
		// create a student object
		student = new Student("1", "Tom");
		System.out.println("Welcome " + student.name + " to select courses.");
		
		// create a Scanner object to receive course ID from keyboard input
		Scanner console = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter course ID:");
			String cousreId = console.next();
			for (Course cr: coursesToSelect) {
				if (cr.id.equals(cousreId)) {
					student.courses.add(cr);
					student.courses.add(cr); // The elements in set cannot be repeatable, only the first one is stored.
					//student1.courses.add(null); // Set can store null value, but it is meaningless for business logic in real projects.
				}
			}
		}
	}
	
	/**
	 * Check whether there is such a course in courses that the student has selected
	 * Test contains() method of Set, return true or false
	 * @param args
	 */
	public void testSetContains() {
		// let the user enter the name of the course, and then check contains()
		System.out.println("Enter the name of the course which is going to be checked: ");
		String courseName = console.next();
		Course course2 = new Course();
		course2.name = courseName;  // we should use set() method to set name, but we do so in order to demonstrate easier
		System.out.println("Create the new course: " + course2.name);
		System.out.println("Whether the student has selected this course: " + student.courses.contains(course2)); // need to override hashCode() and equals() in Course class
		
	}
	
	public static void main(String[] args) {
		SetTest st = new SetTest(); 
		st.testAdd();
		
		st.testListContains();
		
		
		st.testForEach();
		
//		st.createStudentAndSelectCourse();
//		st.testSetContains();
		
		
		
//		
//		// create a student object
//		Student student1 = new Student("1", "Tom");
//		System.out.println("Welcome " + student1.name + " to select courses.");
//		
//		// create a Scanner object to receive course ID from keyboard input
//		Scanner console = new Scanner(System.in);
//		
//		for (int i = 0; i < 3; i++) {
//			System.out.println("Enter course ID:");
//			String cousreId = console.next();
//			for (Course cr: st.coursesToSelect) {
//				if (cr.id.equals(cousreId)) {
//					student1.courses.add(cr);
//					student1.courses.add(cr); // The elements in set cannot be repeatable, only the first one is stored.
//					//student1.courses.add(null); // Set can store null value, but it is meaningless for business logic in real projects.
//				}
//			}
//		}
//		
//		st.testForEachForSet(student1);

	}

}

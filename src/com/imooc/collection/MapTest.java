package com.imooc.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {

	/**
	 * used to store student objects
	 */
	public Map<String, Student> students;  // It should be 'private', but using 'public' here is to make it easier to demonstrate.
	
	/**
	 * initiate students in the constructor
	 */
	public MapTest() {
		this.students = new HashMap<String, Student>();
	}
	
	/**
	 * Test put() function of Map. Enter student ID, and check if there is
	 * if there is not, then enter student name, and create a new student object,
	 * and add into Map students
	 */
	public void testPut() {
		Scanner console = new Scanner(System.in); 
		int i = 0;
		while (i < 3) {
			System.out.println("Enter student ID:");
			String ID = console.next();
			
			// check if there is such an ID
			Student st = students.get(ID);
			if (st == null) {
				// prompt to enter student name
				System.out.println("Enter student name:");
				String name = console.next();
				
				// create a new student object 
				Student newSt = new Student(ID, name); 
				
				// use put() function to add ID-Student key-value pair
				students.put(ID, newSt);
				System.out.println("Add a new student " + students.get(ID).name + " successfully.");
				i++;
			}
			else {
				System.out.println("This student already exists.");
				continue;
			}
		}
	}
	
	/**
	 * Print out all student names 
	 * Test keySet() function of Map
	 */
	public void testKeySet() {
		// use keySet() function to return the set of the keys in the Map
		Set<String> keySet = students.keySet();
		
		System.out.println("There are " + students.size() + " studetns.");
		
		// go through keySet, and get each key, then invoke get() function to get the corresponding value
		for (String stuId : keySet) {
			Student st = students.get(stuId);
			if (st != null) {
				System.out.println("Student name: " + st.name);
			}
		}
	}
	
	/**
	 * Print out all student names 
	 * Test entrySet() method of Map
	 */
	public void testEntrySet() {
		// use entrySet() method to return the set of key-value pairs in the Map
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for (Entry<String, Student> entry : entrySet) {
			System.out.println("Get the key: " + entry.getKey());
			System.out.println("The corresponding value: " + entry.getValue().name);
		}
	}
	
	
	/**
	 * Remove an existing student 
	 * Test remove() method of Map
	 */
	public void testRemove() {
		Scanner console = new Scanner(System.in); 
		
		while (true) {
			System.out.println("Enter the student ID who is going to be removed:");
			String ID = console.next();
			
			// check if there is such an ID
			Student st = students.get(ID);
			if (st == null) {
				System.out.println("This ID does not exist.");
				continue;
			} 
			else {
				students.remove(ID);
				System.out.println("Student " + st.name + " has been removed successfully.");
				break;
			} 
		}
	}
	
	/**
	 * Change students' information
	 * Use put() method to modify the existing entry in the Map
	 */
	public void testModify() {
		Scanner console = new Scanner(System.in); 
		
		while (true) {
			System.out.println("Enter the student ID who is going to be modified:");
			String ID = console.next();
			
			// check if there is such an ID
			Student st = students.get(ID);
			if (st == null) {
				System.out.println("This ID does not exist.");
				continue;
			} 
			else {
				System.out.println("The name of this student is: " + st.name);
				
				// ask for entering the name of the new student
				System.out.println("Enter the name of the new student:");
				String newStName = console.next();
				Student newSt = new Student(ID, newStName);
				students.put(ID, newSt);
				System.out.println("The student has been modified successfully.");
				break;
			} 
		}
	}
	
	/**
	 * Check whether there is such a key or value in the Map
	 * Use containsKey() method to check whether there is such a key in the Map
	 * Use containsValue() method to check whether there is such a value in the Map
	 */
	public void testContainsKeyOrValue() {
		System.out.println("Enter the ID of the student who is going to be checked: ");
		Scanner console = new Scanner(System.in); 
		String id = console.next();
		
		// Use containsKey() method to check whether there is such a key in the Map
		System.out.println("Whether this student exists in the Map: " + students.containsKey(id));
		if (students.containsKey(id)) {
			System.out.println("The name of this student is: " + students.get(id).name);
		}
		
		
		
		System.out.println("Enter the name of the student who is going to be checked: ");
		String name = console.next();
		// Use containsValue() method to check whether there is such a value in the Map
		System.out.println("Whether this student exists in the Map: " + students.containsValue(new Student(null, name))); // need to override equals() in Student class
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
		//mt.testRemove();
		//mt.testModify();
		//mt.testEntrySet();
		
		mt.testContainsKeyOrValue();

	}

}

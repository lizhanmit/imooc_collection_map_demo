package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * courses to select class
 * @author LZ
 *
 */
public class ListTest {

	/**
	 * the list that is used to store courses to select
	 */
	public List coursesToSelect;
	
	public ListTest() {
		this.coursesToSelect = new ArrayList();
	}
	
	/**
	 * used to add courses into coursesToSelect list
	 */
	public void testAdd() {
		// create a course object, and invoke add() function to add it into the coursesToSelect list
		Course cr1 = new Course("1", "Data structure");
		coursesToSelect.add(cr1);
		Course temp = (Course) coursesToSelect.get(0); 
		System.out.println("Add a course: " + temp.id + ". " + temp.name);
		
		Course cr2 = new Course("2", "C language"); 
		coursesToSelect.add(0, cr2);
		Course temp2 = (Course) coursesToSelect.get(0); 
		System.out.println("Add a course: " + temp2.id + ". " + temp2.name);
		
		Course[] course = {new Course("3", "Discrete mathematics"), new Course("4", "Assembly language")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp3 = (Course) coursesToSelect.get(2); 
		Course temp4 = (Course) coursesToSelect.get(3); 
		System.out.println("Add two courses: " + temp3.id + ". " + temp3.name + "; " + temp4.id + ". " + temp4.name);
		
		Course[] course2 = {new Course("5", "Advanced mathematics"), new Course("6", "English")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course) coursesToSelect.get(2); 
		Course temp6 = (Course) coursesToSelect.get(3); 
		System.out.println("Add two courses: " + temp5.id + ". " + temp5.name + "; " + temp6.id + ". " + temp6.name);
		
	}
	
	/**
	 * get the element in the list 
	 * @param args
	 */
	public void testGet() {
		int size = coursesToSelect.size();
		System.out.println("Courses are listed below (using for loop):");
		for(int i = 0; i < size; i++) {
			Course cr = (Course) coursesToSelect.get(i);
			System.out.println("Course: " + cr.id + ". " + cr.name);
		}
	}
	
	/**
	 * use the iterator to go through the list
	 * @param args
	 */
	public void testIterator() {
		// get the instance of the iterator via collection's iterator() function
		Iterator it = coursesToSelect.iterator();
		System.out.println("Courses are listed below (using iterator):");
		while(it.hasNext()) {
			Course cr = (Course) it.next();
			System.out.println("Course: " + cr.id + ". " + cr.name);
		}
	}
	
	/**
	 * get the element in the list via for each method 
	 * @param args
	 */
	public void testForEach() {
		System.out.println("Courses are listed below (using for each method):");
		for(Object obj : coursesToSelect) {
			Course cr = (Course) obj;
			System.out.println("Course: " + cr.id + ". " + cr.name);
		}
	}
	
	/**
	 * modify the element in the list
	 * @param args
	 */
	public void testModify() {
		coursesToSelect.set(4, new Course("7", "Big data"));
	}
	
	/**
	 * remove the element in the list
	 * @param args
	 */
	public void testRemove() {
		Course cr = (Course) coursesToSelect.get(4);
		System.out.println("This course is " + cr.id + ". " + cr.name + ", which is going to be removed.");
		coursesToSelect.remove(cr);
		System.out.println("Remove successfully.");
		testForEach();
	}
	
	/**
	 * remove multiple elements in the list
	 * @param args
	 */
	public void testRemoveAll() {
		System.out.println("Elements with index 1 and index 2 will be removed.");
		Course[] courses = {(Course) coursesToSelect.get(1), (Course) coursesToSelect.get(2)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("Remove all successfully.");
		testForEach();
	}
	
	public static void main(String args[]) {
		ListTest lt = new ListTest();
		lt.testAdd();
		lt.testGet();
		lt.testIterator();
		lt.testModify();
		lt.testForEach();
		lt.testRemove();
		lt.testRemoveAll();
	}
}

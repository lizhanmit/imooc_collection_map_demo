package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

	/**
	 * the list with Course generic
	 */
	public List<Course> courses;
	
	public TestGeneric() {
		this.courses = new ArrayList<Course>();
	}
	
	/**
	 * add an element into the list
	 * @param args
	 */
	public void testAdd() {
		Course cr1 = new Course("1", "Chinese");
		courses.add(cr1);
		
		Course cr2 = new Course("2", "Java language");
		courses.add(cr2);
	}
	
	/**
	 * get the element in the list via for each method 
	 * @param args
	 */
	public void testForEach() {
		System.out.println("Courses are listed below (using for each method):");
		for(Course cr : courses) {
			System.out.println("Course: " + cr.id + ". " + cr.name);
		}
	}
	
	/**
	 * generic collection can store objects with subclass type of generic class type
	 * @param args
	 */
	public void testChild() {
		ChildCourse ccr = new ChildCourse(); 
		ccr.id = "3";  // In fact, id and name should be set using set() function. We do so here in order to make it easier to demonstrate.
		ccr.name = "I am the object with subclass type.";
		courses.add(ccr);
	}
	
	/**
	 * generic collection cannot store basic types, but it can store their wrapper class
	 * @param args
	 */
	public void testBasicTypeWrapperClass() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("Basic types must use their wrapper classes as generic." + list.get(0));
	}
	
	public static void main(String[] args) {
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testChild();
		tg.testForEach();
		tg.testBasicTypeWrapperClass();
	}

}

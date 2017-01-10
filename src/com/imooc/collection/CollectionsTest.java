package com.imooc.collection;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


/**
 * 1. Use Collections.sort() function to sort the List with Integer generic;
 * 2. 						 		  to sort the List with String generic;
 * 3. 								  to sort the list with other generic (e.g. Student)
 * @author LZ
 *
 */
public class CollectionsTest {

	/**
	 * 1. Use Collections.sort() to sort the List with Integer generic
	 * Create a List with Integer generic, insert 10 random non repetitive numbers within 100, 
	 * then use Collections.sort() to sort 
	 * @param args
	 */
	public void testSort1() {
		// Create a List with Integer generic
		List<Integer> integerList = new ArrayList<Integer>(); 
		
		// insert 10 random non repetitive numbers within 100
		Random random = new Random(); 
		Integer k;
		for (int i = 0; i < 10; i++) {
			do {
				k = random.nextInt(100);
			} while (integerList.contains(k));
			integerList.add(k);
			System.out.println("Insert successfully: " + k);
		}
		
		System.out.println("------------- before sorting -------------");
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
		
		// use Collections.sort() to sort 
		Collections.sort(integerList);
		System.out.println("------------- after sorting -------------");
		for (Integer integer : integerList) {
			System.out.println(integer);
		}
	}
	
	/**
	 * 2. Use Collections.sort() function to sort the List with String generic
	 * @param args
	 */
	public void testSort2() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("java"); 
		stringList.add("python");
		stringList.add("C#");
		
		System.out.println("------------- before sorting -------------");
		for (String string : stringList) {
			System.out.println(string);
		}
		
		// use Collections.sort() to sort 
		Collections.sort(stringList);
		System.out.println("------------- after sorting -------------");
		for (String string : stringList) {
			System.out.println(string);
		}
	}
	
	/**
	 * 3. Use Collections.sort() function to sort the list with other generic (e.g. Student)
	 * @param args
	 */
	public void testSort3() {
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "", "Tom"));
		studentList.add(new Student(random.nextInt(1000) + "", "Bob"));
		studentList.add(new Student(random.nextInt(1000) + "", "Jack"));
		studentList.add(new Student(10000 + "", "Lily"));
		
		System.out.println("------------- before sorting -------------");
		for (Student student : studentList) {
			System.out.println(student.id + ". " + student.name);
		}
		
		// use Collections.sort() to sort 
		Collections.sort(studentList);
		System.out.println("------------- after sorting -------------");
		for (Student student : studentList) {
			System.out.println(student.id + ". " + student.name);
		}
		
		// use another Collections.sort() with the comparator parameter to sort 
		Collections.sort(studentList, new StudentComparator());
		System.out.println("------------- after sorting according to name -------------");
		for (Student student : studentList) {
			System.out.println(student.id + ". " + student.name);
		}
		
	}
	
	public static void main(String[] args) {
		CollectionsTest ct = new CollectionsTest(); 
		//ct.testSort1();
		//ct.testSort2();
		ct.testSort3();

	}

}

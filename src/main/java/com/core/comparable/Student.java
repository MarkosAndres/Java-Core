package com.core.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {
	private int rollno;  
	private String name;  
	private int age; 
	
	
	public int compareTo(Student o) {
		if(this.age == o.age)
			return 0;
		else if(this.age > o.age)
			return 1;

		return -1;
	}
	
	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return this.name+" - "+this.rollno+" - "+this.age;
	}
	
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();  
		
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));
		
		for(Student st: al){
			System.out.println(st.toString());
		}
		
		Collections.sort(al);
		
		for(Student st: al){
			System.out.println(st.toString());
		}
	}
}

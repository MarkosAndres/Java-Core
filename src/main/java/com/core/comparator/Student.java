package com.core.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Student{
	private int rollno;  
	private String name;  
	private int age; 
	
	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return this.name+" - "+this.rollno+" - "+this.age;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

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
	
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();  
		
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));
		
		for(Student st: al){
			System.out.println(st.toString());
		}
		
		Collections.sort(al, new ComparatorByAge());
		
		for(Student st: al){
			System.out.println(st.toString());
		}
		
		Collections.sort(al, new ComparatorByName());
		
		for(Student st: al){
			System.out.println(st.toString());
		}
	}
}


class ComparatorByAge implements Comparator<Student>{
	public int compare(Student o1, Student o2) {
		if(o1.getAge() == o2.getAge())
			return 0;
		else if(o1.getAge() > o2.getAge())
			return 1;

		return -1;
	}	
}

class ComparatorByName implements Comparator<Student> {
	public int compare(Student o1, Student o2) {		
		return o1.getName().compareTo(o2.getName());
	}	
}

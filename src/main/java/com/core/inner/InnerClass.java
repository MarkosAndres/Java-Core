package com.core.inner;

public class InnerClass {
	
	public static void main(String[] args) {
		new InnerClass().outterMethod();
	}
	
	public String address = "known address";
	private String zipCode = "564623";
	private int phone = 41155641;
	
	public void outterMethod(){
		System.out.println(new NestedClass().nestedAge);
		// System.out.println(new NestedClass().address); NOT POSSIBLE
	}
	
	
	
	class NestedClass {
		public String nestedName = "nested name";
		private String nestedLastName = "nested lastname";
		private int nestedAge = 23;
		
		public int doubleAge(int age) {
			return age * 2;
		}
		
		private int tripleAge(int age) {
			return age * 3;
		}
	}
}
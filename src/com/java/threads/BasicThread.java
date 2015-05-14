package com.java.threads;

public class BasicThread {
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable());
		
		t.start();
	}
}


class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Este es mi thread");
	}
	
}
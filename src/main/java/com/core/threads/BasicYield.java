package com.core.threads;

public class BasicYield {

	public static void main(String[] args) {
		YieldRunnable yieldRunnable1 = new YieldRunnable();
		
		Thread t3 = new Thread(yieldRunnable1, "t8a");
		t3.setPriority(8);
		
		Thread t4 = new Thread(yieldRunnable1, "t8b");
		t4.setPriority(8);
		
		Thread t5 = new Thread(yieldRunnable1, "t1a");
		t5.setPriority(Thread.MIN_PRIORITY);
		
		Thread t6 = new Thread(yieldRunnable1, "t1b");
		t6.setPriority(Thread.MIN_PRIORITY);
		
		Thread t1 = new Thread(yieldRunnable1, "t10a");
		t1.setPriority(Thread.MAX_PRIORITY);
		
		Thread t2 = new Thread(yieldRunnable1, "t10b");
		t2.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println("---");
		
		t5.start();
		t6.start();
		t3.start();
		t4.start();
		t1.start();
		t2.start();
	}
}

class YieldRunnable implements Runnable{


	public void run() {
		for(int i = 0; i < 10; i ++){
			System.out.println(Thread.currentThread().getName());
			Thread.yield();			
		}
	}
	
}
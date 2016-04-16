package com.core.threads;

public class BasicJoin {
	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable runnable = new MyRunnable();
		Thread t = new Thread(runnable);
		t.start();		
		
//		while(t.isAlive()){
//			System.out.println("Main going to sleep..");
//			Thread.sleep(50);
//		}
		
		t.join();
		
		System.out.println("main: "+runnable.var);
	}
}


class MyRunnable implements Runnable{
	
	int var;

	public void run() {
		for (int i = 0; i < 10541230; i++){
			new String("efe");
			var = i;
		}		
		System.out.println("thread: "+ var);
	}
	
}
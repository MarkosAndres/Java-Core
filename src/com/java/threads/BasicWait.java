package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicWait {
	public static void main(String[] args) throws InterruptedException {
		
		Machine machine = new BigMachine();
		Thread tMachine = new Thread(machine);
		
		Thread tOperator = new Thread(new Operator(machine));
		
		tOperator.start();
		tMachine.start();
	}
}


class Operator implements Runnable{
	Machine machineA;
	
	public Operator(Machine machine){
		this.machineA = machine;
	}
	
	@Override
	public void run() {
		while(true){
			Random r = new Random();
			
			int flag = r.nextInt(15554654);
			if(flag == 1) {
				int numJobsToAdd = r.nextInt(5);
				System.out.println("Adding "+ numJobsToAdd + " jobs");
				for (int i = 0; i < numJobsToAdd; i++)				
					machineA.addJob("job to do");
			}
		}
	}
}

class BigMachine implements Runnable, Machine{	
	List<String> jobs = new ArrayList<String>();
	
	@Override
	public void run(){
	try{
		while(true){			
			synchronized (jobs) {
				if(jobs.isEmpty()){
					System.out.println("No jobs, going to wait..");
					jobs.wait();
				}
				else{
					System.out.println("Processing all jobs..("+ jobs.size() +")");
					jobs.clear();
					Thread.sleep(1000);
				}					
			}
		}			
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public void addJob(String job) {
		synchronized (jobs) {
			this.jobs.add(job);
			jobs.notifyAll();
		}	
	}	

}


interface Machine extends Runnable{
	void addJob(String job);
}
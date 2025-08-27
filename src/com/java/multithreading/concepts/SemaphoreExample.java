package com.java.multithreading.concepts;

import java.util.concurrent.Semaphore;

/*
 * Semaphore is used to restrict the number of threads to execute parallel
 * In below example we're trying to run 3 threads but as we have given limit as 2 
 * so only 2 thread will run concurrently. then one both thread complete the remaining one will run.
 */

public class SemaphoreExample {
	
	static Semaphore sp = new Semaphore(2);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable task = () -> {
			
			try {
				System.out.println("Thread is in waiting "+ Thread.currentThread().getName());
				sp.acquire();
				Thread.sleep(2000);
				System.out.println("Thread is running  "+ Thread.currentThread().getName());
				sp.release();
				System.out.println("Thread is completed  "+ Thread.currentThread().getName());
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();

	}

}

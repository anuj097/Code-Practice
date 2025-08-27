package com.java.multithreading.concepts;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new Car(latch));
		executor.submit(new Bike(latch));
		executor.submit(new Plane(latch));
		
		latch.await();			// to wait for all the threads to be completed
		executor.shutdown();
		System.out.println("Thread main: "+ Thread.currentThread().getName()); // main thread wait for worker thread to complete
	}
}

class Car implements Runnable{
	
	private final CountDownLatch latch;

	Car(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(6000);
			System.out.println(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown();		// To reduce the countdown of latch
		}	
	}	
}

class Bike implements Callable<String>{
	
	private final CountDownLatch latch;

	Bike(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public String call() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName());
		latch.countDown();			// To reduce the countdown of latch
		return "BIKE class called";
		
	}
	
}

class Plane implements Callable<String>{
	
	private final CountDownLatch latch;

	Plane(CountDownLatch latch) {
		this.latch = latch;
	}
	
	@Override
	public String call() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName());
		latch.countDown();			// To reduce the countdown of latch
		return "PLANE class called";
		
	}
	
}


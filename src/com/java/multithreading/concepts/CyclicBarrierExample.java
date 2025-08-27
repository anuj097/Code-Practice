package com.java.multithreading.concepts;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CyclicBarrierExample {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		int size = 3; // if we're executing 3 tasks then pool size and barrier size should be 3, 
						//not less than 3, else 1 thread will be stuck forever 
		
		// once all the executed the below statement will be printed
		// if we use 2 size in cb and pool size is 3 then 2 threads get completed and again both 2 threads start looking for new task
		// and only one thread got the task so it'll await() for other thread, but there is no other task available so program will hang.
		// So if we have 4 task then we can give 2 size of cyclic barrier.
		CyclicBarrier cb = new CyclicBarrier(size , () -> {				
			System.out.println("All the services are completed");
		});
		
		ExecutorService executor = Executors.newFixedThreadPool(size);
		Future<String> f1 = executor.submit(new Home(cb));
		Future<String> f2 = executor.submit(new School(cb));
		Future<String> f3 = executor.submit(new Temple(cb));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f3.get());
		
		executor.shutdown();
		Thread.sleep(5000);
		System.out.println("This Thread: "+ Thread.currentThread().getName());
	}

}

class Home implements Callable<String> {
	
	private final CyclicBarrier cb;
	
	Home(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public String call() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Home Thread Waiting: "+ Thread.currentThread().getName());
		cb.await();				// all thread wait to execute
		return "Home class";
	}
}

class School implements Callable<String> {
	
	private final CyclicBarrier cb;
	
	School(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public String call() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("School Thread Waiting: "+ Thread.currentThread().getName());
		cb.await();				// all thread wait to execute
		return "School class";
	}
	
}

class Temple implements Callable<String> {
	
	private final CyclicBarrier cb;
	
	Temple(CyclicBarrier cb) {
		this.cb = cb;
	}

	@Override
	public String call() throws Exception {
		
		Thread.sleep(2000);
		System.out.println("Temple Thread Waiting: "+ Thread.currentThread().getName());
		cb.await();				// all thread wait to execute
		return "Temple class";
	}
	
}

package com.java.multithreading.concepts;

public class VirtualThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = Thread.ofVirtual().start(() -> {
			System.out.println("Its a Thread "+ Thread.currentThread().getName());
		});
		
		t1.run();

	}

}

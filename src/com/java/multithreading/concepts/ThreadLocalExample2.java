package com.java.multithreading.concepts;

public class ThreadLocalExample2 {

	public static void main(String[] args) {
        Runnable task1 = () -> {
        	
            threadSpecificData.set("Data for Thread 1");  // set a unique data
            System.out.println("Thread 1: " + threadSpecificData.get()); // get the data
            threadSpecificData.remove(); // Clean up
        };

        Runnable task2 = () -> {
            threadSpecificData.set("Data for Thread 2"); // set a unique data
            System.out.println("Thread 2: " + threadSpecificData.get());  // get the data
            threadSpecificData.remove(); // Clean up
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
	
	private static final ThreadLocal<String> threadSpecificData = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Default Value";
        }
    };
}

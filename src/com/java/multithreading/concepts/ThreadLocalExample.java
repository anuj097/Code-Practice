package com.java.multithreading.concepts;

public class ThreadLocalExample {
	
	/*
	 * ThreadLocal provides a way to create thread-local variables. 
	 * These variables are distinct for each thread that accesses them, 
	 * meaning each thread has its own independently initialized copy of 
	 * the variable. This mechanism enables thread-specific data storage 
	 * and management without requiring synchronization, as the data is 
	 * not shared between threads.
	 */

	public static void main(String[] args) {
		
		Runnable r1 = ()-> {
			SetValue.setting(33);
			GetValue.getting();
		};
		Runnable r2 = ()-> {
			SetValue.setting(44);
			GetValue.getting();
		};
		Runnable r3 = ()-> {
			SetValue.setting(55);
			GetValue.getting();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}

}

class Holder {
	public static ThreadLocal<Integer> hold = new ThreadLocal<>();
}

class SetValue {
	public static void setting(int val) {
		Holder.hold.set(val);
	}
}

class GetValue {
	public static void getting() {
		int val = Holder.hold.get();
		System.out.println(val);
	}
}

class GetValue2 {
	public static void getting() {
		int val = Holder.hold.get();
		System.out.println(val);
	}
}

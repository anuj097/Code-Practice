package com.java.multithreading.concepts;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	public static void main(String[] args) {
		

		BankAccount sbi = new BankAccount();
		BankAccount2 uco = new BankAccount2();
		
		Runnable task1 = new Runnable() {	
			@Override
			public void run() {
				System.out.println("Withdrawaling the amount");
				try {
					//sbi.withdrawal(60);
					uco.withdrawal(60);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread t1 = new Thread(task1, "Thread 1");
		Thread t2 = new Thread(task1, "Thread 2");
		t1.start();
		t2.start();
		
//		BankAccount2 uco = new BankAccount2();
//		
//		Runnable task2 = new Runnable() {	
//			@Override
//			public void run() {
//				System.out.println("Withdrawaling the amount");
//				try {
//					uco.withdrawal(60);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		
//		Thread t3 = new Thread(task2, "Thread 1");
//		Thread t4 = new Thread(task2, "Thread 2");
//		t3.start();
//		t4.start();
	}

}

class BankAccount {
	
	public int balance = 100;
	
	public final Lock lock = new ReentrantLock();

	public void withdrawal(int amount) throws Exception {
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName() + " trying to withdrawal "+ amount);
				
				Thread.sleep(500);
				if(balance>=amount) {
					balance -= amount;
				} else {
					System.out.println("Insuffecient Balance, Balance left: "+ balance);
					throw new Exception("Insuffecient Balance");
				}
				System.out.println(Thread.currentThread().getName() + " after withdrawal, the balance amount is : "+ balance);
				
			} else {
				System.out.println(Thread.currentThread().getName() +" There is some issue while running the Thread");
			}
		} catch (InterruptedException e) {
			Thread.interrupted();
		} finally {
			lock.unlock();
		}
		
	}
}

class BankAccount2 {
	
	public int balance = 100;
	
	public final Lock lock = new ReentrantLock();

	public void withdrawal(int amount) throws Exception {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" trying to withdrawal...");
			if(balance>=amount) {
				balance = checkBalance() - amount;
			} else {
				System.out.println("Insuffecient Balance, Balance left: "+ balance);
				throw new Exception("Insuffecient Balance");
			}
			System.out.println(Thread.currentThread().getName()+ " after withdrawaling, the balance: "+ balance);
		} catch (RuntimeException e) {
			Thread.interrupted();
		} finally {
			lock.unlock();
		}
	}
	
	public int checkBalance() {
		lock.lock();
		System.out.println("The Balance is : "+ balance);
		lock.unlock();
		return balance;
	}
}

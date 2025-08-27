package com.java.multithreading.concepts;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
	
	private static final ExecutorService executor = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		CompletableFuture<Void> order = initatePayment()
				.thenCompose(CompletableFutureExample::inventoryUpdate)
				.thenCompose(CompletableFutureExample::sendMail);
		// thenApply() will not work here because it will return CompletableFuture<CompletableFuture<String>>
		
		order.join();
		executor.shutdown();
	}

	public static CompletableFuture<String> initatePayment() {
		// supplyAsync()-> if we want to return something asynchronously
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Payment initated");
			return "Pay_id";
		}, executor);
	}
	
	public static CompletableFuture<String> inventoryUpdate(String pay_id) {
		// supplyAsync()-> if we want to return something asynchronously
		return CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Inventory update for: "+ pay_id);
			return "Inventory updated!!";
		}, executor);
	}
	
	public static CompletableFuture<Void> sendMail(String user) {
		// runAsync()-> if we don't want to return anything asynchronously
		return CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block	
				e.printStackTrace();
			}
			System.out.println("Mail send to: "+ user);
		}, executor);
	}

}

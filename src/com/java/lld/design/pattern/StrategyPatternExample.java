package com.java.lld.design.pattern;

public class StrategyPatternExample {
	/*
		**** Benefits of Strategy Pattern ****

		Eliminates long if-else or switch-case statements.
		Easier to test and extend logic (add new strategies).
		Open/Closed Principle: Open for extension, closed for modification.
	 */

	public static void main(String[] args) {

		DiscountStrategy normal = new NormalOrderDiscount();
		System.out.println("Normal Discount: "+normal.applyDiscount(10000));
		
		DiscountStrategy bulk = new BulkOrderDiscount();
		System.out.println("Bulk Discount: "+bulk.applyDiscount(10000));
		
		DiscountStrategy internatonal = new InternationalOrderDiscount();
		System.out.println("International Discount: "+internatonal.applyDiscount(10000));
		
		System.out.println("***************************************************************");
		
		double holi = DiscountApplier.holiDiscount(10000);
		System.out.println("Holi Discount: "+ holi);
		double diwali = DiscountApplier.diwaliDiscount(10000);
		System.out.println("Diwali Discount: "+ diwali);
		double newYear = DiscountApplier.newYearDiscount(10000);
		System.out.println("New Year Discount: "+ newYear);
	}
}

//	****************************** <- WAY 1 -> ***********************************
interface DiscountApplier {
	static double holiDiscount(double price) {
		return price * 0.2;
	}
	static double diwaliDiscount(double price) {
		return price * 0.3;
	}
	static double newYearDiscount(double price) {
		return price * 0.4;
	}
}

//  ****************************** <- WAY 2 -> ***********************************
interface DiscountStrategy {
	double applyDiscount(double totalPrice);
}

class NormalOrderDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(double totalPrice) {
		
		return totalPrice;
	}	
}

class BulkOrderDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(double totalPrice) {
		
		return totalPrice * 0.9;
	}	
}

class InternationalOrderDiscount implements DiscountStrategy {
	@Override
	public double applyDiscount(double totalPrice) {
		
		return totalPrice + 1000;
	}	
}

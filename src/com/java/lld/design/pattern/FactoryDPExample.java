package com.java.lld.design.pattern;

/*
	The Factory Pattern provides an interface for creating objects, 
	but allows subclasses to alter the type of objects that will be created.

	It hides the object creation logic and allows the code to depend on
	interfaces rather than concrete classes.
	
	A car factory build cars. You don't care how the car is made—you just ask 
	for the type (SUV, Sedan, etc.) and get the product.
 */

interface Car1 {
	void assemble();
}

class Sedan implements Car1 {
	@Override
	public void assemble() {
		System.out.println("Assembling Sedan cars");
	}
}

class Suv implements Car1 {
	@Override
	public void assemble() {
		System.out.println("Assembling Suv cars");
	}
}

class CarFactory {
	public static Car1 getCar(String type) {
		if(type==null) return null;
		
		if(type.equalsIgnoreCase("Sedan")) {
			return new Sedan();
		} else if(type.equalsIgnoreCase("Suv")) {
			return new Suv();
		}
		return null;
	}
}


public class FactoryDPExample {

	public static void main(String[] args) {
		Car1 sedan = CarFactory.getCar("sedan");
		sedan.assemble();
		
		Car1 suv = CarFactory.getCar("suv");
		suv.assemble();
	}

}

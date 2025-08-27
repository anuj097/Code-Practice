package com.java.lld.design.pattern;

/*
	Adapter Pattern allows objects with incompatible interfaces to 
	collaborate by wrapping an existing class with a new interface.
	
	You have an ElectricCar class that only supports charge() functionality,
	but your system expects all cars to implement the drive() method. 
	You want to adapt ElectricCar so it can be used where a Car (with drive()) is expected.
 */

//Target interface
interface Car {
	void drive();
}

//Normal car class
class DieselCar implements Car {
	@Override
	public void drive() {
		System.out.println("To Drive the diesel car");	
	}
}

//Incompatible Class (Adaptee)
class ElectricCar {
	public void charge() {
		System.out.println("To charge the electric car");
	}
	
	public void run() {
		System.out.println("To run the electric car");
	}
}

//Adaptor class
class ElectricCarAdaptor implements Car {

	private ElectricCar eCar;
	
	public ElectricCarAdaptor(ElectricCar eCar) {
		this.eCar = eCar;
	}
	
	@Override
	public void drive() {
		eCar.charge();
		eCar.run();
	}
}

public class AdaptorClassExample {

	public static void main(String[] args) {
		Car dCar = new DieselCar();
		dCar.drive();
		
		System.out.println("--------------------------");
		
		ElectricCar eCar = new ElectricCar();
		Car eAdap = new ElectricCarAdaptor(eCar);
		eAdap.drive();
		
	}

}

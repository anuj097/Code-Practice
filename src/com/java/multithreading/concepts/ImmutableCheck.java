package com.java.multithreading.concepts;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableCheck {
	
	private final int id;
	private final String name;
	private final int age;
	
	// mutable object
	private final List<String> address;
	
	public ImmutableCheck(int id, String name, int age, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = new ArrayList<>(address);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public List<String> getAddress() { // defensive copy of mutable object using
		return new ArrayList<>(address);
	}

	@Override
	public String toString() {
		return "ImmutableCheck [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
}

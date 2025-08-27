package com.java.sort.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee(1,"Ravi", 20000,24),
											new Employee(2,"Suresh", 50000,26),
											new Employee(3,"Honey", 40000,25),
											new Employee(4,"Shiva", 20000,22),
											new Employee(5,"Avi", 35000,27),
											new Employee(6,"Manish", 65000,25),
											new Employee(7,"Krish", 68000,24),
											new Employee(8,"Savita", 90000,30));
		
		//Comparator compare = Comparator.comparing(Employee::getAge).thenComparing(Employee::getName);
		// Collections.sort(list, compare);
		
		list.sort(Comparator.comparing(Employee::age).thenComparing(Employee::name));
		
		System.out.println(list);

	}

}

record Employee(int id, String name, int salary, int age) {};
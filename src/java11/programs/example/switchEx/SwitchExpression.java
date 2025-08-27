package java11.programs.example.switchEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SwitchExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = Arrays.asList("java", "spring", "springboot", "springmvc","svc","c", "pyhon");
		
		List<Integer> intList = Arrays.asList(10,90,20,11,15,190,50,70);
		
		intList.stream().filter(s-> s.toString().startsWith("1")).forEach(System.out::println);
		
		int sum = intList.stream().filter(s-> s.toString().startsWith("1")).reduce(0, (a,b)-> a+b);
		
		int secLar = intList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		System.out.println(secLar);
	}
	
	//Java 14 feature - switch expressions
	/*
	public static String checkWeek(String day) {
		
		String dayOfWeek = switch(day) {
		case 0 -> {
			System.out.println("write Complex code");
			yield "Monday";
		}
		case 1 -> "Tuesday";
		case 2 -> "Wednesday";
		default -> throw new IllegalArgumentException("Undefined "+ day);
		};
		
		return dayOfWeek;
	}*/

}

package java11.programs.example.switchEx;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = List.of(1,4,5,6,7,8,9);
		
		//partation by even and odd
		List<List<Integer>> res = list.stream().collect(Collectors.partitioningBy(s->s%2==0, 
											Collectors.toList())).values().stream().collect(Collectors.toList());
		System.out.println(res);
//============================================================================================================	
		
		List<Employee> emps = List.of(new Employee(1, "Ravi", 10000),
									new Employee(2, "Suresh", 70000),
									new Employee(3, "Neeraj", 80000),
									new Employee(4, "Hari", 50000),
									new Employee(5, "Amit", 55000),
									new Employee(6, "Nitin", 75000));
		// 3rd highest salary
		emps.stream().sorted((a, b)-> Integer.compare(b.salary(), a.salary())).skip(2)
						.findFirst().ifPresent(s-> System.out.println("3rd highest salary is: "+ s.salary()));
		
//============================================================================================================	
		System.out.println();
		List<Integer> list2 = List.of(1,4,5,4,8,6,1,6,7,8,9);
		// remove duplicate
		Set<Integer> set = list2.stream().collect(Collectors.toSet());
		System.out.println(set);
		
		
		StringBuilder sb = new StringBuilder("abca");
		
		System.out.println("Is Palindrome: "+isPalindrome(sb));
		
		
		
	}
	
	static boolean isPalindrome(StringBuilder sb) {
		String s1 = sb.toString(); 
		sb.reverse();
		String s2 = sb.toString();

		
		if(s1.equals(s2)) {
			return true;
		}
		return false;
	}
}

record Employee(int id, String name, int salary) {}

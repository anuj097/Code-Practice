package java11.programs.example.Records;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecordEx {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee(1, "Ravi", "IT", "SDE",100000 ),
										new Employee(2, "Sumit", "Networking", "Junior Engineer", 200000),
										new Employee(3, "Kamal", "Sales", "Executive", 90000),
										new Employee(4, "Harish", "Infra", "Manager", 98000),
										new Employee(5, "Harish", "bank", "Manager", 95000),
										new Employee(6, "Kamal", "IT", "Manager", 100000),
										new Employee(7, "Harish", "Networking", "Manager", 120000));
		
		//sorting based on name and salary
		//list.stream().sorted(Comparator.comparing(Employee::name).thenComparing(Employee::salary)).forEach(System.out::println);
		
		List<String> sList = Arrays.asList("Men", "women", "girl", "child", "Mother","Father");
		
		//sList.stream().sorted().forEach(System.out::println);
		
		List<Integer> val = Arrays.asList(2,5,7,4,1,8,9,6);
		
		//val.stream().sorted().forEach(System.out::println);
		
		int sum = val.stream().filter(v->v%2==0).mapToInt(Integer::valueOf).sum();
		
		//System.out.println("Sum of Even numbers: "+sum);
	}

}

record Employee(int id, String name, String dept, String desgination, long salary) {}

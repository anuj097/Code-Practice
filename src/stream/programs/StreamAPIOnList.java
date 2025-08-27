package stream.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StreamAPIOnList {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("John", "Smith", "Miami", 8.38, 19, "Civil"),
												new Student("Mike", "Miles", "New York", 8.4, 21, "IT"),
												new Student("Michael", "Peterson", "New York", 7.5, 20, "Civil"),
												new Student("James", "Robertson", "Miami", 9.1, 20, "IT"),
												new Student("John", "Miller", "Miami", 7.83, 20, "Civil"));

// Find all students from Miami with a grade>8.0
		students.stream().filter(a -> a.grade()>8.0).forEach(s -> System.out.println(s.firstName()+" "+s.lastName()));
		
// Find the student with the highest grade
		students.stream().max(Comparator.comparing(Student::grade)).ifPresent(s -> System.out.println(s.firstName()+" "+s.lastName()));
		
// count the number of student in each department
		Map<String, Long> map = students.stream().collect(Collectors.groupingBy(c->c.dept(), Collectors.counting()));
		System.out.println("The number of department: "+ map);
		
// Find the average grade per department
		Map<String, Double> averageGrade = students.stream().collect(Collectors.groupingBy(c->c.dept(), 
											Collectors.averagingDouble(c->c.grade())));
		System.out.println("The average grade per department: "+ averageGrade);

//Get a Comma-separated list of student names.
		List<String> names = students.stream().map(c-> c.firstName() +","+ c.lastName()).collect(Collectors.toList());
		System.out.println("Comma seperated names of students+ "+ names);
		
// Check if all students are above 18
		boolean allAreAdult = students.stream().allMatch(s->s.age()>18);
		System.out.println("All students are above 18? "+ allAreAdult);
		
// Find the department with the most Students
		Entry<String, Long> mostStudent = students.stream().collect(Collectors.groupingBy(c->c.dept(), Collectors.counting()))
							.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Most student in department: "+ mostStudent);

// Partition students into grade > 8.0 and grade <= 8.0.
		Map<Boolean, List<Student>> partitionMap = students.stream().collect(Collectors.partitioningBy(s->s.grade()>8.0));
		System.out.println("Partition students into grade > 8.0 and grade <= 8.0 : \n"+ partitionMap);
		
// Find the student with the longest full name
		Entry<String, Integer> maxLengthName = students.stream().collect(Collectors.toMap(s->s.firstName()+" "+s.lastName(), 
											s->s.firstName().length()+s.lastName().length())).entrySet().stream()
											.max(Map.Entry.comparingByValue()).get();
		System.out.println("Student with the longest full name: "+ maxLengthName);
		
// Sort students by age, then by grade.
		students.sort(Comparator.comparing(Student::age).thenComparing(Student::grade));
		System.out.println("Sorted based on age & grade:  \n"+ students);	
		
// Find the second highest grade of the student and return the name
		List<Student> list = Arrays.asList(new Student("John", "Smith", "Miami", 8.38, 19, "Civil"),
				new Student("Mike", "Miles", "New York", 8.4, 21, "IT"),
				new Student("Michael", "Peterson", "New York", 7.5, 20, "Civil"),
				new Student("James", "Robertson", "Miami", 9.1, 20, "IT"),
				new Student("John", "Miller", "Miami", 7.83, 20, "Civil"));
		
		list.stream().sorted(Comparator.comparing(Student::grade).reversed())
		.skip(1).findFirst().ifPresent(s-> System.out.println(s.firstName())); 
		
	}
}

record Student (String firstName, String lastName, String city, double grade, int age, String dept) {};

package java11.programs.example.Records;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Examples {

	public static void main(String[] args) {
		
		/*
		 * 
		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> lines = multilineString.lines()				// separate the string in multiple lines
		  .filter(line -> !line.isBlank())
		  .map(String::strip)										// remove the spaces from left and right hand side
		  .collect(Collectors.toList());
		//assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
		System.out.println(lines);
		
		
		// Predicate.not() method in java11
		
		List<Integer> numbers = List.of(2,5,7,22,45,67,88);
		
		numbers.stream().filter(number -> number%2==0).forEach(System.out::println); // prints the even numbers
		
		numbers.stream().filter(Predicate.not(number -> number%2==0)).forEach(System.out::println);  // prints the odd numbers
		
		
		// Java 10 feature - Local variable TYPE INFERENCE
		
		List<String> name1 = List.of("Shyam", "Sam");
		List<String> name2 = List.of("Ravi" , "Suresh");
		
		//List<List<String>> names = List.of(name1, name2);
		var names = List.of(name1, name2);
		
		names.stream().forEach(System.out::println);
		
		
		
		// writing complex text in string
		
		// string should start from new line .. example below
		String str = """
				"Line 1"
				/ Line 2
				Line 3 /
				""";
		System.out.println(str);
		
		
		List<Integer> values = Arrays.asList(0,0,1,0,1,0,0,0,1,1,1,0,1,0);		
		
		values.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		*/
		List<String> names = List.of("Shyam", "Sam", "Ravi", "Shivam", "Nikhil", "Anuj");
		
		Optional<String> findFirstName= names.stream().findFirst();
		
		Optional<String> findAnyName = names.parallelStream().findAny();
		
		if(findFirstName.isPresent() && findAnyName.isPresent())
			System.out.println("findFirstName : "+findFirstName.get() +" and findAnyName : "+ findAnyName.get());
		
	
		List<Book1> books = Arrays.asList(new Book1(1000, "To Kill a Mockingbird", "Harper Lee"),
				new Book1(1200, "1984", "George Orwell"),
				new Book1(1100, "Pride and Prejudice", "Jane Austen"),
				new Book1(1000, "The Catcher in the Rye", "J.D. Salinger"),
				new Book1(900, "The Great Gatsby", "F. Scott Fitzgerald"));
		
		//Collections.sort(books, Collections.reverseOrder());
		books.stream().sorted(Comparator.comparing(Book1::getPrice).reversed())
		.skip(1).findFirst().ifPresent(s->System.out.println(s.getPrice()));
		
		books.stream().filter(s-> s.getPrice()>1000).forEach(s-> System.out.println(s.getBookName() + " - "+ s.getPrice()));
		
	}

}

class Book1 {
	
	private double price;
	private String bookName;
	private String author;
	
	@Override
	public String toString() {
		return "Book [price=" + price + ", bookName=" + bookName + ", author=" + author + "]";
	}
	public Book1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book1(double price, String bookName, String author) {
		super();
		this.price = price;
		this.bookName = bookName;
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}

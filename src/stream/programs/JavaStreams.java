package stream.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaStreams {

	public static void main(String[] args) {
		//Output : Largest possible number by re-arranging the list integers
		
		List<Integer> A = Arrays.asList(7,5,33,4,30,6,3);
		List<String> list = A.stream().map(s-> "" + s).sorted((a1, a2) -> (a2+a1).compareTo((a1+a2))).collect(Collectors.toList());

		String str = "";
		for(String s : list){
			System.out.print(s+" ");
			str +=s;
		}
		System.out.println();
		System.out.println("Largest possible number after re-arranging the list= "+str);  //765433330
		
		
		List<Book> books = Arrays.asList(new Book(1000, "To Kill a Mockingbird", "Harper Lee"),
				new Book(1200, "1984", "George Orwell"),
				new Book(1100, "Pride and Prejudice", "Jane Austen"),
				new Book(1000, "The Catcher in the Rye", "J.D. Salinger"),
				new Book(900, "The Great Gatsby", "F. Scott Fitzgerald"));

		// Use of DoubleSummarySatatistics 
		
		DoubleSummaryStatistics dss = books.stream().mapToDouble(Book :: getPrice).summaryStatistics(); // first way
		DoubleSummaryStatistics dss2 = books.stream().collect(Collectors.summarizingDouble(Book :: getPrice)); // second way
		
		System.out.println("<----- USE OF DoubleSummaryStatistics ----->");
		System.out.println("Count: "+ dss.getCount());
		System.out.println("Max: "+ dss.getMax());
		System.out.println("Average: "+ dss2.getAverage());
		System.out.println("Sum: "+ dss2.getSum());

		List<Integer> ls = Arrays.asList(1,2,3,4,4,3,5,7);
		
		Set<Integer> duplicates = ls.stream().filter(s-> Collections.frequency(ls, s)>1).collect(Collectors.toSet());
		System.out.println("Duplicate Numbers are: "+ duplicates);
		
		int sum = ls.stream().mapToInt(m->m).sum();
		System.out.println("SUm is: "+ sum);
		
		System.out.println();
		
		System.out.println("<--- FLAT MAP --->");
		List<List<String>> lists = Arrays.asList(Arrays.asList("java", "c++", "c"),
												Arrays.asList("python", "springmvc", "c#"),
												Arrays.asList("sql", "spring", "sprinboot"));
		
		List<String> li = lists.stream().flatMap(s -> s.stream()) //.flatMap(Collection::stream)
							.filter(s-> s.startsWith("s")).collect(Collectors.toList());
		System.out.print(li);
		
	}
	

}

class Book {
	
	private int price;
	private String bookName;
	private String author;
	
	@Override
	public String toString() {
		return "Book [price=" + price + ", bookName=" + bookName + ", author=" + author + "]";
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int price, String bookName, String author) {
		super();
		this.price = price;
		this.bookName = bookName;
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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

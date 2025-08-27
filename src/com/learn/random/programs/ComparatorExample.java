package com.learn.random.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
	
	// 		Use Of String.CASE_INSENSITIVE_ORDER : 
	//		if we have some values starts with small letter and some starts with Upper letter,
	//		it will give different result, to maintain the correct sorting we use it.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Book> books = Arrays.asList(new Book(1000, "To Kill a Mockingbird", "Harper Lee"),
										new Book(1200, "1984", "George Orwell"),
										new Book(1100, "Pride and Prejudice", "Jane Austen"),
										new Book(1000, "The Catcher in the Rye", "J.D. Salinger"),
										new Book(900, "The Great Gatsby", "F. Scott Fitzgerald"));
		
// if we want to sort using two fields
// if we have same price of two books, and we want to sort them based on Book name irrespective of case sensitive 
		
		books.sort(Comparator.comparing(Book :: getPrice)
			.thenComparing(Book :: getBookName, String.CASE_INSENSITIVE_ORDER));
		
		System.out.println("Sorting on more then one element: "+ books);
		System.out.println();
		
// ************************************************************************************************************************************
		
// SORTING: Sorting in assending order;
		List<String> players = Arrays.asList("Sachin", "Sahwag", "Dhoni", "Virat", "Shubhman", "Riyan", "Harshit", "Abhishek", "Bumrah"
							, "Surya", "Deepak", "hardik", "Jadeja", "Shivam", "bhuvi");

		Collections.sort(players, String.CASE_INSENSITIVE_ORDER); 
		System.out.println("Sort in Assending Order: " + players);
		System.out.println();
		
// SORTNG: Sorting in reverse order;
		List<String> players2 = Arrays.asList("Sachin", "Sahwag", "Dhoni", "Virat", "Shubhman", "Riyan", "Harshit", "Abhishek", "Bumrah"
				, "Surya", "Deepak", "hardik", "Jadeja", "Shivam", "bhuvi");
		
		//Collections.sort(players2, (O1, O2)-> O2.compareToIgnoreCase(O1));
		players2.sort((O1, O2)-> O2.compareToIgnoreCase(O1));
		System.out.println("Sorting in reverse order: "+ players2);
		System.out.println();
		
// SEARCHING : using binary search on a List (CAUTION: List should be in a sorted order firstS)
		
		int index = Collections.binarySearch(players, "Riyan");
		System.out.println("The Index number of Riyan is: "+ index);
		System.out.println();

// REVERSING: reverse a List
		
		List<String> players3 = Arrays.asList("Sachin", "Sahwag", "Dhoni", "Virat", "Shubhman", "Riyan", "Harshit", "Abhishek", "Bumrah"
				, "Surya", "Deepak", "hardik", "Jadeja", "Shivam", "bhuvi");
		
		Collections.reverse(players3);
		System.out.println("Reversing a List: "+ players3);
		System.out.println();
		
// SHUFFLING: Shuffle the list
		
		Collections.shuffle(players3);
		System.out.println("Suffeling a List: "+ players3);
		System.out.println();
		
// SWAPPING: swaping the elements 
		
		Collections.swap(players3, 0, 14);
		System.out.println("Swapping the elements: "+ players3);
		System.out.println();

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

package stream.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Testing {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1
//		Check ts = new Check();
//		
//		Thread t1 = new Thread(() -> ts.writerThread());
//		Thread t2 = new Thread(() -> ts.readThread());
//		
//		t1.start();
//		t2.start();
		
		//2
		Counter c = new Counter();
		
		Thread t1 = new Thread(()-> {
		System.out.println(c.increment());
		});
		Thread t2 = new Thread(()-> {
			System.out.println(c.increment());
			});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
		//3
		//test();
		//4
		//System.out.println(test2(7));
		//5
		test3();
	}
	
	// First non repeating character in String 
	public static void test() {
		String s1 = "abchbcal";
		
		Map<Character, Long> map=s1.chars().mapToObj(s-> (char)s).collect(Collectors.groupingBy(Function.identity(),
				Collectors.counting()));
		char occur = map.entrySet().stream().filter(s-> s.getValue()==1).findFirst().map(s->s.getKey()).get();
		System.out.println("First non-repeating character: "+ occur);
	}
	// febonacci 
	public static int test2(int n) { // 0 1 1 2 3 5 8 13
		if(n<=1)
			return n;
		
		return (test2(n-1) + test2(n-2));
		
	}
	// Sum of all numbers in List
	public static void test3() {
		List<Integer> l1 = Arrays.asList(1,4,3,5,6,7);
		// 1st Way
		int sum = l1.stream().mapToInt(s-> s).sum();
		System.out.println(sum);
		
		// 2nd way
		System.out.println( l1.stream().reduce(0,(s,t)-> s+t));
	}
	
	public static void test4() {
		List<Integer> l1 = Arrays.asList(1,4,3,5,6,7);
		
	}

}



class Check extends Thread{

	int x=0;
	
	public void writerThread() {
		try { Thread.sleep(100); } catch (Exception e) {}
		x=1;
		System.out.println(x);
	}
	
	public void readThread() {
		int a = x;
		System.out.println(a);
	}
}

class Counter extends Thread {
	AtomicInteger count = new AtomicInteger();
	public int increment() {
		return count.incrementAndGet();
	}
}

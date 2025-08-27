package stream.programs;

public class JustRandom implements in1, in2{

	public static void main(String[] args) {
		JustRandom j = new JustRandom();
		j.display();
	}

	// need to override below 
	@Override
	public void display() {
		// TODO Auto-generated method stub
		in1.super.display();
	}
}

interface in1 {
	public static int n=100;
	public default void display() {
		System.out.println("from in 1");
	}
}

interface in2 {
	public static int n=199;
	public default void display() {
		System.out.println("from in 2");
	}
}

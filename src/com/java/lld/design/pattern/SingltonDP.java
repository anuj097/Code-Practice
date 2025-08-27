package com.java.lld.design.pattern;

public class SingltonDP {
	
	/*
	 * Breaking a Singleton pattern and fixing : 

		1> using reflection
		Reflection can access private constructors and create a new instance.
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		Singleton newInstance = constructor.newInstance();  // new instance created
		Fix: Throw exception if instance already exists inside the constructor:
		private Singleton() {
		    if (instance != null) {
		        throw new RuntimeException("Use getInstance() method to create");
		    }
		}
		
		2> Serialization/de-serialization
		Deserializing a Singleton creates a new instance.
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.ser"));
		out.writeObject(Singleton.getInstance());
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.ser"));
		Singleton newInstance = (Singleton) in.readObject();  // new instance created
		Fix: Implement readResolve() method:
		protected Object readResolve() {
		    return getInstance();
		}
		
		3> Cloning
		Cloning can create a copy of the singleton object.
		Singleton instance2 = (Singleton) instance.clone();
		Fix: Override clone() method and throw exception
		@Override
		protected Object clone() throws CloneNotSupportedException {
		    throw new CloneNotSupportedException("Cloning not allowed");
		}
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton ins = Singleton.getInstance();
		Singleton ins2 = Singleton.getInstance();

		System.out.println("First Instance: "+ ins +"\n"+ "Second Instance: "+ ins2);
		
		System.out.println();
		Singletonn in = Singletonn.getInstance();
		Singletonn in2 = Singletonn.getInstance();
		
		System.out.println("First Instance: "+ in +"\n"+ "Second Instance: "+ in2);
	}

}

// single check
class Singleton {
	
	private static Singleton ins;
	
	private Singleton() {};
	
	public static synchronized Singleton getInstance() {
		
		if(ins==null) {
			ins = new Singleton();
		}
		return ins;
	}
}

// double check 
class Singletonn {
	private static Singletonn ins;
	
	private Singletonn() {}
	
	public static Singletonn getInstance() {
		if (ins == null) {
			//synchronized (ins) {
			synchronized (Singletonn.class) {
				if (ins == null) {
					ins = new Singletonn();
				}
			}
		}
		return ins;
	}
}

package main;

class MyClass extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Value" + i);
		}
		
	}
	
}

public class Demo {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		myClass.start();

	}

}


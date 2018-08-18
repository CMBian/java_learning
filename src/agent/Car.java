package agent;

public class Car implements IRun{
	
	public void wheels() {
		System.out.println("it has  1 wheel");
	}
	
	public void tires() {
		System.out.println("it has 4 tires");
	}
	
	public void run() {
		System.out.println("i can run");
	}
}

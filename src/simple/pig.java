package simple;

public class pig extends abstractAnimal implements Animal {
	public void eat() {
		System.out.println("pig is eating");
	}

	@Override
	public void reproduce() {
		// TODO Auto-generated method stub
		System.out.println("i can reproduce");
	}
}

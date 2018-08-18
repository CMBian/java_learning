package designPatern;

public class Car {
	private static Car car;
	private String name;
	private int price;
	public Car Car() {
		if(car == null) {
			synchronized (Car.class) {
				if(car == null) {
					car = new Car();
				}
			}
			
		}
		return car;
	}
}

package agent;

public class test {
	public static void main(String[] args) {
		Car car = new Car();
		logAgent proxyHandler = new logAgent(car);
		IRun iCar = (IRun)proxyHandler.getProxy();
		iCar.run();
		
		Customer cust = new Customer();
		CanadaAgent canadaAgent = new CanadaAgent(cust);
		IBuy iBuy = (IBuy)canadaAgent.getProxy();
		iBuy.buy();
		iBuy.see();
	}
}

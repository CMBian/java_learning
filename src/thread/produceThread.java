package thread;

public class produceThread extends Thread{
	private Factory factory;
	public produceThread(String name, Factory factory){
		super(name);
		this.factory = factory;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		this.factory.produce();
	}
}
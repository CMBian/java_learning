package thread;

public class consumeThread extends Thread{
	private Factory factory;
	public consumeThread(String name, Factory factory){
		super(name);
		this.factory = factory;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			this.factory.consume();
		}
			
		
	}
}
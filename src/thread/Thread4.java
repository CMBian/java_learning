package thread;

import java.util.concurrent.TimeUnit;

public class Thread4 extends Thread {

	public Thread4(String name) {
		super(name);
	}
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName() + " "+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread4 th2 = new Thread4("new thread");
		th2.start();
		System.out.print("$$$$$$");
		//th2.join();
		for (int i = 0; i < 10; i++) {
			if(i == 5) {
				Thread4 th1 = new Thread4("joined Thread");
				th1.start();
				th1.join();
			}
			System.out.println(i);
		}
		//TimeUnit.SECONDS.sleep(3);;
		//th2.wait();
		//th2.notify();
		//System.out.print("###########");
		
	}
}

package thread;

import java.util.concurrent.TimeUnit;

public class threadLocaltest {
	private static int value = 0;

	
	static class myThread implements Runnable {
		private int i;
		public myThread(int i) {
			this.i = i;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.print("original value is"+value);
			for(int i = 0; i < 10; i ++) {
				value = value + 1;
			}
			System.out.println("final value is "+value);
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 3; i++) {
			Thread thread = new Thread(new myThread(i), "trhead"+i);
			thread.start();
			TimeUnit.SECONDS.sleep(3);
		}
		
	}
	
}

package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPrint {
	private static Object monitor = new Object();
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition A = lock.newCondition();
	private static Condition B = lock.newCondition();
	private static int threadId = 1;
	private static boolean thread3 = true;
	private static boolean thread4 = false;
	public static void main(String[] args) {
		
		Thread1 th1 = new Thread1();
		Thread2 th2 = new Thread2();
		Thread3 th3 = new Thread3();
		Thread4 th4 = new Thread4();
		
		Thread t1,t2,t3,t4;
		t1 = new Thread(th1);
		t2 = new Thread(th2);
		t3 = new Thread(th3);
		t4 = new Thread(th4);
		//t1.start();
		//t2.start();
		t3.start();
		t4.start();
		
		
	}
	
	 private static class Thread1 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 1; i <= 3; i++) {
				lock.lock();
				try {
					while(threadId != 1) {
							A.await();
					}
					System.out.println(i*2- 1);
					threadId = 2;
					B.signal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
		}
		}
	}
	 private static class Thread2 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i = 1; i <= 3; i++) {
				lock.lock();
				try {
					while(threadId != 2) {
							B.await();
					}
					System.out.println(i*2);
					threadId = 1;
					A.signal();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					lock.unlock();
				}
				
			}			
		}
		
	}
	private static class Thread3 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for(int i = 1; i <= 3; i++) {
					synchronized(monitor) {
						while(thread4) {
							System.out.println("thread3 is waiting");
							monitor.wait();
						}
						System.out.println(i*2-1);
						thread3 = false;
						thread4 = true;
						System.out.println("thread3 finish");
						//monitor.notifyAll();
					}
			}
			}catch(Exception io) {
				
			}
		}
		
	}
	private static class Thread4 implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for(int i = 1; i <= 3; i++) {
					synchronized(monitor) {
						while(thread3) {
							System.out.println("thread4 is waiting");
							monitor.wait();
						}
						System.out.println(i*2);
						thread4 = false;
						thread3 = true;
						System.out.println("thread4 finish");
						//monitor.notifyAll();
					}
			}
			}catch(Exception io) {
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}

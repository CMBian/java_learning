package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Factory{
	public final static int MAX_PRODUCT = 5;
	public final static int MIN_PRODUCT = 3;
	private int product = 0;
	final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 
	public  void produce()
	  {
		lock.lock();
		System.out.println("current there are " + this.product + "product.");
		try {
	      if(this.product >= MAX_PRODUCT)
	      {
	          try
	          {
	              notFull.await();  
	              System.out.println("full, please consume");
	          }
	          catch(InterruptedException e)
	          {
	              e.printStackTrace();
	          }
	          return;
	      }
	 
	      this.product++;
	      System.out.println("produce " + this.product + "");
	      notEmpty.signal();
		}finally {
			lock.unlock();
		}
	  }
	public  void consume()
	  {
		lock.lock();
		System.out.println("current there are " + this.product + "product.");
		try {
	      if(this.product <= MIN_PRODUCT)
	      {
	          try
	          {
	              notEmpty.await();
	              System.out.println("not enough, handon");
	          } 
	          catch (InterruptedException e) 
	          {
	              e.printStackTrace();
	          }
	          return;
	      }
	 
	      System.out.println("consue" + this.product + "product.");
	      this.product--;
	      notFull.signal();
		}finally {
			lock.unlock();
		}
	  }
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Factory factory = new Factory();
		produceThread produce = new produceThread("produce", factory);
		consumeThread consume = new consumeThread("consume", factory);
		
		produce.start();
		TimeUnit.SECONDS.sleep(3);
		consume.start();
		
	}
	
}

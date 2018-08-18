package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class returnvaluefromthread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		mycallable myThreadA = new mycallable("a");
		mycallable myThreadB = new mycallable("B");
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<String> future = pool.submit(myThreadA);
		Future<String> future1 = pool.submit(myThreadB);
		System.out.println(future.get());
		System.out.println(future1.get());
		//pool.shutdown();
		
		
		FutureTask<String> fTask = new FutureTask<String>(myThreadA);
		pool.submit(fTask);
		System.out.println("this is ftask"+fTask.get());
		
		
	}
}

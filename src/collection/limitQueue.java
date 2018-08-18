package collection;

import java.util.concurrent.locks.ReentrantLock;

import java.util.LinkedList;;

public class limitQueue<E> extends LinkedList<E> {
	ReentrantLock lock = new ReentrantLock();
	private int limitSize = 10;
	@Override
	public boolean offer(E e) {
		lock.lock();
		boolean retFlg = false;
		try {
			retFlg =  super.offer(e);
			if(size() > limitSize ) { 
				removeFirst();
			}
		}finally {
			lock.unlock();
			
		}
		return retFlg;
		
	}
}

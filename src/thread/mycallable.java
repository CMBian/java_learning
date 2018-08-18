package thread;

import java.util.concurrent.Callable;

class mycallable implements Callable<String>{
	private String id;
	public mycallable(String id){
		this.id = id;
	}
	@Override
	public String call() throws Exception {
		return "this is a callbal class";
	}
}

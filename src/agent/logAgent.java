package agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class logAgent implements InvocationHandler {
	private Object mTarget = new Object();
	
	public logAgent(Object mTarget) {
		this.mTarget = mTarget;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before the method call");
		method.invoke(mTarget, args);
		System.out.println("after the method call");
		return null;
	}
	public Object getProxy() {
		return Proxy.newProxyInstance(mTarget.getClass().getClassLoader(), mTarget.getClass().getInterfaces(), this);
	}
	
	

}

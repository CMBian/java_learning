package agent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CanadaAgent implements InvocationHandler {
	private Object mTarget;
	public CanadaAgent(Object mTarget) {
		this.mTarget = mTarget;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		String methodName = method.getName();
		if(methodName.equals("buy")) {
			method.invoke(mTarget, args);
			payTax();
		}
		if(methodName.equals("see")) {
			getVisa();
			method.invoke(mTarget, args);
		}
		
		return null;
	}
	private void payTax() {
		System.out.println("ipay tax for product");
	}
	private void getVisa() {
		System.out.println("get visa before go to canada");
	}
	
	public Object getProxy() {
		return Proxy.newProxyInstance(mTarget.getClass().getClassLoader(), mTarget.getClass().getInterfaces(), this);
	}
}

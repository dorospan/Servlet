package cn.tedu.mvc;

import java.lang.reflect.Method;

public class Handler {
	
	private Method method;
	private Object object;
	
	public Handler(Method method, Object object) {
		super();
		this.method = method;
		this.object = object;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Handler [method=" + method + ", object=" + object + "]";
	}
	
	
	
	
}

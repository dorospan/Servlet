package cn.tedu.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HandlerMapping {
	
	Map<String, Handler> map = new HashMap<String, Handler>();

	
	public Handler getHandlerWithPath (String path) {
		return map.get(path);
	}
	
	
	public void init (List<Object> beans) {
		for (Object object : beans) {  // path  handler(method object)  现在已有object，再需要path和method
			Class clazz = object.getClass();
			Method[] methods = clazz.getDeclaredMethods(); // 获取方法
			for (Method method : methods) { 
				RequestMapping requestMapping = method.getAnnotation(RequestMapping.class); // 从方法中获取注解
				if (requestMapping != null) {
					String path = requestMapping.value();
					map.put(path, new Handler(method, object));
				}
				
			}
			
		}
		
	}
	
	
}

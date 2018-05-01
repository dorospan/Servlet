package cn.tedu.mvc;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class DispacherServlet extends HttpServlet {
	
	HandlerMapping handlerMapping =  new HandlerMapping();
	
	@Override
	/** 创建handlerMapping对象并初始化 */
	public void init(ServletConfig config) throws ServletException { // 请求来之前已经创建好handlerMapping  ???
		
		try {
			handlerMapping.init(MyXMLUtils.getBeans());
			System.out.println(0000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println(6666);
		
			// 通过地址path找到对应方法并执行
		
			String path = request.getServletPath();
			System.out.println("path: "+path);
			
			Handler handler = handlerMapping.getHandlerWithPath(path); // 从handlerMapping里获取path对应的handler
			
			if (handler == null) {
				return;
			}
			
			Object object = handler.getObject();
			Method method = handler.getMethod();
			try {
				Class[] paramTypes =  method.getParameterTypes(); // 获取参数类型

				Object returnVal = null; // 声明目标方法的返回值
				if (paramTypes.length > 0) { // 如果有1+个类型，即有参数
					Object[] args = new Object[paramTypes.length];
					for (int i=0; i<args.length; i++) { // 将参数类型数组一边遍历一边判断是何种类型，只要是request  response就放到invoke(object, args)的args中，args即方法参数
						Class clazz = paramTypes[i];
						if (clazz == HttpServletRequest.class) {
							args[i] = request;
						} else if (clazz == HttpServletResponse.class) {
							args[i] = response;
						}
					}
					returnVal = method.invoke(object, args);
				} else {
					returnVal = method.invoke(object, null);
				}
				if (returnVal != null) { // 若有返回值，要么转发 要么再的重定向
					// 通过视图解析器对象 处理转发或重定向
					ViewResolver viewResolver = new ViewResolver();
					viewResolver.process(returnVal, request, response); // (目标方法，请求，响应)
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

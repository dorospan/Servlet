package cn.tedu.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	public void process(Object returnVal, HttpServletRequest request, HttpServletResponse response) {
		
		// 没有redirect就是转发； 有redirect就是重定向
		String path = (String) returnVal;
		if (path.startsWith("redirect:")) { // 重定向   jsp无法直接访问，都要通过xxx.do来访问，因此重定向都到 xxx.do
			// "redirect:remove.do "
			path = path.split(":")[1];  // 要后面的 xxx.do
			path = request.getContextPath()+"/"+path; // 工程名/xxx.do
			try {
				response.sendRedirect(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 转发
			try {   // 转发都是到xxx.jsp ，return xxx, 这里拼上jsp
				request.getRequestDispatcher("/WEB-INF/"+path+".jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	
	
}

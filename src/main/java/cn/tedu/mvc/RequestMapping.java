package cn.tedu.mvc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 此注解存在于运行时
@Target(ElementType.METHOD) // 设置此注解是给方法用的
public @interface RequestMapping {
	
	// @RequestMapping("/add.do") 
	// 以下value指的是上面()内的信息
	public String value(); // 此类的属性；只能public 或 abstract，其他类才能用上它
	
	
}

package cn.tedu.mvc;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyXMLUtils {

	public static List<Object> getBeans() throws Exception {

		SAXReader saxReader = new SAXReader();
		InputStream in = DispacherServlet.class.getClassLoader().getResourceAsStream("config.xml");
		Document document = saxReader.read(in);
		// 获取根节点
		Element beansElement = document.getRootElement();
		List<Element> elements = beansElement.elements("bean"); // 获取子节点
		
		List<Object> beans = new ArrayList<Object>();
		for (Element element : elements) {
			String className = element.attributeValue("class"); // class为config.xml里 bean中的属性class="blablabla"，要拿的就是blablabla
			Class clazz = Class.forName(className); // 映射类
			Object bean = clazz.newInstance(); // 实例化bean
			beans.add(bean); // 加到beansList中
		}
		
		return beans;
	}

}

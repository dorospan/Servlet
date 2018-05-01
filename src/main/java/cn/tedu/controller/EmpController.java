package cn.tedu.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.tedu.beans.Dept;
import cn.tedu.beans.Emp;
import cn.tedu.mvc.RequestMapping;
import cn.tedu.service.DeptService;
import cn.tedu.service.EmpService;


public class EmpController {
	
	EmpService empService;
	public EmpController() {
		empService = new EmpService();
	}
	
	
	@RequestMapping("/emp/findall.do")
	public String findAll (HttpServletRequest request) {
		System.out.println("执行了findAll用户的方法");
		List<Emp> emps = empService.findAll();
		request.setAttribute("emps", emps);
		return "emplist";
	}
	
	
	@RequestMapping("/emp/remove.do")
	public String remove (HttpServletRequest request) {
		System.out.println("执行了remove方法");
		String empno = request.getParameter("EMPNO");
		empService.remove(empno); // 删除就直接删  没啥返回
		return "redirect:emp/findall.do";
		
	}
	
	@RequestMapping("/emp/addview.do")
	public String addView (HttpServletRequest request) {
		// 先获取所有部门
		
		DeptService deptService = new DeptService();
		List<Dept> deptList = deptService.findAll();
		request.setAttribute("deptList", deptList);
		return "addemp"; // 转发到 addemp.jsp
	}
	
	@RequestMapping("/emp/add.do")
	public String add (HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 要先从request里拿用户输入的参数
		String empno = request.getParameter("EMPNO");
		String ename = request.getParameter("ENAME");
		String job = request.getParameter("JOB");
		String sal = request.getParameter("SAL");
		String comm = request.getParameter("COMM");
		String deptno = request.getParameter("DEPTNO");
		
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(empno));
		emp.setEname(ename);
		emp.setJob(job);
		emp.setSal(Double.parseDouble(sal));
		emp.setComm(Double.parseDouble(comm));
		
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(deptno));
		emp.setDept(dept);
		
		empService.add(emp);

		return "redirect:emp/findall.do"; // 增加完后重定向到findall页面
		
	}
	
	@RequestMapping("/emp/updateview.do")
	public String findOne(HttpServletRequest request) {
		
		int empno = Integer.parseInt(request.getParameter("EMPNO"));
		Emp emp = empService.findOneById(empno);
		request.setAttribute("emp", emp);
		// 修改部门信息
		DeptService deptService = new DeptService();
		List<Dept> deptList = deptService.findAll();
		request.setAttribute("dept", deptList);
		
		return "update"; // 转发   与重定向 怎么定要用哪个？
	}
	
	@RequestMapping("/emp/update.do")
	public String update(HttpServletRequest request) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(333);
		// 要先从request里拿用户输入的参数
		String empno = request.getParameter("EMPNO");
		String ename = request.getParameter("ENAME");
		String job = request.getParameter("JOB");
		String sal = request.getParameter("SAL");
		String comm = request.getParameter("COMM");
		String deptno = request.getParameter("DEPTNO");
		System.out.println("empno: "+empno);
		
		Emp emp = new Emp();
		emp.setEmpno(Integer.parseInt(empno));
		emp.setEname(ename);
		emp.setJob(job);
		emp.setSal(Double.parseDouble(sal));
		emp.setComm(Double.parseDouble(comm));
		
		Dept dept = new Dept();
		dept.setDeptno(Integer.parseInt(deptno));
		emp.setDept(dept);
		System.out.println(111);
		empService.update(emp);
		System.out.println(222);
		return "redirect:emp/findall.do";
		
	}
	
}

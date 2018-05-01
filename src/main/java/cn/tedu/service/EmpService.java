package cn.tedu.service;

import java.util.List;

import cn.tedu.beans.Emp;
import cn.tedu.dao.EmpDao;

public class EmpService {
	
	private EmpDao empDao;
	
	/** 构造； 静态块：只有一份时使用*/
	// 到哪一步会初始化？
	public EmpService() {
		empDao = new EmpDao();
	}

	public List<Emp> findAll () {
		return empDao.findAll();
	}

	public void remove(String empno) {
		empDao.remove(empno);
	}

	public void add(Emp emp) {
		empDao.add(emp);
	}

	public Emp findOneById(int empno) {
		return empDao.findOneById(empno);
	}

	public void update(Emp emp) {
		
		empDao.update(emp);
		
		
	}
	
	
	
}

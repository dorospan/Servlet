package cn.tedu.service;

import java.util.List;

import cn.tedu.beans.Dept;
import cn.tedu.dao.DeptDao;

public class DeptService {
	
	public List<Dept> findAll () {
		DeptDao deptDao = new DeptDao();
		return deptDao.findAll();
		
		
	}
	
	
}

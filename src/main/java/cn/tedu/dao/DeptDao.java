package cn.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.beans.Dept;
import cn.tedu.beans.Emp;
import cn.tedu.utils.DatabaseUtils;

public class DeptDao {
	
	
	/** 查 */
	public List<Dept> findAll () {
		
		List<Dept> deptList = new ArrayList<Dept>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "SELECT * FROM dept";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("DEPTNO"));
				dept.setDname(rs.getString("DNAME"));
				deptList.add(dept);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
		return deptList;
		
	}

	
	
}

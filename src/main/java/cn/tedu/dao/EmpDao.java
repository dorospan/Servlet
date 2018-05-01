package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.beans.Dept;
import cn.tedu.beans.Emp;
import cn.tedu.utils.DatabaseUtils;

public class EmpDao {
	
	/** 查 */
	public List<Emp> findAll () {
		
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "SELECT e.*, d.dname FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				
				emp.setSal(rs.getDouble("SAL"));
				emp.setComm(rs.getDouble("COMM"));
				
				Dept dept = new Dept();
				dept.setDname(rs.getString("DNAME"));
				emp.setDept(dept);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
		return empList;
		
	}

	/** 删*/
	public void remove(String empno) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "DELETE FROM emp WHERE EMPNO = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, Integer.parseInt(empno));
			stat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
		
		
		
	}
	
	/** 增 */
	public void add(Emp emp) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "INSERT INTO emp (EMPNO, ENAME, JOB, SAL, COMM, DEPTNO) VALUES(?, ?, ?, ?, ?, ?)";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, emp.getEmpno());
			stat.setString(2, emp.getEname());
			stat.setString(3, emp.getJob());
			stat.setDouble(4, emp.getSal());
			stat.setDouble(5, emp.getComm());
			stat.setInt(6, emp.getDept().getDeptno());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
	}
	
	/** 查一个人 修改用*/
	public Emp findOneById (int empno) {

		Emp emp = new Emp();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "SELECT e.*, d.dname FROM emp e LEFT JOIN dept d ON e.deptno=d.deptno WHERE EMPNO = ?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, empno);
			rs = stat.executeQuery();
			while (rs.next()) {
				emp.setEmpno(rs.getInt("EMPNO"));
				emp.setEname(rs.getString("ENAME"));
				emp.setJob(rs.getString("JOB"));
				emp.setSal(rs.getDouble("SAL"));
				emp.setComm(rs.getDouble("COMM"));
				
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("DEPTNO"));
				dept.setDname(rs.getString("DNAME"));
				emp.setDept(dept);
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
		return null;
	}

	
	public void update(Emp emp) {
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtils.getConnection();
			String sql = "UPDATE emp SET ENAME = ?, JOB = ?, SAL = ?, COMM = ?, DEPTNO = ? WHERE EMPNO = ? ";
			stat = conn.prepareStatement(sql);
			stat.setString(1, emp.getEname());
			stat.setString(2, emp.getJob());
			stat.setDouble(3, emp.getSal());
			stat.setDouble(4, emp.getComm());
			
			stat.setInt(5, emp.getDept().getDeptno());
			stat.setInt(6, emp.getEmpno());
			stat.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(conn, stat, rs);
		}
		
		
		
		
		
		
		
	}

	
	
	
}

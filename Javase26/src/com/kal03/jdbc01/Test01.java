package com.kal03.jdbc01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class Test01 {
	public static void main(String[] args) {
		// 需求:把emp表中的数据数据获取到并输出在控制台
		
		Connection con = DBHelper.open();
		ArrayList<EMP> list = new ArrayList<EMP>();
		
		String sql = "select * from emp";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EMP emp = new EMP();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setMgr(rs.getInt(4));
				emp.setHiredate(new Date(rs.getDate(5).getTime()));
				emp.setSal(rs.getDouble(6));
				emp.setComm(rs.getDouble(7));
				emp.setDeptno(rs.getInt(8));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(con, stmt, rs);
		}
		
		for (EMP emp : list) {
			System.out.println(emp);
		}
		
	}
}

package com.aitehulian.persist.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aitehulian.common.JdbcUtil;
import com.aitehulian.domain.Student;
import com.aitehulian.persist.StudentDao;

/**
 * @Description: TODO
 * @author 作者：沈传新
 * @version 创建时间：2016-8-16 下午12:57:43
 */
public class StudentDaoImpl implements StudentDao {

	public boolean login(int stu_no, String password) {

		// 添加执行sql语句
		String sql = "select password from student where stu_no=?";
		Connection conn = null;
		try {
			// 利用工具类JdbcUtil得到连接
			conn = JdbcUtil.getConnection();
			// 准备执行sql语句。
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.setInt(1, stu_no);
			// 执行查找，返回查找集
			ResultSet rs = ppst.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(password))
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				JdbcUtil.closeConnection(conn);
		}
		return false;
	}

	public boolean regist(Student stu) {
		Connection conn = null;
		String sql = "insert into student(name, password, sex,	telPhone, email) values(?,?,?,?,?)";
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.setString(1, stu.getName());
			ppst.setString(2, stu.getPassword());
			ppst.setString(3, stu.getSex());
			ppst.setString(4, stu.getTelPhone());
			ppst.setString(5, stu.getEmail());
			// 返回的是执行sql语句的行数
			int row = ppst.executeUpdate();
			System.out.println(row);
			if (row == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				JdbcUtil.closeConnection(conn);
		}
		return false;
	}

	public Student equryInfo(int stuNo) {
		String sql = "select * from student where stu_no=?";
		Connection conn = null;
		Student stu = new Student();
		try {
			conn = JdbcUtil.getConnection();
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.setInt(1, stuNo);
			ResultSet rs = ppst.executeQuery();
			while (rs.next()) {
				int stu_no = rs.getInt(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String sex = rs.getString(4);
				String telPhone = rs.getString(5);
				String email = rs.getString(6);
				stu.setStu_no(stu_no);
				stu.setPassword(password);
				stu.setName(name);
				stu.setSex(sex);
				stu.setTelPhone(telPhone);
				stu.setEmail(email);
			}
			System.out.println(stu);
			return stu;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				JdbcUtil.closeConnection(conn);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#delete(int)
	 */
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#select(java.lang.String)
	 */
	public ArrayList select(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#update(java.lang.String)
	 */
	public boolean update(String sql) {
		// TODO Auto-generated method stub
		return false;
	}

}

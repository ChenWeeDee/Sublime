package com.aitehulian.persist.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aitehulian.common.JdbcUtil;


/**
 * @author Daizhenwei
 * @Description	
 * @Data 2016-9-8 下午07:01:28
 */
public class TestConn {
	public static void main(String[] args) {
		Connection conn = JdbcUtil.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement("select * from student where 1=1&&stu_classroom like 'A班' ");
			ResultSet res = pstm.executeQuery();
			while(res.next()){
				String name = res.getString("stu_name");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.aitehulian.persist.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aitehulian.common.JdbcUtil;
import com.aitehulian.domain.Student;
import com.aitehulian.persist.StudentDao;

/**
 * @author Daizhenwei
 * @Description	针对学生信息的持久层操作
 * @Data 2016-9-5 下午05:03:56
 */
public class StudentInfoDaoImpl implements StudentDao {

	/**
	 * 获取数据库连接
	 */
	Connection conn = null;
	public StudentInfoDaoImpl(){
	}
	public boolean delete(int num) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#equryInfo(int)
	 */
	public Student equryInfo(int stuNo) {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#login(int, java.lang.String)
	 */
	public boolean login(int stuNo, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	/* (non-Javadoc)
	 * @see com.aitehulian.persist.StudentDao#regist(com.aitehulian.domain.Student)
	 */
	public boolean regist(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 条件查询学生数据
	 */
	public ArrayList<Student> select(String sql) {
		conn = JdbcUtil.getConnection();
		ArrayList <Student> stuInfos = new ArrayList<Student>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet res = pstm.executeQuery();
			int i=0;
			while(res.next()){
				Student stu = new Student();
				stu = (Student)res.getObject(i);
				i++;
				stuInfos.add(stu);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null)
				JdbcUtil.closeConnection(conn);
		}
		return stuInfos;
	}
	//实现分页显示
	public List getDatabypage(int pageindex) throws SQLException{
		List list = new ArrayList();
		String sql = "select *from student where id between ? and ?";
		conn = JdbcUtil.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, 10*(pageindex-1)+1);
		pstm.setInt(2, 10*pageindex);
		ResultSet res = pstm.executeQuery();
		int i=0;
		while(res.next()){
			Student stu = new Student();
			int Id = (int)res.getInt("stu_id");
			int stu_no = (int)res.getInt("stu_no");
			String name = (String)res.getString("name");
			String sex = (String)res.getString("sex");
			String email = (String)res.getString("email");
			String telPhone = (String)res.getString("phone");
			stu.setId(Id);
			stu.setStu_no(stu_no);
			stu.setName(name);
			stu.setSex(sex);
			stu.setEmail(email);
			stu.setTelPhone(telPhone);
			list.add(i,stu);
			i++;
		}
		return list;
	}
	/*获取留言总数*/
	public int getAllpages(){
		int counts = 0;
		try {
			conn=JdbcUtil.getConnection();
			System.out.println(conn);
			PreparedStatement pstm = conn.prepareStatement("select *from student");
			ResultSet res = pstm.executeQuery();
			while(res.next()){
				counts = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return counts;
	}
	/*获取总页数*/
	public int getTotalPage(){  
        int totalPage=getAllpages();  
        return (totalPage%10==0)?(totalPage/10):(totalPage/10+1);  
    }  

	public boolean update(String sql) {
		
		return false;
	}

}

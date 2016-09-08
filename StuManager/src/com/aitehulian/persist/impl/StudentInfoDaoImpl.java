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
				String stu_name = res.getString("stu_name");	//获取学生姓名
				String stu_iden = res.getString("stu_iden"); //获取身份证号
				String stu_course = res.getString("stu_course");		//..培训课程
				String stu_classroom = res.getString("stu_classroom");		//..所在班级
				String stu_lecturer = res.getString("stu_lecturer");		//..培训讲师
				String stu_phone = res.getString("stu_phone");		//..手机号
				String stu_address = res.getString("stu_address");		//..住址
				
				stu.setStu_name(stu_name);
				stu.setStu_iden(stu_iden);
				stu.setStu_course(stu_course);
				stu.setStu_classroom(stu_classroom);
				stu.setStu_lecturer(stu_lecturer);
				stu.setStu_phone(stu_phone);
				stu.setStu_address(stu_address);				i++;
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
	public List getDatabypage(int pagesize,int pageindex) throws SQLException{
		List list = new ArrayList();
		String sql = "select *from student where id between ? and ?";
		try{
		conn = JdbcUtil.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, pagesize*(pageindex-1)+1);
		pstm.setInt(2, pagesize*pageindex);
		ResultSet res = pstm.executeQuery();
		int i=0;
		while(res.next()){
			Student stu = new Student();
			String stu_name = res.getString("stu_name");	//获取学生姓名
			String stu_iden = res.getString("stu_iden"); //获取身份证号
			String stu_course = res.getString("stu_course");		//..培训课程
			String stu_classroom = res.getString("stu_classroom");		//..所在班级
			String stu_lecturer = res.getString("stu_lecturer");		//..培训讲师
			String stu_phone = res.getString("stu_phone");		//..手机号
			String stu_address = res.getString("stu_address");		//..住址
			
			stu.setStu_name(stu_name);
			stu.setStu_iden(stu_iden);
			stu.setStu_course(stu_course);
			stu.setStu_classroom(stu_classroom);
			stu.setStu_lecturer(stu_lecturer);
			stu.setStu_phone(stu_phone);
			stu.setStu_address(stu_address);
			list.add(i,stu);
			i++;
		}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
		return list;
	}
	/*获取留言总数*/
	/**
	 * 获取全部学生信息
	 */
	public List getAllpages(){
		int counts = 0;
		List list = new ArrayList();
		try {
			conn=JdbcUtil.getConnection();
			System.out.println(conn);
			PreparedStatement pstm = conn.prepareStatement("select *from student");
			ResultSet res = pstm.executeQuery();
			int i=0;
			while(res.next()){
				Student stu = new Student();
				String stu_name = res.getString("stu_name");	//获取学生姓名
				String stu_iden = res.getString("stu_iden"); //获取身份证号
				String stu_course = res.getString("stu_course");		//..培训课程
				String stu_classroom = res.getString("stu_classroom");		//..所在班级
				String stu_lecturer = res.getString("stu_lecturer");		//..培训讲师
				String stu_phone = res.getString("stu_phone");		//..手机号
				String stu_address = res.getString("stu_address");		//..住址
				
				stu.setStu_name(stu_name);
				stu.setStu_iden(stu_iden);
				stu.setStu_course(stu_course);
				stu.setStu_classroom(stu_classroom);
				stu.setStu_lecturer(stu_lecturer);
				stu.setStu_phone(stu_phone);
				stu.setStu_address(stu_address);
				list.add(i,stu);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
		return list;
	}
	/**
	 * 获取总页数
	 * */
	public int getTotalPage(int pagesize){  
        int totalPage=getAllpages().size();  
        return (totalPage%pagesize==0)?(totalPage/pagesize):(totalPage/pagesize+1);  
    }  

	/**
	 * 学生信息删除操作
	 */
	public boolean deleteStuInfo(String stu_iden){
		String deleteSql = "delete from student where stu_iden=?";
		conn = JdbcUtil.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(deleteSql);
			pstm.setString(1, stu_iden);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
		return false;
	}
	public boolean update(String sql) {
		
		return false;
	}

}

package com.aitehulian.persist;

import java.util.ArrayList;

import com.aitehulian.domain.Student;

/** 
 * @Description:  
 * @author 作者：沈传新
 * @version 
 * 创建时间：2016-8-16 下午12:56:12 
 */
public interface StudentDao {

	/** 
	 * 登录
	 * @param stu_no
	 * @param password
	 * @return
	 */
	boolean login(int stu_no, String password);
	
	/**
	 * 注册
	 * @param stu
	 * @return
	 */
	boolean regist(Student stu);
	
	/**
	 * 查看个人信息
	 * @param stu_no
	 * @return
	 */
	ArrayList<Student> select(String sql);
	/*
	 * 删除
	 * */
	boolean delete(int num);
	/*
	 * 
	 * */
	boolean update(String sql);

	/**
	 * @param stuNo
	 * @return
	 */
	Student equryInfo(int stuNo);
}

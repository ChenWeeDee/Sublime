package com.aitehulian.service;

import com.aitehulian.domain.Student;

/** 
 * @Description:  TODO
 * @author 作者：沈传新
 * @version 
 * 创建时间：2016-8-16 下午12:59:41 
 */
public interface StudentService {

	boolean login(int stu_no, String password);

	boolean regist(Student stu);
	
	Student equryInfo(int stu_no);
}

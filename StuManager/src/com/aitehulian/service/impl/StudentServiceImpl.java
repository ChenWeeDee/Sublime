package com.aitehulian.service.impl;
import com.aitehulian.domain.Student;
import com.aitehulian.persist.StudentDao;
import com.aitehulian.persist.impl.StudentDaoImpl;
import com.aitehulian.service.StudentService;

/** 
 * @Description:  TODO
 * @author 作者：沈传新
 * @version 
 * 创建时间：2016-8-16 下午01:00:21 
 */
public class StudentServiceImpl implements StudentService {
	private StudentDao	sd = new StudentDaoImpl();
	public boolean login(int stu_no, String password) {
		return sd.login(stu_no, password);
	}

	public boolean regist(Student stu) {
		return sd.regist(stu);
	}

	public Student equryInfo(int stuNo) {
		return sd.equryInfo(stuNo);
	}

}

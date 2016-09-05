package com.aitehulian.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aitehulian.domain.Student;
import com.aitehulian.persist.impl.StudentInfoDaoImpl;

/**
 * @author Daizhenwei
 * @Description	查询学生信息
 * @Data 2016-9-5 下午04:45:29
 */
public class SelectStuInfoServlet extends HttpServlet {

	public SelectStuInfoServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuName = request.getParameter("stuName");
		String className = request.getParameter("className");
		String stuIdCard = request.getParameter("stuIdCard");
		String stuAdress = request.getParameter("stuAdress");
		String selectSql = "select * from student where 1=1";
		//如果获取的值为空就舍弃该字段搜索，如果不为空就加入该字段搜索，各字段关系为“与”；
		if(className!=null&&className!=""){
			selectSql = selectSql+"&&className="+className;
		}
		if(stuName!=null&&stuName!=""){
			selectSql = selectSql+"&&stuName="+stuName;
		}
		if(stuIdCard!=null&&stuIdCard!=""){
			selectSql = selectSql+"&&stuIdCard="+stuIdCard;
		}
		if(stuAdress!=null&&stuAdress!=""){
			selectSql = selectSql+"&&stuAdress="+stuAdress;
		}
		selectSql+=";";
		//获取学生表操作对象，查询数据
		StudentInfoDaoImpl stdInfoDaoImpl = new StudentInfoDaoImpl();
		ArrayList<Student> stuInfos = stdInfoDaoImpl.select(selectSql);
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}

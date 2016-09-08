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
		//对从jsp页面传递过来的值进行中文转码
		//String context = (String)request.getParameter("context");  
		//context = new String(context.getBytes("ISO-8859-1"),"GB2312"); 
		String stuName = (String)request.getParameter("stu_name");
		stuName = new String(stuName.getBytes("ISO-8859-1"),"utf-8");
		String className = request.getParameter("stu_classroom");
		className = new String(className.getBytes("ISO-8859-1"),"utf-8");
		String stuIdCard = request.getParameter("stu_iden");
		stuIdCard = new String(stuIdCard.getBytes("ISO-8859-1"),"utf-8");
		String stuAdress = request.getParameter("stu_address");
		stuAdress = new String(stuAdress.getBytes("ISO-8859-1"),"utf-8");
		String selectSql = "select * from student where 1=1";
		//如果获取的值为空就舍弃该字段搜索，如果不为空就加入该字段搜索，各字段关系为“与”；
		if(className!=null&&!className.equals("")){
			selectSql = selectSql+"&&stu_classroom like '"+className+"'";
		}
		if(stuName!=null&&!stuName.equals("")){
			selectSql = selectSql+"&&stu_name like '"+stuName+"'";
		}
		if(stuIdCard!=null&&!stuIdCard.equals("")){
			selectSql = selectSql+"&&stu_iden='"+stuIdCard+"'";
		}
		if(stuAdress!=null&&!stuAdress.equals("")){
			selectSql = selectSql+"&&stu_address='"+stuAdress+"'";
		}
		selectSql+=";";
		//获取学生表操作对象，查询数据
		StudentInfoDaoImpl stdInfoDaoImpl = new StudentInfoDaoImpl();
		ArrayList<Student> stuInfos = stdInfoDaoImpl.select(selectSql);
		request.getSession().setAttribute("listSelect", stuInfos);
		String path = response.getContentType();
		System.out.println(path);
		response.sendRedirect("/StuManager/html/stuManager/cat_manage.jsp");
		
	}
	
	public void init() throws ServletException {
		// Put your code here
	}

}

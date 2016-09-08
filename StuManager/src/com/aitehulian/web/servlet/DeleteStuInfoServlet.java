package com.aitehulian.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aitehulian.persist.impl.StudentInfoDaoImpl;

/**
 * @author Daizhenwei
 * @Description	
 * @Data 2016-9-8 下午07:37:22
 */
public class DeleteStuInfoServlet extends HttpServlet {
	public DeleteStuInfoServlet() {
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
		String stu_iden = request.getParameter("stu_iden");
		StudentInfoDaoImpl stdInfoDaoImpl = new StudentInfoDaoImpl();
		stdInfoDaoImpl.deleteStuInfo(stu_iden);
		System.out.println("删除成功");
	}
	public void init() throws ServletException {
	}

}

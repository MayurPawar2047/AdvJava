package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.utility.DBUtility;



//@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public StudentServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentDAO dao=new StudentDAO();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("uname");
		String marks=request.getParameter("marks");
		
		
		int id1=Integer.parseInt(id);
		
	double marks1=Double.parseDouble(marks);
		

		Student student=new Student(id1, name, marks1);
		
		
		// DATABASE
		try {
			Connection con=DBUtility.getDBConnection();
			int i=dao.saveStudent(student);
		     	 
			if(i>0) {
				out.print("<b> RECORD INSERTED SUCCESS !!!!<b>");
			}
		
			}catch (Exception e) {
				System.out.println(e);
			}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ReadServlet");
		rd.forward(request, response);
		//rd.include(request, response);
	
	}
}



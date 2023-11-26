package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;





//@WebServlet("/EditForm")
public class EditForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
StudentDAO dao;
    
    @Override
    public void init() throws ServletException {
   
      dao=new StudentDAO();
    }

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		int id=Integer.parseInt(request.getParameter("did"));
		
		Student student=null;
		try {
			 student=dao.getStudentById(id);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
		
		out.print("<h2> STUDENT UPDATE FORM <h2> <br>");
		out.print("<form action='StudentUpdate' method='get'>");
		
		out.print("<input type='text' name='eid' value='"+student.getId()+"' readonly >");
		out.print("<br>");
		out.print("<input type='text' name='uname' value='"+student.getName()+"'>");
		out.print("<br>");
		out.print("<input type='text' name='marks' value='"+student.getMarks()+"'>");
		out.print("<br>");
		
		out.print("<input type='submit' value='UPDATE'>");
		
		out.print("</form>");
		
		
		

		
		
		
		
		
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.utility.DBUtility;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private StudentDAO dao;
	
    @Override
    public void init() throws ServletException {
    	dao = new StudentDAO();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao = new StudentDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// DATABASE
		try {
			Connection con = DBUtility.getDBConnection();

			List<Student> list = dao.getAllStudents();

			Iterator<Student> itr = list.iterator();

			out.print("<table>");
			out.print("<tr>");
			out.print("<th>ID </th>");
			out.print("<th>Name </th>");
			out.print("<th>Marks </th>");
			out.print("</tr>");

			while (itr.hasNext()) {
				Student stud = itr.next();
				out.print("<tr>");
				out.print("<td>" + stud.getId() + "</td>");
				out.print("<td>" + stud.getName() + "</td>");
				out.print("<td>" + stud.getMarks() + "</td>");
				out.print("<td>");
				out.print("<a href='StudentDeleteServlet?did="+stud.getId()+"'>"+"DELETE"+"</a>");
				
				out.print("</td>");
				
				out.print("<td>");
				out.print("<a href='EditForm?did="+stud.getId()+"'>"+"UPDATE"+"</a>");
				
				out.print("</td>");
				
				out.print("</tr>");

			}

			out.print("<table>");

		} catch (Exception e) {
			System.out.println(e);
		}


		
	}

}

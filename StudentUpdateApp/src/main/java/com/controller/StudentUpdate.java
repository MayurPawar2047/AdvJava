package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.model.Student;
import com.utility.DBUtility;

//@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new StudentDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("eid");
		String name = request.getParameter("uname");
		String marks = request.getParameter("marks");

		int id1 = Integer.parseInt(id);
		double marks1 = Double.parseDouble(marks);

		Student student = new Student(id1, name, marks1);

		// DATABASE
		try {
			Connection con = DBUtility.getDBConnection();
			int i = dao.updateStudent(student);

			if (i > 0) {
				out.print("<b> RECORD Update SUCCESS !!!!<b>");
				
				RequestDispatcher rd = request.getRequestDispatcher("/ReadServlet");
				rd.include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

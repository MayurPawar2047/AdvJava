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
import com.utility.DBUtility;



//@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentDeleteServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("did");

		int id1 = Integer.parseInt(id);
		// DATABASE
		try {
			Connection con = DBUtility.getDBConnection();
			int i = dao.deleteStudentByID(id1);

			if (i > 0) {
				out.print("<b> RECORD DELETED SUCCESS !!!!<b>");
				RequestDispatcher rd = request.getRequestDispatcher("/ReadServlet");
				rd.include(request, response);

			}

		} catch (Exception e) {
			System.out.println(e);
		}


	}

}

package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/OnServletLogin")
public class OnServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String user=req.getParameter("userName");
		String pass=req.getParameter("userPassword");

		
		if(user.equals("KalpeshSirJava")&&pass.equals("KalpeshSirJava")) 
			 pw.println("<h1>Login Success...! Welcome to the World of Java Programming</h1>"); 
		
		
			//pw.println("Welcome to the World of Java Development"); 
               
		 else
                 pw.println("Login Failed...!");
		 pw.close();

	}


}

package com.login;

import java.io.IOException;

import com.dao.LoginDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		System.out.println("Username: "+uname);
		
		LoginDAO dao=new LoginDAO();
		
		if(dao.check(uname, upass)) {
			System.out.println("Correct password");
			HttpSession session=request.getSession();
			session.setAttribute("user", uname);
			
			response.sendRedirect("welcome.jsp");
		}else {
			System.out.println("Wrong password");
			response.sendRedirect("login.jsp");
		}
	}

}

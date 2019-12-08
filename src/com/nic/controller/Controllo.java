package com.nic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.architecture.dao.DAOException;
import com.nic.businesscomponent.beans.LoginUtilities;
import com.nic.businesscomponent.security.GeneraMD5;

@WebServlet("/controllo")
public class Controllo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = GeneraMD5.convertiMD5(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		String userpass, adminpass;
		if(username != null && password != null){
			try {
				LoginUtilities u = new LoginUtilities();
				userpass = u.getUserPass(username);
				adminpass = u.getAdminPass(username);
				if(userpass != null) {
					if(userpass.equals(password)) {
						session.setAttribute("username", username);
						response.sendRedirect("corsi.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else if(adminpass != null) {
					if(adminpass.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("admin/");
					}else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch(ClassNotFoundException | DAOException exc) {
				exc.printStackTrace();			
			}
		}	
	}
}

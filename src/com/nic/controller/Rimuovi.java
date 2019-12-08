package com.nic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.businesscomponent.beans.Carrello;

@WebServlet("/rimuovi")
public class Rimuovi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		String nome = request.getParameter("nome");
		
		if(nome != null) {
			carrello.rimuoviArticoli(nome);
		}
		response.sendRedirect("visualizza.jsp");
	}
}

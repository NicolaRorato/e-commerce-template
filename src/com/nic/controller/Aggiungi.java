package com.nic.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.businesscomponent.beans.Carrello;

@WebServlet("/aggiungi")
public class Aggiungi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello)session.getAttribute("carrello");
		String nome = request.getParameter("nome");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if(nome != null) {
			try {
				System.out.println("Entrato in aggiungi!");
				System.out.println(request.getParameter("inizio"));
				
				Date inizio = formatter.parse(request.getParameter("inizio"));
				Date fine = formatter.parse(request.getParameter("fine"));
				double prezzo = Double.parseDouble(request.getParameter("prezzo"));
				carrello.aggiungiCorso(nome, inizio, fine, prezzo);		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("visualizza.jsp");
	}
}

package com.nic.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.architecture.dao.DAOException;
import com.nic.businesscomponent.RegistrazioneBC;
import com.nic.businesscomponent.beans.Carrello;
import com.nic.businesscomponent.beans.Registrazione;

@WebServlet("/conferma")
public class Conferma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello) session.getAttribute("carrello");

//		Corso ord = new Corso();
//		ord.setTotale(carrello.totaleComplessivo());
//		ord.setUsername((String) session.getAttribute("username"));
		try {
//			CorsoBC.getFactory().create(ord);
			Enumeration<String[]> prodotti = carrello.datiCarrello();
			Registrazione reg = null;
			while (prodotti.hasMoreElements()) {
				reg = new Registrazione();
				String[] p = prodotti.nextElement();
				reg.setId(reg.getId());
				reg.setCorso(p[0]);
				reg.setCuoco((String) session.getAttribute("username"));
				RegistrazioneBC.getFactory().create(reg);
			}
			session.setAttribute("idordine", reg.getId());
			response.sendRedirect("ordine.jsp");
		} catch (ClassNotFoundException | DAOException exc) {
			exc.printStackTrace();
		}
	}
}

package com.nic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.architecture.dao.DAOException;
import com.nic.businesscomponent.RegistrazioneBC;
import com.nic.businesscomponent.beans.Registrazione;

@WebServlet("/rimuoviregistrazione")
public class RimuoviRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Registrazione registrazione = (Registrazione) session.getAttribute("report");
		String id = request.getParameter("id_registrazione");

		try {
			if(id != null) {
				RegistrazioneBC.getFactory().delete(id);
			}
			response.sendRedirect("eliminazioneregistrazione.jsp");
		} catch (ClassNotFoundException | DAOException exc) {
			exc.printStackTrace();
		}
	}
}

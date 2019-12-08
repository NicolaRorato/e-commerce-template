package com.nic.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nic.architecture.dao.DAOException;
import com.nic.businesscomponent.QuestionarioBC;
import com.nic.businesscomponent.beans.Questionario;

@WebServlet("/recensisci")
public class Recensisci extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Questionario reviews = (Questionario) session.getAttribute("report");
		String corso = request.getParameter("nome");
		
		Long id = Long.parseLong(request.getParameter("id"));
		String stelle = request.getParameter("stelle");
		String cuoco = request.getParameter("cuoco");
		
		Questionario quest = new Questionario();

		quest.setId(id);
		quest.setCorso(corso);
		quest.setStelle(Integer.parseInt(stelle));
		quest.setCuoco(cuoco);
		
		try {
			QuestionarioBC.getFactory().create(quest);
		} catch (ClassNotFoundException | DAOException e) {
			e.printStackTrace();
		}

		response.sendRedirect("corsi.jsp");
	}
}

package com.nic.businesscomponent;

import java.sql.Connection;

import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;
import com.nic.architecture.dao.QuestionarioDAO;
import com.nic.businesscomponent.beans.Questionario;

public class QuestionarioBC {
	private Connection conn;
	public static QuestionarioBC getFactory() throws ClassNotFoundException, DAOException {
		return new QuestionarioBC();
	}

	private QuestionarioBC() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}
	

	public void create(Questionario quest) throws DAOException, ClassNotFoundException {
		QuestionarioDAO.getFactory().create(conn, quest);
	}
}

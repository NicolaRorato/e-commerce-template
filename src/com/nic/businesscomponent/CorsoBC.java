package com.nic.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;

import com.nic.architecture.dao.CorsoDAO;
import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;
import com.nic.businesscomponent.beans.Corso;


public class CorsoBC {
	private Connection conn;
	
	public static CorsoBC getFactory() throws SQLException, ClassNotFoundException, DAOException {
		return new CorsoBC();
	}

	private CorsoBC()  throws SQLException, ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();	}

	public void create(Corso a) throws DAOException, ClassNotFoundException {
		try {
			CorsoDAO.getFactory().create(conn, a);
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}

	public Corso[] getCorsi() throws DAOException {
		try {
			return CorsoDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			new DAOException(sql);
		}
		return null;
	}
	
	public void delete(String nome) throws DAOException {
		try {
			CorsoDAO.getFactory().deleteCorso(conn, nome);
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}
}

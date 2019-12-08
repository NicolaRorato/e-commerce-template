package com.nic.businesscomponent;

import java.sql.Connection;
import java.sql.SQLException;

import com.nic.architecture.dao.CuocoDAO;
import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;
import com.nic.businesscomponent.beans.Cuoco;

public class CuocoBC {
	public static CuocoBC getFactory() throws ClassNotFoundException, DAOException {
		return new CuocoBC();
	}

	private Connection conn;

	private CuocoBC() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}

	public void create(Cuoco c) throws DAOException {
		try {
			CuocoDAO.getFactory().create(conn, c);
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}
}

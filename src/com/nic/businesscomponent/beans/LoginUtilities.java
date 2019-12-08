package com.nic.businesscomponent.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nic.architecture.dao.DAOConstants;
import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;

public class LoginUtilities implements DAOConstants {
	private Connection conn;

	public LoginUtilities() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}

	public String getUserPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_USERPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // se viene trovato un utente
				return rs.getString(1);
			}
		} catch (SQLException sql) {
			new DAOException(sql);
		}
		return null;
	}

	public String getAdminPass(String username) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // se viene trovato un utente
				return rs.getString(1);
			}
		} catch (SQLException sql) {
			new DAOException(sql);
		}
		return null;
	}
}

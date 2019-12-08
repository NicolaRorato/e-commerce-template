package com.nic.businesscomponent.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import com.nic.architecture.dao.DAOConstants;
import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;

public class ReportUtilities implements DAOConstants {
	private Connection conn;

	public ReportUtilities() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}

	public Vector<String[]> getReport(String user) {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_REPORT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			int colonne = meta.getColumnCount();
			Vector<String[]> dati = new Vector<String[]>();
			rs.beforeFirst();
			while (rs.next()) {
				String[] riga = new String[colonne];
				for (int i = 0; i < colonne; i++) {
					riga[i] = rs.getString(i + 1);
				}
				dati.add(riga);
			}
			return dati;
		} catch (SQLException sql) {
			new DAOException(sql);
		}
		return null;
	}

}

package com.nic.businesscomponent.idgenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nic.architecture.dao.DAOConstants;
import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;

public class RegistrazioneIdGenerator implements IdGeneratorInterface, DAOConstants {
	private static RegistrazioneIdGenerator idGen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private RegistrazioneIdGenerator() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}

	public static RegistrazioneIdGenerator getInstance() throws ClassNotFoundException, DAOException {
		if (idGen == null)
			idGen = new RegistrazioneIdGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_REGISTRAZIONE_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			new DAOException(sql);
		}
		return id;
	}
}

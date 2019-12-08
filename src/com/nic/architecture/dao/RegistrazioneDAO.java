package com.nic.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nic.businesscomponent.beans.Registrazione;

public class RegistrazioneDAO implements GenericDAO<Registrazione>, DAOConstants {
	
	public static RegistrazioneDAO getFactory() {
		return new RegistrazioneDAO();
	}

	private RegistrazioneDAO() {
	}

	@Override
	public void create(Connection conn, Registrazione entity) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_REGISTRAZIONE);
			ps.setLong(1, entity.getId());
			ps.setString(2, entity.getCorso());
			ps.setString(3, entity.getCuoco());
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Registrazione entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Registrazione getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Registrazione[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void deleteRegistrazione(Connection conn, String id) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_REPORT);
			ps.setString(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}


}

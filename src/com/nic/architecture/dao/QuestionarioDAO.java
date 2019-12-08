package com.nic.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.nic.businesscomponent.beans.Questionario;

public class QuestionarioDAO implements GenericDAO<Questionario>, DAOConstants {
	
	public static QuestionarioDAO getFactory() {
		return new QuestionarioDAO();
	}

	private QuestionarioDAO() {
	}

	@Override
	public void create(Connection conn, Questionario entity) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_QUESTIONARIO);
			ps.setLong(1, entity.getId());
			ps.setString(2, entity.getCorso());
			ps.setLong(3, entity.getStelle());
			ps.setString(4, entity.getCuoco());
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Questionario entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Questionario getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questionario[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}

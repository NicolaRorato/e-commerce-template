package com.nic.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.nic.businesscomponent.beans.Cuoco;
import com.nic.businesscomponent.security.GeneraMD5;

public class CuocoDAO implements GenericDAO<Cuoco>, DAOConstants{
	private CachedRowSet rowSet;

	public static CuocoDAO getFactory() throws SQLException {
		return new CuocoDAO();
	}

	public CuocoDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Cuoco entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CUOCO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getUsername());
			rowSet.updateString(2, entity.getNome());
			rowSet.updateString(3, GeneraMD5.convertiMD5(entity.getPassword()));
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Cuoco entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cuoco getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuoco[] getAll(Connection conn) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
}
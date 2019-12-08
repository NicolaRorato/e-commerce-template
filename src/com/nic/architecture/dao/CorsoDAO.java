package com.nic.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.nic.businesscomponent.beans.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {
	private CachedRowSet rowSet;

	public static CorsoDAO getFactory() throws SQLException {
		return new CorsoDAO();
	}

	public CorsoDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Connection conn, Corso entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSO);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getNome());
			rowSet.updateString(2, entity.getDocente());
			rowSet.updateString(3, entity.getAula());
			rowSet.updateDate(4, new java.sql.Date(entity.getInizio().getTime()));
			rowSet.updateDate(5, new java.sql.Date(entity.getFine().getTime()));
			rowSet.updateDouble(6, entity.getPrezzo());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corso entity) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_CORSO);
			ps.setString(1, entity.getNome());
			ps.setString(2, entity.getDocente());
			ps.setString(3, entity.getAula());
			ps.setDate(4, new java.sql.Date(entity.getInizio().getTime()));
			ps.setDate(5, new java.sql.Date(entity.getFine().getTime()));
			ps.setDouble(6, entity.getPrezzo());
		} catch (SQLException sql) {
			new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, long id) throws DAOException {
	}
	
	public void deleteCorso(Connection conn, String nome) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setString(1, nome);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corso[] getAll(Connection conn) throws DAOException {
		Corso[] corso = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSO);
			rs.last();
			corso = new Corso[rs.getRow()];
			rs.beforeFirst();
			for (int i = 0; rs.next(); i++) {
				Corso a = new Corso();
				a.setNome(rs.getString(1));
				a.setDocente(rs.getString(2));
				a.setAula(rs.getString(3));
				a.setInizio(new java.util.Date(rs.getDate(4).getTime()));
				a.setFine(new java.util.Date(rs.getDate(5).getTime()));
				a.setPrezzo(rs.getDouble(6));
				corso[i] = a;
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corso;
	}

	@Override
	public Corso getById(Connection conn, long id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}

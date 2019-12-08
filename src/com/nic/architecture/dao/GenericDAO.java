package com.nic.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<E> {
	void create(Connection conn, E entity) throws DAOException;
	void update(Connection conn, E entity) throws DAOException;
	void delete(Connection conn, long id) throws DAOException;
	E getById(Connection conn, long id) throws DAOException;
	E [] getAll(Connection conn) throws DAOException;
}

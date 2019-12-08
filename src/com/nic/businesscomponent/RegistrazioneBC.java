package com.nic.businesscomponent;

import java.sql.Connection;

import com.nic.architecture.dao.DAOException;
import com.nic.architecture.dao.DBAccess;
import com.nic.architecture.dao.RegistrazioneDAO;
import com.nic.businesscomponent.beans.Registrazione;
import com.nic.businesscomponent.idgenerator.RegistrazioneIdGenerator;

public class RegistrazioneBC {
	private Connection conn;
	public static RegistrazioneBC getFactory() throws ClassNotFoundException, DAOException {
		return new RegistrazioneBC();
	}

	private RegistrazioneBC() throws ClassNotFoundException, DAOException {
		conn = DBAccess.getConnection();
	}
	

	public void create(Registrazione reg) throws DAOException, ClassNotFoundException {
		RegistrazioneIdGenerator idGen = RegistrazioneIdGenerator.getInstance();
		reg.setId(idGen.getNextId());
		RegistrazioneDAO.getFactory().create(conn, reg);
	}

	public void delete(String id) throws DAOException {
		RegistrazioneDAO.getFactory().deleteRegistrazione(conn, id);
	}

}

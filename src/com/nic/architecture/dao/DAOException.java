package com.nic.architecture.dao;

import java.sql.SQLException;

public class DAOException extends Exception {
	private static final long serialVersionUID = -2441886272131299022L;

	private final static int ORA1017 = 1017;
	private final static int ORA17002 = 17002; // eccezione per impossibilità di connessione al db
	private final static int ORA0001 = 0; // eccezione relativa alla chiave duplicata

	private String messaggio;

	public String getMessaggio() {
		return messaggio;
	}
	
	public DAOException(SQLException sql) {
		String chiave = "";
		if(sql != null) {
			switch(sql.getErrorCode()) {
			case ORA1017:
				chiave = "Username/password errata";
				log(sql);
				break;
			case ORA17002:
				chiave = "I/O Exception di Oracle DB";
				log(sql);
				break;
			case ORA0001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
				break;
			}
		}
		messaggio = chiave;
	}

	private void log(SQLException sql) {
		sql.printStackTrace(System.err);
		System.err.println("Motivo: " +sql.getMessage());
		System.err.println("Stato: " +sql.getSQLState());
		System.err.println("Codice errore: " +sql.getErrorCode());
		System.err.println("Causa del problema: " +sql.getCause());
	}
}

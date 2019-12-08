package com.nic.architecture.dao;

public interface DAOConstants {

	String JBDC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	String JDBC_URL = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	String USERNAME = "nicola";
	String PASSWORD = "pass";

	String SELECT_CUOCO = "Select * from cuoco";
	String SELECT_ORDINE = "Select * from ordine";
	String SELECT_CORSO = "Select * from corso";
	String SELECT_ORDINEARTICOLO = "Select * from ordine_articolo";
	String SELECT_IMMAGINI = "Select * from immagini";

	String SELECT_USERPASS = "Select password from cuoco where user_cuoco = ?";
	String SELECT_ADMINPASS = "Select password from administrator where username = ?";

	String SELECT_REGISTRAZIONE_SEQ = "Select registrazione_seq.nextval from dual";
	String SELECT_ARTICOLO_SEQ = "Select articolo_seq.nextval from dual";

	String UPDATE_CORSO = "Update articolo set marca = ?, modello = ?, prezzo = ? where id_articolo = ?";
	
	String DELETE_ORDINE = "Delete from ordine where id_ordine = ?";
	String DELETE_ORDINEARTICOLO = "Delete from ordine_articolo where id_ordine = ?";
	String DELETE_CORSO = "Delete from articolo where id_articolo = ?";
	
	String INSERT_REGISTRAZIONE = "insert into registrazione values(?,?,?)";
	String INSERT_QUESTIONARIO = "insert into questionario values(?,?,?)";
	
	String SELECT_ARTICOLO_BY_ID = "Select * from articolo where id_articolo = ?";
	
	String SELECT_REPORT = "select id_registrazione, registrazione.nome_corso, docente, nome_aula, data_inizio, dat_fine, prezzo from corso, registrazione where user_cuoco = ? and registrazione.nome_corso = corso.nome_corso order by id_registrazione";
	String DELETE_REPORT = "Delete from registrazione where id_registrazione = ?";
	

}

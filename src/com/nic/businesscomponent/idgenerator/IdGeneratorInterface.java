package com.nic.businesscomponent.idgenerator;

import com.nic.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException, DAOException; //public abstract sottinteso essendo un'interfaccia
}

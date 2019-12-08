package com.nic.businesscomponent.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class Carrello {
	private Hashtable<String,String[]> prodotti =
			new Hashtable<String,String[]>();
	private int corsi;
	
	public Carrello() {
		corsi = 0;
	}
	
	public int totaleCorsi() {
		return corsi;
	}
	
	public void aggiungiCorso(String nome, Date inizio, Date fine, double prezzo) {
		corsi++;
		System.out.println(corsi + "nella classe");
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String strInizio = dateFormat.format(inizio);
		String strFine = dateFormat.format(fine);
		String strPrezzo = Double.toString(prezzo);
		String[]record = {nome, strInizio, strFine, strPrezzo};
		
		prodotti.put(nome, record);
	}
			
	public void rimuoviArticoli(String nome) {
		if(prodotti.containsKey(nome)) {
			corsi--;
			prodotti.remove(nome);
		}
	}
	
	public double totaleParziale(String nome) {
		double totale = 0.00;
		String[] dati = prodotti.get(nome); 
		totale += Double.parseDouble(dati[3]);
		return totale;
	}
	
	public double totaleComplessivo() {
		double totale = 0.00;
		Enumeration<String[]> enumerazione = datiCarrello();
		String[]dati;
		while(enumerazione.hasMoreElements()) {
			dati = enumerazione.nextElement();
			totale += Double.parseDouble(dati[3]);
		}
		return totale;	
	}
	public Enumeration<String[]>datiCarrello() {
		return prodotti.elements();
	}
}

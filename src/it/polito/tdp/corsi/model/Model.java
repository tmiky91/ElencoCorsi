package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	
	private List<Corso> corsi ;
	private CorsoDAO corsoDAO=null;
	private StudenteDAO studenteDAO=null;
	
	public Model() {
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
	}
	
	public String getNomeCognomeFromMatricola( int matricola) {
		Studente s = studenteDAO.getStudenteByMatricola(matricola);
		
		if(s!=null) {
			String result = "Matricola non esistente";
			return result;
		}
		return s.getNome()+ " "+ s.getCognome();
		
	}
	
	public List<Corso> listaCorsiSemestre(int pd) {
		
		//CorsoDAO dao = new CorsoDAO() ;
		
		// opzione 1: leggo tutto e filtro io
		/*
		this.corsi = dao.listAll() ;
		
		List<Corso> risultato = new ArrayList<>() ;
		for(Corso c: this.corsi) {
			if(c.getPd() == pd) {
				risultato.add(c) ;
			}
		}
		return risultato ;
		*/
		
//		// opzione 2: faccio lavorare il database
		List<Corso> risultato2 = corsoDAO.listByPD(pd) ;
		return risultato2;
		
	}

}

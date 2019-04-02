package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Studente;

public class StudenteDAO {
	
	private Studente studente=null;
	
	public Studente getStudenteByMatricola(int matricola) {
		
		String sql = "SELECT matricola, nome, cognome, gds FROM studente where matricola=?" ;
		
		List<Corso> result = new ArrayList<>() ;
		
		try {
			Connection conn = DriverManager.getConnection(sql) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			st.setInt(1, matricola);
			
			
			ResultSet res = st.executeQuery() ;
			
			if(res.next()) {
				studente = new Studente();
				studente.setMatricola(matricola);
				studente.setNome("nome");
				studente.setCognome("cognome");
				studente.setGds("gds");
			
			conn.close();
			}	
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		return studente;
	
	
	}}

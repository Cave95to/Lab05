package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.AnagrammaDAO;

public class Model {
	
	private AnagrammaDAO anagrammaDao;
	
	public Model() {
		this.anagrammaDao = new AnagrammaDAO();
	}

	public Set<String> getParole() {
		return this.anagrammaDao.getTutteParole();
	}
	
	public boolean isCorrect(String s) {
		return this.anagrammaDao.isCorrect(s);
	}

	public Set<String> calcolaAnagrammi(String parola) {

		Set<String> anagrammi = new HashSet<>();
		
		this.permuta("", parola, 0, anagrammi);
		
		return anagrammi;
	}

	private void permuta(String parziale, String lettere, int livello, Set<String> anagrammi) {
		
		if(lettere.length() == 0) {
			anagrammi.add(parziale);
			return;
		}
		
		for(int i=0; i<lettere.length(); i++) {
			
			char lettera = lettere.charAt(i);
			
			String nuovoParziale = parziale + lettera;
			String nuovoLettere= lettere.substring(0, i) + lettere.substring(i+1);
			
			permuta(nuovoParziale, nuovoLettere, livello+1, anagrammi);
			
		}
	}
}

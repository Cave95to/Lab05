package it.polito.tdp.anagrammi.model;

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

}

package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AnagrammaDAO {
	
	public Set<String> getTutteParole() {

		String sql = "SELECT * FROM parola";

		Set<String> parole = new HashSet<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String parola = rs.getString("nome");
				//System.out.println(parola);
				parole.add(parola);
			}

			conn.close();
			
			return parole;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db in getTutteParole", e);
		}
	}
	
	public boolean isCorrect(String anagramma) {
		
		String sql = "SELECT * "
				+ "FROM parola "
				+ "WHERE nome = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			if (rs.first()) {
				conn.close();
				return true;
			}

			conn.close();
			
			return false;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db in isCorrect", e);
		}
	}

}

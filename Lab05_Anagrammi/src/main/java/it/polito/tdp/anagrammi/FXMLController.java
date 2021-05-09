package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
	public void setModel(Model model) {
	    this.model = model;
	    this.txtCorretti.setStyle("-fx-font-family: monospace");
	    this.txtErrati.setStyle("-fx-font-family: monospace");
	   // this.dizionario = model.getParole();
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInserimento;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;
    
    //private Set<String> dizionario ;

    @FXML
    void doCalcola(ActionEvent event) {
    	
    	String inserimento = this.txtInserimento.getText().toLowerCase();
    	
    	StringTokenizer st = new StringTokenizer(inserimento, " ");
    	
    	if (!st.hasMoreElements()) {
    		this.txtCorretti.setText("Inserire una parola.");
    		return;
    	}
    	
    	String parola = st.nextToken();
    	
    	if (!parola.matches("[a-zA-Z]*")) {
			this.txtCorretti.setText("ERRORE: gli unici caratteri ammessi sono a-z, A-Z");
			return;
		}
    	
    	if (st.hasMoreTokens()) {
    		this.txtCorretti.setText("Inserire solamente una parola.");
    		return;
    	}
    	
    	// cercare anagrammi e vedere se sono corretti

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	this.txtInserimento.clear();

    }

    @FXML
    void initialize() {
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

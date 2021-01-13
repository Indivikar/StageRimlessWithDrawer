package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Start;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class CRegistraturplan implements Initializable {

	private Start start;
	private Stage primaryStage;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}

	public void set(Start start, Stage primaryStage) {
		this.start = start;	
		this.primaryStage = primaryStage;	
	}

}

package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;

import app.Start;
import app.view.function.IWindowMax;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CContent implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;
	private JFXDrawersStack drawersStack;
	private JFXDrawer drawer;
	
	
	@FXML private AnchorPane shadowPane;
	@FXML private AnchorPane mainAnchorPane;
	
	@FXML Button buttonWindowMin;
	@FXML Button buttonWindowMax;
	@FXML Button buttonWindowClose;
	
	@FXML Button button;
	
//	@FXML JFXDrawersStack drawersStack;
//	@FXML JFXDrawer drawer;
	
//	@FXML Button buttonDrawer;
	
	@FXML public void actionButtonWindowMin(){
		System.out.println("Window min");
		primaryStage.setIconified(true);
	}
	@FXML public void actionButtonWindowMax(){

		setWindowMaxIcon(primaryStage, buttonWindowMax, shadowPane, mainAnchorPane);
	}
	@FXML public void actionButtonWindowClose(){
		primaryStage.close();
		Platform.exit();
		System.exit(0);
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	// Getter
	public Button getButtonWindowMax() {return buttonWindowMax;}
	
	// Setter
	public void set(Start start, Stage primaryStage) {
		this.start = start;
		this.primaryStage = primaryStage;		
		this.drawersStack = start.getControllerDrawersStack().getDrawersStack();
		this.drawer = start.getDrawer();

		Platform.runLater(()->{
			button.setOnAction(e -> {
				drawersStack.toggle(drawer);				
			});
		});
		
	}

}

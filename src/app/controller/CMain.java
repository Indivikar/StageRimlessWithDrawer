package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import app.Start;
import app.view.function.IWindowMax;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CMain implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;
	
	private JFXDrawer drawerMenu;
	
	@FXML private AnchorPane mainAnchorPane;
	@FXML private JFXDrawersStack drawersStack;
	@FXML private JFXDrawersStack drawersStackMenu;
	@FXML private JFXHamburger hamburgerMenu;
	@FXML private Button buttonWindowMin;
	@FXML private Button buttonWindowMax;
	@FXML private Button buttonWindowClose;
	

	@FXML public void actionButtonWindowMin(){
		primaryStage.setIconified(true);
	}
	
	@FXML public void actionButtonWindowMax(){
		setWindowMaxIcon(primaryStage, buttonWindowMax, mainAnchorPane, Start.hasShadowPane);
	}
	
	@FXML public void actionButtonWindowClose(){
		primaryStage.close();
		Platform.exit();
		System.exit(0);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		
	}
	
	private void initDrawerMainMenu() {
		
		HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburgerMenu);
			
		hamburgerMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{

//			drawersStack.toggle(drawerMenu);
			
			transition.setOnFinished(ev -> {				
				if (transition.getRate() == -1.0) {
					drawersStackMenu.setVisible(false);	
				}									
			});
			
			if (drawerMenu.isOpened()) {
				drawersStackMenu.toggle(drawerMenu);
				transition.setRate(-1.0);				
			} else {
				drawersStackMenu.setVisible(true);
				drawersStackMenu.toggle(drawerMenu);
				transition.setRate(1.0);
			}
			
			transition.play();
			
		});

		
		
	}
	
	// Getter
	public JFXDrawersStack getDrawersStack() {return drawersStack;}
	public Button getButtonWindowMax() {return buttonWindowMax;}

	// Setter
	public void set(Start startTest, Stage primaryStage) {
		this.start = startTest;
		this.primaryStage = primaryStage;
		this.drawerMenu = start.getDrawerMenu();
		initDrawerMainMenu();
	}
	

}

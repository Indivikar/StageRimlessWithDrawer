package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import app.Start;
import app.handler.PageHandler.Page;
import app.nodes.ButtonMenuIcon;
import app.nodes.ButtonMenuText;
import app.view.function.IWindowMax;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CMain implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;
	
	private JFXDrawer drawerMenu;
	private HamburgerBackArrowBasicTransition transition;
	
	private CMainMenu controllerDrawerMenuContent;
	
	@FXML private AnchorPane mainAnchorPane;
	
	@FXML private Label labelTitle;
	
	@FXML private JFXDrawersStack drawersStack;
	@FXML private JFXDrawersStack drawersStackMenu;
	@FXML private JFXHamburger hamburgerMenu;
	@FXML private VBox vBoxMenuIcons;
	
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

	// Getter
	public JFXDrawersStack getDrawersStack() {return drawersStack;}
	public JFXDrawersStack getDrawersStackMenu() {return drawersStackMenu;}
	public Button getButtonWindowMax() {return buttonWindowMax;}
	public VBox getVBoxMenuIcons() {return vBoxMenuIcons;}
	public Label getLabelTitle() {return labelTitle;}
	public JFXHamburger getHamburgerMenu() {return hamburgerMenu;}

	// Setter
	public void set(Start startTest, Stage primaryStage) {
		this.start = startTest;
		this.primaryStage = primaryStage;
		this.drawerMenu = start.getDrawerMenu();
		this.controllerDrawerMenuContent = start.getControllerDrawerMenuContent();
	}
	

}

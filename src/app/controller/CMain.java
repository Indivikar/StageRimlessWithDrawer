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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CMain implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;
	
	private JFXDrawer drawerMenu;
	private CMainMenu controllerDrawerMenuContent;
	
	@FXML private AnchorPane mainAnchorPane;
	
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
	
	private Image IMG = new Image(Start.class.getResourceAsStream("view/images/mainMenu/aerialway-15.png")); 
	
	
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
	
	private void addMenuContent() {
		menuContent(IMG, "Home");
		menuContent(IMG, "Registraturplan");
		menuContent(IMG, "MultiTop");
		menuContent(IMG, "ProtoTop");
	}
	
	
	private void menuContent(Image image, String Text) {
		
		Button buttonText = new Button(Text);
		
		ImageView iv = new ImageView(image);
		Button buttonIcon = new Button();
		buttonIcon.setGraphic(iv);
				
		vBoxMenuIcons.getChildren().add(buttonIcon);
		controllerDrawerMenuContent.getVBoxMainMenuText().getChildren().add(buttonText);
	}
	
	
	// Getter
	public JFXDrawersStack getDrawersStack() {return drawersStack;}
	public Button getButtonWindowMax() {return buttonWindowMax;}
	public VBox getVBoxMenuIcons() {return vBoxMenuIcons;}

	// Setter
	public void set(Start startTest, Stage primaryStage) {
		this.start = startTest;
		this.primaryStage = primaryStage;
		this.drawerMenu = start.getDrawerMenu();
		this.controllerDrawerMenuContent = start.getControllerDrawerMenuContent();
		initDrawerMainMenu();
		
		addMenuContent();
	}
	

}

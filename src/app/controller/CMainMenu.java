package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.NotificationPane;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import app.Start;
import app.handler.PageHandler.Page;
import app.nodes.ButtonMenuIcon;
import app.nodes.ButtonMenuText;
import app.view.function.IWindowMax;
import app.view.function.MyNotification;
import app.view.function.MyNotification.MyNotificationGraphic;
import app.view.function.MyNotificationPane;
import app.view.function.MyNotificationPane.MyNotificationPaneGraphic;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CMainMenu implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;

	@FXML private VBox vBoxMainMenuText;
	private JFXDrawer drawerMenu;
	private CMainMenu controllerDrawerMenuContent;
	private HamburgerBackArrowBasicTransition transition;
	private JFXDrawersStack drawersStackMenu;
	private JFXHamburger hamburgerMenu;
	private VBox vBoxMenuIcons;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	private void initDrawerMainMenu() {		
		this.transition = new HamburgerBackArrowBasicTransition(hamburgerMenu);
			
		hamburgerMenu.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
			transition.setOnFinished(ev -> {				
				if (transition.getRate() == -1.0) {
					drawersStackMenu.setVisible(false);	
				}									
			});
			
			toggleMenu();
		});
	}

	private void addMenuContent() {
		String iconColor = "#ebebeb";
		int iconSize = 40;
		
		menuContent("mdi-home-outline", iconColor, iconSize, "Home", Page.Home);
		menuContent("mdi-compass-outline", iconColor, iconSize, "Registraturplan", Page.RP);
		menuContent("mdi-file-tree", iconColor, iconSize, "MultiTop", Page.MT);
		menuContent("dashicons-media-document", iconColor, iconSize, "ProtoTop", Page.PT);
	}
	
	
	private void menuContent(String iconID, String color, int size, String text, Page page) {

		Button buttonIcon = new ButtonMenuIcon(iconID, color, size, text, page);
		Button buttonText = new ButtonMenuText(text, page);

		buttonIcon.setOnAction(e -> {
			start.getPageHandler().setPage(page);
			closeMenu();
		});		
		buttonText.setOnAction(e -> {
			start.getPageHandler().setPage(page);
			closeMenu();		
		});
		
		buttonIcon.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonHover(true);
			((ButtonMenuText) buttonText).setButtonHover(true);
		});		
		buttonIcon.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonHover(false);
			((ButtonMenuText) buttonText).setButtonHover(false);
		});		
		buttonText.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {			
			((ButtonMenuIcon) buttonIcon).setButtonHover(true);
			((ButtonMenuText) buttonText).setButtonHover(true);
		});		
		buttonText.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonHover(false);
			((ButtonMenuText) buttonText).setButtonHover(false);
		});
		
		
		buttonIcon.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonPressed(true);
			((ButtonMenuText) buttonText).setButtonPressed(true);

		});		
		buttonIcon.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonPressed(false);
			((ButtonMenuText) buttonText).setButtonPressed(false);
		});		
		buttonText.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {			
			((ButtonMenuIcon) buttonIcon).setButtonPressed(true);
			((ButtonMenuText) buttonText).setButtonPressed(true);
		});		
		buttonText.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
			((ButtonMenuIcon) buttonIcon).setButtonPressed(false);
			((ButtonMenuText) buttonText).setButtonPressed(false);
		});
		
		vBoxMenuIcons.getChildren().add(buttonIcon);
		controllerDrawerMenuContent.getVBoxMainMenuText().getChildren().add(buttonText);
	}
	
	private void toggleMenu() {
		if (drawerMenu.isOpened()) {
			drawersStackMenu.toggle(drawerMenu);
			transition.setRate(-1.0);				
		} else {
			drawersStackMenu.setVisible(true);
			drawersStackMenu.toggle(drawerMenu);
			transition.setRate(1.0);
		}
		
		transition.play();
	}
	
	private void closeMenu() {
		if (drawerMenu.isOpened()) {
			drawersStackMenu.toggle(drawerMenu);
			transition.setRate(-1.0);
			transition.play();
		} 				
	}
	
	// Getter
	public VBox getVBoxMainMenuText() {return vBoxMainMenuText;}
	
	// Setter
	public void set(Start start, Stage primaryStage) {
		this.start = start;
		this.primaryStage = primaryStage;	
		this.drawerMenu = start.getDrawerMenu();
		this.controllerDrawerMenuContent = start.getControllerDrawerMenuContent();
		this.drawersStackMenu = start.getControllerMain().getDrawersStackMenu();
		this.hamburgerMenu = start.getControllerMain().getHamburgerMenu();
		this.vBoxMenuIcons = start.getControllerMain().getVBoxMenuIcons();
		
		initDrawerMainMenu();
		addMenuContent();
	}
	
}

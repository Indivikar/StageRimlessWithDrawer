package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.NotificationPane;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;

import app.Start;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CMainMenu implements Initializable, IWindowMax {

	private Start start;
	private Stage primaryStage;

	@FXML private VBox vBoxMainMenuText;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	// Getter
	public VBox getVBoxMainMenuText() {return vBoxMainMenuText;}
	
	// Setter
	public void set(Start start, Stage primaryStage) {
		this.start = start;
		this.primaryStage = primaryStage;		
	}
	
}

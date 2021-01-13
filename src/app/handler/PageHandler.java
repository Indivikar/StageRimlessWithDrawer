package app.handler;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawersStack;

import app.Start;
import app.controller.CContent;
import app.controller.CMain;
import app.controller.CMultiTop;
import app.controller.CProtoTop;
import app.controller.CRegistraturplan;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PageHandler {
	
	public enum Page {
		Home, RP, MT, PT
	}

	private Start start;
	private Stage primaryStage;
	private JFXDrawersStack drawersStack;
	
	private AnchorPane content;
	private AnchorPane contentRP;
	private AnchorPane contentMT;
	private AnchorPane contentPT;
	
	private CContent controllerContent;
	private CRegistraturplan controllerRP;
	private CMultiTop controllerMT;
	private CProtoTop controllerPT;
	
	private StackPane contentPane;

	public PageHandler(Start start, Stage primaryStage, JFXDrawersStack drawersStack) {		
		this.start = start;	
		this.primaryStage = primaryStage;
		this.drawersStack = drawersStack;
				
		contentPane = new StackPane();
		drawersStack.setContent(contentPane);
		
		try {
			FXMLLoader loaderContent = new FXMLLoader(Start.class.getResource("view/fxml/content.fxml"));					
			content = loaderContent.load();
	
			FXMLLoader loaderContentRP = new FXMLLoader(Start.class.getResource("view/fxml/contentRP.fxml"));			
			contentRP = loaderContentRP.load();
			
			FXMLLoader loaderContentMT = new FXMLLoader(Start.class.getResource("view/fxml/contentMT.fxml"));			
			contentMT = loaderContentMT.load();
			
			FXMLLoader loaderContentPT = new FXMLLoader(Start.class.getResource("view/fxml/contentPT.fxml"));			
			contentPT = loaderContentPT.load();
			
			controllerContent = loaderContent.getController();
			controllerRP = loaderContentRP.getController();
			controllerMT = loaderContentMT.getController();
			controllerPT = loaderContentPT.getController();
			
			controllerContent.set(start, primaryStage);
			controllerRP.set(start, primaryStage);
			controllerMT.set(start, primaryStage);
			controllerPT.set(start, primaryStage);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPage(Page page) {
		switch (page) {
			case Home:
				contentPane.getChildren().clear();
				contentPane.getChildren().add(content);
				break;
			case RP:
				contentPane.getChildren().clear();
				contentPane.getChildren().add(contentRP);
				break;
			case MT:
				contentPane.getChildren().clear();
				contentPane.getChildren().add(contentMT);
				break;
			case PT:
				contentPane.getChildren().clear();
				contentPane.getChildren().add(contentPT);
				break;
			default:
				break;
		}

	}
	
}

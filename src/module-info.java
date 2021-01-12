module DrawerVorlage {
	exports app;
	exports app.controller;
	exports app.view.function;

	opens app.controller to javafx.fxml;
	
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.swt;
	requires javafx.web;
	
	// Libraries
	requires com.jfoenix;
	requires org.controlsfx.controls;
}
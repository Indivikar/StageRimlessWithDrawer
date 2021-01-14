package app.nodes;

import app.handler.PageHandler.Page;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ButtonMenuText extends Button {

	private static PseudoClass PSEUDO_CLASS_HOVER = PseudoClass.getPseudoClass("buttonHover");
	private static PseudoClass PSEUDO_CLASS_PRESSED = PseudoClass.getPseudoClass("buttonPressed");
	private static PseudoClass PSEUDO_CLASS_SELECTED = PseudoClass.getPseudoClass("buttonSelected");
	  
	private BooleanProperty hover;
	private BooleanProperty pressed;
	private BooleanProperty selected;
	
	private String name;
	private Page page;

	
	public ButtonMenuText(String name, Page page) {
		this.name = name;
		this.page = page;
		
		String font = "Verdana";
		
		Text t = new Text (name);
		t.setFont(Font.font(font, FontWeight.NORMAL, 20));
		t.setFill(Color.BLACK);
				
		setGraphic(t);
		
		//setText();
	
		hover = new SimpleBooleanProperty(false);
		hover.addListener((ov, oldVal, newVal) -> {
			pseudoClassStateChanged(PSEUDO_CLASS_HOVER, hover.get());		
			if (newVal || selected.get()) {
				t.setFill(Color.SNOW);			
				t.setFont(Font.font(font, FontWeight.NORMAL, 22));
			} else {
				t.setFill(Color.BLACK);
				t.setFont(Font.font(font, FontWeight.NORMAL, 20));
			}						
		});

		pressed = new SimpleBooleanProperty(false);
		pressed.addListener((ov, oldVal, newVal) -> {
			pseudoClassStateChanged(PSEUDO_CLASS_PRESSED, pressed.get());
			if (newVal) {
				setPadding(new Insets(0, 0, 1, 0));
			} else {
				setPadding(new Insets(0, 0, 0, 0));
			}
		});
		
		selected = new SimpleBooleanProperty(false);
		selected.addListener((ov, oldVal, newVal) -> {
			pseudoClassStateChanged(PSEUDO_CLASS_SELECTED, selected.get());
			if (newVal) {
				t.setFill(Color.SNOW);			
				t.setFont(Font.font(font, FontWeight.NORMAL, 22));
			} else {
				t.setFill(Color.BLACK);
				t.setFont(Font.font(font, FontWeight.NORMAL, 20));
			}	
		});
		
		getStyleClass().add("button-mainmenu");
	}
	
	public String getName() {return name;}
	public Page getPage() {return page;}
	
	public boolean isButtonHover() {return this.hover.get();}
	public boolean isButtonPressed() {return this.pressed.get();}
	public boolean isButtonSelected() {return this.selected.get();}
	
	public void setButtonHover(boolean hover) {this.hover.set(hover);}
	public void setButtonPressed(boolean pressed) {this.pressed.set(pressed);}
	public void setButtonSelected(boolean selected) {this.selected.set(selected);}
	
	public BooleanProperty getHoverProp() {return hover;}
	public BooleanProperty getPressedProp() {return pressed;}
	public BooleanProperty getSelectedProp() {return selected;}
	   
}

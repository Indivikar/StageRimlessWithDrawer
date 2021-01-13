package app.nodes;

import org.kordamp.ikonli.javafx.FontIcon;

import app.handler.PageHandler.Page;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class ButtonMenuIcon extends Button {

	private static PseudoClass PSEUDO_CLASS_HOVER = PseudoClass.getPseudoClass("buttonHover");
	private static PseudoClass PSEUDO_CLASS_PRESSED = PseudoClass.getPseudoClass("buttonPressed");
  
	private BooleanProperty hover;
	private BooleanProperty pressed;
	  
	  
	public ButtonMenuIcon(String id, String color, int size, String text, Page page) {
		
		FontIcon icon = customizeIkon(id, color, size);
		
		setGraphic(icon);
		setTooltip(new Tooltip(text));

		hover = new SimpleBooleanProperty(false);
		hover.addListener(e -> pseudoClassStateChanged(PSEUDO_CLASS_HOVER, hover.get()));

		pressed = new SimpleBooleanProperty(false);
		pressed.addListener((ov, oldVal, newVal) -> {
			pseudoClassStateChanged(PSEUDO_CLASS_PRESSED, pressed.get());
			if (newVal) {
				setPadding(new Insets(0, 0, 1, 0));
			} else {
				setPadding(new Insets(0, 0, 0, 0));
			}
		});
		
		getStyleClass().add("button-mainmenu");
	}
	  
    private FontIcon customizeIkon(String id, String color, int size) {
        FontIcon fontIcon = new FontIcon(id);
        fontIcon.setIconSize(size);
        fontIcon.setIconColor(Color.web(color));       
        return fontIcon;
    }
	  
	public boolean isButtonHover() {return this.hover.get();}
	public boolean isButtonPressed() {return this.pressed.get();}
	
	public void setButtonHover(boolean hover) {this.hover.set(hover);}
	public void setButtonPressed(boolean pressed) {this.pressed.set(pressed);}
	
	public BooleanProperty getHoverProp() {return hover;}
	public BooleanProperty getPressedProp() {return pressed;}
	   
}

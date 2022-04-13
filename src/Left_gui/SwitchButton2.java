package Left_gui;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class SwitchButton2 extends StackPane {
    private final Rectangle back = new Rectangle(30, 10, Color.RED);
    private final Button button = new Button();
    private String buttonStyleOff = "-fx-border-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-background-color: red;";
    private String buttonStyleOn = "-fx-border-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 0.2, 0.0, 0.0, 2); -fx-background-color: #00893d;";
    private boolean state = false;

    private void init() {
        getChildren().addAll(back, button);
        setMinSize(50, 20);
        back.maxWidth(50);
        back.minWidth(50);
        back.maxHeight(20);
        back.minHeight(20);
        back.setArcHeight(back.getHeight());
        back.setArcWidth(back.getHeight());
        back.setFill(Color.valueOf("#ced5da"));
        Double r = 2.0;
        button.setShape(new Circle(r));
        setAlignment(button, Pos.CENTER_LEFT);
        button.setMaxSize(20, 20);
        button.setMinSize(20, 20);
        button.setStyle(buttonStyleOff);
    }

    public SwitchButton2() {
        init();
        EventHandler<Event> click = new EventHandler<Event>() {
            @Override
            public void handle(Event e) {
                if (state) {
                    button.setStyle(buttonStyleOff);
                    back.setFill(Color.valueOf("#ced5da"));
                    setAlignment(button, Pos.CENTER_LEFT);
                    state = false;
                } else {
                    button.setStyle(buttonStyleOn);
                    back.setFill(Color.valueOf("#80C49E"));
                    setAlignment(button, Pos.CENTER_RIGHT);
                    state = true;
                }
            }
        };

        button.setFocusTraversable(false);
        setOnMouseClicked(click);
        button.setOnMouseClicked(click);
    }

   public void SetValue(boolean b) {
	   if (b) {
		   button.setStyle(buttonStyleOn);
           back.setFill(Color.valueOf("#80C49E"));
           setAlignment(button, Pos.CENTER_RIGHT);
           state = true;
       } else {
    	   button.setStyle(buttonStyleOff);
           back.setFill(Color.valueOf("#ced5da"));
           setAlignment(button, Pos.CENTER_LEFT);
           state = false;
           
       }
   }
    
	public String getButtonStyleOff() {
		return buttonStyleOff;
	}

	public void setButtonStyleOff(String buttonStyleOff) {
		this.buttonStyleOff = buttonStyleOff;
	}

	public String getButtonStyleOn() {
		return buttonStyleOn;
	}

	public void setButtonStyleOn(String buttonStyleOn) {
		this.buttonStyleOn = buttonStyleOn;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Rectangle getBack() {
		return back;
	}

	public Button getButton() {
		return button;
	}
    
}

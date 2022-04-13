package Left_gui;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;

public class switchButton extends Label {
	private SimpleBooleanProperty switchedOn = new SimpleBooleanProperty(true);

	public switchButton() {
		Button switchBtn = new Button();
		switchBtn.setPrefWidth(40);
		switchBtn.setPrefHeight(25);
		switchBtn.setId("switchButton");
		switchBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				switchedOn.set(!switchedOn.get());
			}
		});

		setGraphic(switchBtn);

		switchedOn.addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
				if (t1) {
					setText(" ON  ");

					setStyle(" -fx-fill: white; -fx-background-color:" + " " + "  linear-gradient(lightgreen, lightgreen);  " + ""

					);

					setContentDisplay(ContentDisplay.RIGHT);
				} else {
					setText(" OFF ");
					setStyle(" -fx-fill: white;"

							+ " -fx-background-color: linear-gradient(red, red);  "
							+ ""

					);
						setContentDisplay(ContentDisplay.LEFT);
				}
			}
		});

		switchedOn.set(false);
	}

	public SimpleBooleanProperty switchOnProperty() {
		return switchedOn;
	}

	public SimpleBooleanProperty getSwitchedOn() {
		return switchedOn;
	}

	public void setSwitchedOn(SimpleBooleanProperty switchedOn) {
		this.switchedOn = switchedOn;
	}
}
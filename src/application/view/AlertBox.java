package application.view;

import java.util.Optional;

import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

public class AlertBox {
	public static Optional<ButtonType> showAndWait(AlertType alertType, String text1, String text2) {
		Stage newStage = new Stage();
		
		newStage.setWidth(300);
		newStage.setHeight(200);
		newStage.setTitle("New Window");
		newStage.setAlwaysOnTop(true);
		newStage.centerOnScreen();
		newStage.setResizable(false);
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.showAndWait();
		return null;
	}

}

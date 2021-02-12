package application.view;

import application.ViewLoader;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainController {
	private Stage primaryStage;
	ViewLoader<AnchorPane, PaintingsController> viewLoaderPain;

	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setPaintingFXML(ViewLoader<AnchorPane, PaintingsController> viewLoaderPain) {
		this.viewLoaderPain = viewLoaderPain;
	}

	@FXML
	private void onAbout() {

		AlertBox.showAndWait(AlertType.INFORMATION, "Default text", "Default text 2");
	}

	@FXML
	private void onExit() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	private void menuItem_Close() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	private void menuItem_About() {
		primaryStage.fireEvent(new WindowEvent(primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

}

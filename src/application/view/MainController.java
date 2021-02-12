package application.view;

import application.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
//import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
import javafx.stage.Stage;

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
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("About");
		alert.setContentText("CONTENT");
		alert.show();
		primaryStage.close();
	}

	@FXML
	private void onExit() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm you want to close app");
		alert.setContentText("Are you sure you want to exit?");
		alert.show();
		primaryStage.close();
	}

	@FXML
	private void menuItem_Close() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm you want to close app");
		alert.setContentText("Are you sure you want to exit?");
		alert.show();
		primaryStage.close();
	}

	@FXML
	private void menuItem_About() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("Author");
		alert.setTitle("Author information");
		alert.setContentText("Małgorzata Rakowska malgorzata.rakowska404@gmail.com");
		alert.show();
	}

}

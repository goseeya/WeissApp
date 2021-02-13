package application;

import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import application.model.dal.FileIO;
import application.view.MainController;
import application.view.PaintingsController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	void primaryStage_CloseRequest(WindowEvent e, Stage stage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm you want to close app");
		alert.setContentText("Are you sure you want to exit?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			stage.close();
		} else {
			e.consume();
		}
	}

	@Override
	public void start(Stage primaryStage) {

		try {
			ViewLoader<AnchorPane, PaintingsController> viewLoaderPain = new ViewLoader<>("view/Paintings.fxml");
			ViewLoader<BorderPane, MainController> viewLoaderMain = new ViewLoader<>("view/Main.fxml");
			BorderPane borderPane = viewLoaderMain.getLayout();

			ViewLoader<BorderPane, MainController> viewLoaderWelcome = new ViewLoader<>("view/Welcome.fxml");
			BorderPane borderPane2 = viewLoaderWelcome.getLayout();
			borderPane.setCenter(borderPane2);

			MainController mainController = viewLoaderMain.getController();
			mainController.setStage(primaryStage);

			PaintingsController painController = viewLoaderPain.getController();
			painController.setPaintings(new FileIO().getPaintings(null));

			Scene scene = new Scene(borderPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Paintings");
			primaryStage.setOnCloseRequest(e -> primaryStage_CloseRequest(e, primaryStage));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}

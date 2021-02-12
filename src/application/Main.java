package application;
	import java.util.Optional;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import application.model.dal.FileIO;
import application.view.AlertBox;
import application.view.MainController;
import application.view.PaintingsController;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {

	@Override
	public void init() {
//		setPaintings();
	}


	void primaryStage_Hiding(WindowEvent e) {

	}

	void primaryStage_CloseRequest(WindowEvent e) {
		Optional<ButtonType> result = AlertBox.showAndWait(AlertType.CONFIRMATION, "Closing",
				"Do you want to close the app?");
		if (result.orElse(ButtonType.CANCEL) != ButtonType.OK)
			e.consume();
	}

	@Override
	public void start(Stage primaryStage) {

		try {
			ViewLoader<AnchorPane, PaintingsController> viewLoaderPain = new ViewLoader<>("view/Paintings.fxml");
			AnchorPane anchorPane = viewLoaderPain.getLayout();

			ViewLoader<BorderPane, MainController> viewLoaderMain = new ViewLoader<>("view/Main.fxml");
			BorderPane borderPane = viewLoaderMain.getLayout();

			borderPane.setCenter(anchorPane);
			MainController mainController = viewLoaderMain.getController();
			mainController.setStage(primaryStage);

			PaintingsController painController = viewLoaderPain.getController();
			painController.setPaintings(new FileIO().getPaintings(null));

			Scene scene = new Scene(borderPane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Paintings");
			primaryStage.setOnHiding(e -> primaryStage_Hiding(e));
			primaryStage.setOnCloseRequest(e -> primaryStage_CloseRequest(e));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

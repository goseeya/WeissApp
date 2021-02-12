package application.view;

import java.io.IOException;

import application.model.Painting;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class WelcomeController {

	@FXML
	private Button cancelWelcomeButton;

	@FXML
	private Button nextWelcomeButton;

	@FXML
	public void clickWelcomeNextButton(ActionEvent event) {
		System.out.println("blabla");
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("application/view/Paintings.fxml"));
			Stage stage = new Stage();
			stage.setTitle("My New Stage Title");
			stage.setScene(new Scene(root, 600, 600));
			stage.show();
			// Hide this current window
			((Node) (event.getSource())).getScene().getWindow().hide();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void onCancelWelcomeButton(ActionEvent event) {

		Stage stage = (Stage) cancelWelcomeButton.getScene().getWindow();
		stage.close();
	}

	private Stage paintingsStage;

	@FXML
	public void setPaintingsStage(Stage paintingsStage) {
		this.paintingsStage = paintingsStage;

	}

}

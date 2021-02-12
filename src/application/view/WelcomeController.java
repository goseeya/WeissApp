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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class WelcomeController {

	@FXML
    public void clickWelcomeNextButton(ActionEvent event) {
		System.out.println("blabla");
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("./PictureEdit.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	
	private Stage paintingsStage;

	
	@FXML
	public void setPaintingsStage(Stage paintingsStage) {
		// TODO Auto-generated method stub
		this.paintingsStage = paintingsStage;

	}

}

package application.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PaintingAddController {

	@FXML
	private Button save;

	@FXML
	private Button addPaintingSaveButton;

	@FXML
	private Button addPaintingCancelButton;

	@FXML
	private TextField titleTextField;

	@FXML
	private TextField firstNameTextField;

	@FXML
	private TextField lastNameTextField;

	@FXML
	private RadioButton squareRadioButton;

	@FXML
	private RadioButton circleRadioButton;

	@FXML
	private RadioButton rectangleRadioButton;

	@FXML
	private TextField widthTextField;

	@FXML
	private TextField heightTextField;

	@FXML
	private TextField radiusTextField;

	@FXML
	private TextField weightTextField;

	@FXML
	private TextField priceTextField;

	private Stage employeeEditStage;

	@FXML
	public void setPaintingsStage(Stage employeeEditStage) {
		this.employeeEditStage = employeeEditStage;

	}

	@FXML
	void initialize() {

		ToggleGroup group = new ToggleGroup();
		squareRadioButton.setToggleGroup(group);
		circleRadioButton.setToggleGroup(group);
		rectangleRadioButton.setToggleGroup(group);

	}

	@FXML
	void onSave(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("SAVE TITLE");
		alert.setContentText(save.getText());
		alert.show();
		employeeEditStage.close();

	}

	@FXML
	void onSelectCircle(ActionEvent event) {
		circleRadioButton.setSelected(true);
		squareRadioButton.setSelected(false);
		rectangleRadioButton.setSelected(false);

	}

	@FXML
	void onSelectSquare(ActionEvent event) {
		this.circleRadioButton.setSelected(false);
		this.squareRadioButton.setSelected(true);
		this.rectangleRadioButton.setSelected(false);

	}

	@FXML
	void onSelectRectangle(ActionEvent event) {
		circleRadioButton.setSelected(false);
		squareRadioButton.setSelected(false);
		rectangleRadioButton.setSelected(true);

	}

	private static final String newLine = System.getProperty("line.separator");

	@FXML
	void onAddPaintingSave(ActionEvent event) {
		System.out.println("ADD PAINTING SAVE");
		// save to file
		Scanner scanner;
		int count = 0;

		try {
			scanner = new Scanner(Paths.get("src/application/model/dal/sampleData.txt"));
			while (scanner.hasNextLine()) {
				count++;
				scanner.nextLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		String id = Integer.toString(count);
		String title = titleTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		String shape = "squae";

		if (squareRadioButton.isSelected()) {
			shape = "square";
		}
		if (circleRadioButton.isSelected()) {
			shape = "circle";
		}

		if (rectangleRadioButton.isSelected()) {
			shape = "rectangle";
		}
		String width = widthTextField.getText() == "" ? "0" : widthTextField.getText();
		String height = heightTextField.getText() == "" ? "0" : heightTextField.getText();
		String radius = radiusTextField.getText() == "" ? "0" : radiusTextField.getText();
		;

		String area = (radius == "0" || radius == "")
				? Integer.toString(Integer.parseInt(width) * Integer.parseInt(height))
				: Integer.toString((int) (Math.PI * Integer.parseInt(radius) * Integer.parseInt(radius)));

		String weight = weightTextField.getText();
		String price = priceTextField.getText();

		String msg = "" + id + " " + title + " " + firstName + " " + lastName + " " + shape + " " + width + " " + height
				+ " " + radius + " " + area + " " + weight + " " + price;

		String fileName = "src/application/model/dal/sampleData.txt";
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileOutputStream(fileName, true));
			printWriter.write(newLine + msg);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

	}

	@FXML
	void onClose(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
	}
}

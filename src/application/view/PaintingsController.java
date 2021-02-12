package application.view;

import java.io.File;

import application.model.dal.Painting;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class PaintingsController {
	
	
	File file = new File("src/application/view/Chopin.wav");
	Media media = new Media(file.toURI().toString());
    MediaPlayer mp = new MediaPlayer(media);
	
	@FXML
	private Button playMusicButton;
	
	@FXML
	private Button stopMusicButton;
	
	@FXML
	private Button openFileButton;



//	@FXML
//	void onX(ActionEvent event) {
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Clear calculations");
//		alert.setContentText(AC.getText());
//		alert.show();
//		calculatorStage.close();
//
//	}

	@FXML
	void onSomething(ActionEvent event) {

	}

	@FXML
	void onClose(ActionEvent event) {
		paintingsStage.close();
	}

	
	@FXML
	private TableView<Painting> paintingTable;
	
	
	@FXML
	private TableColumn<Painting, String> paintingIdColumn;
	
	@FXML
	private TableColumn<Painting, String> titleColumn;

	@FXML
	private TableColumn<Painting, String> firstNameColumn;
	
	@FXML
	private TableColumn<Painting, String> lastNameColumn;
	
	@FXML
	private TableColumn<Painting, String> shapeColumn;
	
	@FXML
	private TableColumn<Painting, String> widthColumn;
	
	@FXML
	private TableColumn<Painting, String> heightColumn;
	
	@FXML
	private TableColumn<Painting, String> radiusColumn;
	
	@FXML
	private TableColumn<Painting, String> areaColumn;
	
	@FXML
	private TableColumn<Painting, String> weightColumn;
	
	@FXML
	private TableColumn<Painting, String> priceColumn;


	
	
	@FXML
	private Label paintingIdLabel;
	
	@FXML
	private Label titleLabel;

	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;

	@FXML
	private Label shapeLabel;
	
	@FXML
	private Label widthLabel;
	
	@FXML
	private Label heightLabel;
	
	@FXML
	private Label radiusLabel;
	
	@FXML
	private Label areaLabel;
	
	@FXML
	private Label weightLabel;
	
	@FXML
	private Label priceLabel;

	
	@FXML
	private void initialize() {
		
		paintingTable.setTableMenuButtonVisible(true);
		
		paintingIdColumn.setCellValueFactory(cellData -> cellData.getValue().paintingIdProperty());
		
		titleColumn.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
		
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		shapeColumn.setCellValueFactory(cellData -> cellData.getValue().shapeProperty());

		widthColumn.setCellValueFactory(cellData -> cellData.getValue().widthProperty());

		heightColumn.setCellValueFactory(cellData -> cellData.getValue().heightProperty());

		radiusColumn.setCellValueFactory(cellData -> cellData.getValue().radiusProperty());

		areaColumn.setCellValueFactory(cellData -> cellData.getValue().areaProperty());

		weightColumn.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
		
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

		

		// set fields value
		
//		updatePainting(null);

		// listen to selected row change
		
		paintingTable.getSelectionModel().selectedItemProperty()
		.addListener((observble, oldValue, newValue) -> updatePainting(newValue));
//		paintingTable.setEditable(true);
	}

	public void setPaintings(ObservableList<Painting> paintings) {

		paintingTable.getItems().clear();
		paintingTable.setItems(paintings);

		// select the first row in table if not empty
		if (!paintingTable.getItems().isEmpty()) {
			paintingTable.getSelectionModel().select(0);
		}

	}

	public void updatePainting(Painting pain) {
		if (pain != null) {
			paintingIdLabel.setText(pain.getPaintingId());
			titleLabel.setText(pain.getTitle());
			firstNameLabel.setText(pain.getFirstName());
			lastNameLabel.setText(pain.getLastName());
			shapeLabel.setText(pain.getShape());
			widthLabel.setText(pain.getWidth());
			heightLabel.setText(pain.getHeight());
			radiusLabel.setText(pain.getRadius());
			areaLabel.setText(pain.getArea());
			weightLabel.setText(pain.getWeight());
			priceLabel.setText(pain.getPrice());

		} else {
			paintingIdLabel.setText("");
			titleLabel.setText("");
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			shapeLabel.setText("");
			widthLabel.setText("");
			heightLabel.setText("");
			radiusLabel.setText("");
			areaLabel.setText("");
			weightLabel.setText("");
			priceLabel.setText("");
		}
	}
	
	@FXML
	private void deletePainting() {
		int selIdx = paintingTable.getSelectionModel().getSelectedIndex();
		if (selIdx > 0)
			paintingTable.getItems().remove(selIdx);
	}
	
	@FXML
	private void onPlayMusic() {
        mp.play();
	}
	
	@FXML
	private void onStopMusic() {

		mp.stop();
	}
	
	@FXML
	private void onOpenFile() {

        final FileChooser fileChooser = new FileChooser();
        
        File file = fileChooser.showOpenDialog(paintingsStage);
        if (file != null) {
            openFile(file);
        }

	}
	
	
	
	private void openFile(File file2) {
//		setPaintings(getPaintings(file2));
	}


	private Stage paintingsStage;

	
	@FXML
	public void setPaintingsStage(Stage paintingsStage) {
		this.paintingsStage = paintingsStage;

	}

}

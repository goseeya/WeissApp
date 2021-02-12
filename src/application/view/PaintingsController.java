package application.view;

import java.io.File;

import application.ViewLoader;
import application.model.dal.FileIO;
import application.model.dal.Painting;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

	@FXML
	private Button filterButton;

	@FXML
	private Button refreshButton;

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
	private TextField title;

	@FXML
	private TextField price;

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

	}

	public void setPaintings(ObservableList<Painting> paintings) {

		paintingTable.getItems().clear();
		paintingTable.setItems(paintings);

		// select the first row in table if not empty
		if (!paintingTable.getItems().isEmpty()) {
			paintingTable.getSelectionModel().select(0);
		}

	}

	public void setFilteredPaintings(ObservableList<Painting> paintings) {
		System.out.println("SET FILTERED PAINTINGS");
		paintingTable.getItems().clear();
		FilteredList<Painting> filteredData = new FilteredList<>(paintings, p -> true);

		title.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(painting -> {
				// If filter text is empty, display all paintings.
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (painting.getTitle().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				} else {
				return false;
				}}
			);
		});
		

		paintingTable.setItems(filteredData);

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

	@FXML
	private void onRefresh() {

		openFile(new File(filePath));

	}

	@FXML
	private void onAddPainting() {

		Dialog alert = new Dialog();

		Stage stage = new Stage();

		ViewLoader<BorderPane, PaintingAddController> viewLoaderMain = new ViewLoader<>("view/PaintingAdd.fxml");
		BorderPane borderPane = viewLoaderMain.getLayout();

		stage.setScene(new Scene(borderPane));
		stage.show();

	}

	@FXML
	private void onFilter() {
		
		

		System.out.println("ONFILTER");

		setFilteredPaintings(fileio.getPaintings(filePath));

	}

	private FileIO fileio = new FileIO();

	private String filePath;

	private void openFile(File file2) {
		filePath = file2.getPath();
		setPaintings(fileio.getPaintings(filePath));
	}

	private Stage paintingsStage;

	@FXML
	public void setPaintingsStage(Stage paintingsStage) {
		this.paintingsStage = paintingsStage;

	}

}

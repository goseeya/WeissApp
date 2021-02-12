package application.model.dal;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Painting {

	private StringProperty id;
	private StringProperty title;
	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty shape;
	private StringProperty width;
	private StringProperty height;
	private StringProperty radius;
	private StringProperty area;
	private StringProperty weight;
	private StringProperty price;

	public Painting() {
		id = new SimpleStringProperty("0");
		title = new SimpleStringProperty("");
		firstName = new SimpleStringProperty("");
		lastName = new SimpleStringProperty("");
		shape = new SimpleStringProperty("");
		width = new SimpleStringProperty("");
		height = new SimpleStringProperty("");
		radius = new SimpleStringProperty("");
		area = new SimpleStringProperty("");
		weight = new SimpleStringProperty("");
		price = new SimpleStringProperty("");
	}

	public Painting(String paintingId) {
		this();
		this.id.set(paintingId);
	}

	public String getPaintingId() {
		return this.id.get();
	}

	public void setPaintingId(String paintingId) {
		this.id.set(paintingId);
	}

	public StringProperty paintingIdProperty() {
		return id;
	}

	public String getTitle() {
		return this.title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public StringProperty titleProperty() {
		return title;
	}

	public String getFirstName() {
		return this.firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	public String getLastName() {
		return this.lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	public String getShape() {
		return this.shape.get();
	}

	public void setShape(String shape) {
		this.shape.set(shape);
	}

	public StringProperty shapeProperty() {
		return shape;
	}

	public String getWidth() {
		return this.width.get();
	}

	public void setWidth(String width) {
		this.width.set(width);
	}

	public StringProperty widthProperty() {
		return width;
	}

	public String getHeight() {
		return this.height.get();
	}

	public void setHeight(String height) {
		this.height.set(height);
	}

	public StringProperty heightProperty() {
		return height;
	}

	public String getRadius() {
		return this.radius.get();
	}

	public void setRadius(String radius) {
		this.radius.set(radius);
	}

	public StringProperty radiusProperty() {
		return radius;
	}

	public String getArea() {
		return area.get();
	}

	public void setArea(String area) {
		this.area.set(area);
	}

	public StringProperty areaProperty() {
		return area;
	}

	public String getWeight() {
		return weight.get();
	}

	public void setWeight(String weight) {
		this.weight.set(weight);
	}

	public StringProperty weightProperty() {
		return weight;
	}

	public String getPrice() {
		return this.price.get();
	}

	public void setPrice(String price) {
		this.price.set(price);
	}

	public StringProperty priceProperty() {
		return price;
	}

}

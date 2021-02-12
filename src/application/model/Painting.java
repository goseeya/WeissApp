package application.model;

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
		title = new SimpleStringProperty("");;
		firstName = new SimpleStringProperty("");;
		lastName = new SimpleStringProperty("");;
		shape = new SimpleStringProperty("");;
		width = new SimpleStringProperty("");;		
		height = new SimpleStringProperty("");;
		radius = new SimpleStringProperty("");;
		area = new SimpleStringProperty("");;
		weight = new SimpleStringProperty("");;
		price = new SimpleStringProperty("");;
	}
	
	public String getPaintingId() {
		return this.id.get();
	}

	public void setPaintingId(String paintingId) {
		this.id.set(paintingId);
	}
	
	public StringProperty idProperty() {
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
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	public String getShape() {
		return shape.get();
	}

	public void setShape(String shape) {
		this.shape.set(shape);
	}

	public StringProperty shapeProperty() {
		return shape;
	}
	
	public String getWidth() {
		return width.get();
	}

	public void setWidth(String width) {
		this.width.set(width);
	}

	public StringProperty widthProperty() {
		return width;
	}
	
	public String getHeight() {
		return height.get();
	}

	public void setHeight(String height) {
		this.height.set(height);
	}

	public StringProperty heightProperty() {
		return height;
	}
	
	public String getRadius() {
		return radius.get();
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
		return price.get();
	}

	public void setPrice(String price) {
		this.price.set(price);
	}

	public StringProperty priceProperty() {
		return price;
	}
	
}

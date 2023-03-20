package lms.coffee.entity;

public class Coffee {
private String brand;
private Double price;
public Coffee(String brand, Double price) {
	super();
	this.brand = brand;
	this.price = price;
}

public Coffee() {
	super();
	// TODO Auto-generated constructor stub
}

public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
@Override
public String toString() {
	return "Coffee [brand=" + brand + ", price=" + price + "]";
   }

}


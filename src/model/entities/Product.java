package model.entities;

public class Product {
	private String name;
	private Double value;
	private Integer quantity;
	
	public Product() {
	}
	
	public Product(String name, Double value, Integer quantity) {
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double total() {
		return getQuantity() * getValue();
	}

	@Override
	public String toString() {
		return "\n Product [name=" + name + ", value=" + value + ", quantity=" + quantity + "] \n";
	}
	
	
}
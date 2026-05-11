package pharmacyManagementSystem;

public class Medicine {
	private int id;
	private String name;
	private double price;
	private MedicineType type;

	public Medicine(int id, String name, double price, MedicineType type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double p) {
		this.price = p;
	}

	public void printInfo() {
		System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price + ", Type: " + type);
	}
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type + "]";
	}
}
package day11.product;

public class Product {

	// 정보 : 제품명, 가격
	private String name;
	private int price;
	
	//getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//생성자
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void print() {
		System.out.println(name + " : " + price);
	}
	
	public void update(int price) {
		this.price = price;
	}
	
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
}

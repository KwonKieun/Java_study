package test1;

import lombok.Data;

@Data
public class Fruit {
	String fruit;
	String color;
	
	public Fruit(String fruit, String color) {
		this.fruit = fruit;
		this.color = color;
	}

}

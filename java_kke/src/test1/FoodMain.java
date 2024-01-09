package test1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FoodMain {
	
	static List<Food> list = new ArrayList<Food>();
	public static void main(String[] args) {
		String fileName = "src/test1/foodList.txt";
		
		list.add(new Food("사과", 20));
		
		fileSave(fileName);
	}
	
	public static void fileSave(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(list);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
}

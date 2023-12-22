package day11.product;

import java.util.Scanner;

import day10.word.Word;

public class ProductMain {
	/* 제품을 관리하는 프로그램 구현하세요.
	 * 
	 * 메뉴
	 * 1. 제품 입고
	 * - 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 * 2. 제품 판매
	 * - 입고된 제품을 판매
	 * 3. 제품 수정[가격]
	 * 4. 매출 내역 조회
	 * 5. 종료
	 */
	private static Scanner scan = new Scanner(System.in);
	private static Product[] List = new Product[10];
	private static Product[] salesList = new Product[10];
	private static int count = 0; // 저장된 제품 개수
	private static int salesCount = 0; // 판매된 제품 개수
	private static int sum = 0; // 매출
	
	public static void main(String[] args) {
		int menu = 0;
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: //1. 제품 입고
				insertProduct();
				break;
			case 2: //2. 제품 판매
				deleteProduct();
				break;
			case 3: //3. 제품 수정(가격)
				updateProduct();
				break;
			case 4: //4. 매출 내역 조회
				salesProduct();
				break;
			case 5: //5. 종료
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default: // 잘못된 메뉴 입력
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 5);
		
	}

	private static void deleteProduct() {
		scan.nextLine();
		System.out.println("=====제품 판매=====");
		System.out.print("제품명 : ");
		String name = scan.nextLine();
		
		int index = -1;
		for(int i = 0; i < count; i++) {
			if(List[i].equals(name)) {
				index = i;
				System.out.println(List[i].getPrice() + "원 입니다.");
				Product pdt2 = new Product(List[i].getName(), List[i].getPrice());
				salesList[salesCount++] = pdt2;
				
				if(salesCount == salesList.length) {
					expandsalesList();
				}
				
				break;
			}
		}
		if(index == -1) {
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		
		count--;
		System.out.println("제품이 판매되었습니다.");
		
		//찾은 번지 다음부터 한칸씩 당겨옴
		//기본 배열을 크기가 같은 새 배열을 생성
		Product []tmpList = new Product[List.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(List, 0, tmpList, 0, List.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index+1, List, index, count-index);
	}



	private static void salesProduct() {
		System.out.println("===매출 내역 조회===");		
		for(int i = 0; i < salesCount; i++) {
			salesList[i].print();
			sum += salesList[i].getPrice();
		}
		System.out.println("매출은 " + sum + "원입니다.");
		sum = 0;
	}

	private static void updateProduct() {
		scan.nextLine();
		System.out.println("===제품 수정(가격)===");
		System.out.print("제품명 : ");
		String name = scan.nextLine();
		
		for(int i = 0; i < count; i++) {
			if(List[i].equals(name)) {
				System.out.print("가격 : ");
				int price = scan.nextInt();
				
				List[i].update(price);
				
				System.out.println("단어가 수정되었습니다.");
				return;
			}
		}
		System.out.println("일치하는 제품이 없습니다.");
	}

	private static void insertProduct() {
		scan.nextLine();
		System.out.println("=====제품 입고=====");
		System.out.print("제품명 : ");
		String name = scan.nextLine();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		
		Product pdt = new Product(name, price);
		List[count] = pdt;
		count++;
		System.out.println("=====입고 내역=====");
		for(int i = 0; i < count; i++) {
			List[i].print();
		}
		
		//배열 부족하면 늘려주는 작업
		if(count == List.length) {
			expandList();
		}
	}

	private static void printMenu() {
		System.out.println("===============");
		System.out.println("메뉴");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정(가격)");
		System.out.println("4. 매출 내역 조회");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}

	private static void expandList() {
		// 기존 배열보다 큰 배열 생성
		Product[] tmpList = new Product[List.length + 10];
		System.arraycopy(List, 0, tmpList, 0, count);
		List = tmpList;
	}
	
	private static void expandsalesList() {
		// 기존 배열보다 큰 배열 생성
		Product[] tmpList = new Product[salesList.length + 10];
		System.arraycopy(salesList, 0, tmpList, 0, count);
		salesList = tmpList;
	}
}

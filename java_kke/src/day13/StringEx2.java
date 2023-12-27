package day13;

import java.util.Scanner;

public class StringEx2 {

	private static Scanner scan = new Scanner(System.in);
	private static String arr[] = new String[5];
	private static int count = 0;
	public static void main(String[] args) {
		/* 문장들을 입력받아 배열에 저장하고, 특정 단어가 들어가있는 문장들을 출력하는 프로그램 작성
		 * 메뉴
		 * 1. 문장 추가
		 * 2. 검색
		 * 3. 종료
		 */
		
		/* 안녕하세요.
		 * 테스트
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 * '나'로 검색
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 */
		
		int menu = 0;
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);
			
		}while(menu != 3);

	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//문장 추가하는 코드
			insert();
			break;
		case 2:
			//검색하는 코드
			search();
			break;
		case 3:
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	private static void insert() {
		scan.nextLine();
		System.out.print("문장을 입력해주세요. : ");
		String sent = scan.nextLine();
		arr[count] = sent;
		count++;

		for(int i = 0; i < count; i++) {
			System.out.println(arr[i]);
		}
	}
	private static void search() {
		scan.nextLine();
		String word = scan.nextLine();
		for(int i = 0; i < count; i++) {
			if(arr[i].contains(word)) {
				System.out.println(arr[i]);
			}
		}
	}
	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}

}

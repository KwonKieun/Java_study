package day13;

import java.util.Scanner;

public class StringEx2_A {

	static Scanner scan = new Scanner(System.in);
	static String arr[] = new String[30];
	static int count = 0;
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
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = scan.nextInt();
			
			//기능 실행
			runMenu(menu);
			
		}while(menu != 3);

	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			//문장 추가하는 코드
			insertString();
			break;
		case 2:
			//검색하는 코드
			searchString();
			break;
		case 3:
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	public static void insertString() {
		scan.nextLine();//엔터처리
		//단어 입력
		System.out.print("문장을 입력해주세요. : ");
		String str = scan.nextLine();
		//단어 추가
		arr[count] = str;
		count++;
//		//테스트
//		for(int i = 0; i < count; i++) {
//			System.out.println(arr[i]);
//		}
	}
	public static void searchString() {
		//단어 입력
		System.out.print("단어 입력 : ");
		String str = scan.next();
		
		//검색
		for(String tmp : arr) {
			if(tmp != null && tmp.contains(str)) {
				System.out.println(tmp);
			}
			if(tmp != null && tmp.indexOf(str) >= 0) {
				System.out.println(tmp);
			}
		}
	}
	public static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}

}

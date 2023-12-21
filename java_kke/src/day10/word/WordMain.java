package day10.word;

import java.util.Scanner;

public class WordMain {
	/* 영어 단어장 프로그램을 만드세요.
	 * 1. 기능 정리
	 * - 단어 등록
	 * 	 - 단어 입력
	 * 	 - 뜻 입력
	 * - 단어 삭제
	 * 	 - 삭제할 단어 입력
	 * - 전체 단어 조회
	 * 
	 * 
	 * 2. 틀 작성
	 * 
	 * ============
	 * 메뉴
	 * 1. 단어 목록 조회
	 * 2. 단어 등록
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 1
	 * ============
	 * =단어 목록 조회=
	 * 1. 단어 공부
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 메뉴 선택 : 1
	 * ============
	 * ===단어 공부===
	 * word : 단어
	 * 정답입니다.
	 * ============
	 * =단어 목록 조회=
	 * 1. 단어 공부
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 메뉴 선택 : 2
	 * ============
	 * ===단어 수정===
	 * 수정할 단어 : word
	 * 단어 : word
	 * 뜻 : 단어
	 * ============
	 * =단어 목록 조회=
	 * 1. 단어 공부
	 * 2. 단어 수정
	 * 3. 단어 삭제
	 * 메뉴 선택 : 3
	 * ============
	 * ===단어 삭제===
	 * 삭제할 단어 : word
	 * ============
	 * 메뉴
	 * 1. 단어 목록 조회
	 * 2. 단어 등록
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 2
	 * ============
	 * ===단어등록===
	 * 단어 : word
	 * 뜻 : 단어
	 * ============
	 * 메뉴
	 * 1. 단어 목록 조회
	 * 2. 단어 등록
	 * 3. 프로그램 종료
	 * 메뉴 선택 : 3
	 * 프로그램이 종료되었습니다.
	 * 
	 * 3. 필요한 메서드 구현
	 */
	private static Scanner scan = new Scanner(System.in);
	private static Word [] wordList = new Word[5];//단어 목록
	private static int count = 0; //현재 등록된 단어 개수
	public static void main(String[] args) {
		int menu = 0;
		do {
			//메뉴출력
			printMenu();
			//메뉴입력
			menu = scan.nextInt();
			//메뉴 기능 실행
			runMenu(menu);
			
		}while(menu != 3);
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1://1. 단어 목록 조회
			//서브메뉴 출력
			printSubmenu();
			//서브메뉴 입력
			int subMenu = scan.nextInt();
			//서브메뉴 기능 실행
			runSubmenu(subMenu);
			
			break;
		case 2://2. 단어 등록
			scan.nextLine(); // 입력 버퍼에 남아있는 엔터 처리
			System.out.println("============");
			System.out.println("===단어등록===");
			System.out.print("단어 : ");
			String word = scan.nextLine();
			System.out.print("뜻 : ");
			String mean = scan.nextLine();
			//Word w = new Word(word, mean);
			//wordList[count] = w;
			++count;
			// 배열 크기를 안늘려도 되면 종료
			if(count < wordList.length) {
				return;
			}
			// 배열이 꽉 차면 배열을 늘려줌
			// 기존 배열보다 큰 배열 생성
			Word[] tmpList = new Word[wordList.length + 5];
			// 새로 생성된 배열에 기존 배열을 복사
			System.arraycopy(wordList, 0, tmpList, 0, count);
			// 새로 생성된 배열을 boardList에 연결
			wordList = tmpList;
			
			break;
		case 3://3. 프로그램 종료
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default://잘못된 메뉴 번호 입력
			System.out.println("잘못된 입력입니다.");
		}
	}
	private static void runSubmenu(int subMenu) {
		switch(subMenu) {
		case 1://1. 단어 공부
			// 단어 목록을 출력. 번호가 높은 순으로
			for(int i = count-1; i >= 0; i--) {
				System.out.println(i+1 + "번째 단어");
				//wordList[i].printInfo();
			}
			break;
		case 2://2. 단어 수정
			
			break;
		case 3://3. 단어 삭제
			
			break;
		case 4://4. 뒤로가기
			
			break;
		default://잘못된 메뉴 번호 입력
			System.out.println("잘못된 입력입니다.");
		}
	}
	private static void printSubmenu() {
		System.out.println("============");
		System.out.println("=단어 목록 조회=");
		System.out.println("1. 단어 공부");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 뒤로가기");
		System.out.print("메뉴 선택 : ");
	}
	private static void printMenu() {
		System.out.println("============");
		System.out.println("메뉴");
		System.out.println("1. 단어 목록 조회");
		System.out.println("2. 단어 등록");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}

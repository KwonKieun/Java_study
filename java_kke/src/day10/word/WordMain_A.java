package day10.word;

import java.util.Scanner;

public class WordMain_A {
	/* 영어 단어장 프로그램을 만드세요.
	 * 1. 기능 정리
	 * - 단어는 영어 단어와 한글 뜻으로 구성
	 * - 영어 단어는 영어이고, 공백이 없는 단어
	 * - 한글 뜻은 한글이고, 한 문장으로 되어있다.
	 * - 한 단어에 뜻이 한 개만 있다고 가정
	 * - 기능
	 * 	 - 단어 등록
	 *   - 단어 검색
	 *   - 단어 수정
	 *   - 단어 삭제
	 * - Word 클래스
	 *   - word : 영단어
	 *   - meaning : 뜻
	 *   - 단어 출력, 단어 수정, 단어 확인 : 주어진 문자열과 같은 단어인지 확인
	 * 2. 틀 작성
	 * ============
	 * 메뉴
	 * 1. 단어 등록
	 * 2. 단어 검색
	 * 3. 단어 수정
	 * 4. 단어 삭제
	 * 메뉴 선택 : 1
	 * 
	 * 
	 * 3. 필요한 메서드 구현
	 */
	private static Scanner scan = new Scanner(System.in);
	private static Word[] List = new Word[10]; // 단어장
	private static int count = 0; // 저장된 단어 개수
	public static void main(String[] args) {
		int menu = 0;
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 맞는 기능 실행
			runMenu(menu);
			
		}while(menu != 5);
	}

	private static void printMenu() {
		System.out.println("============");
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.println("============");
		System.out.print("메뉴 선택 : ");
	}
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			// 단어 등록 기능 구현
			insertWord();
			break;
		case 2: //단어 검색 기능 구현
			searchWord();
			break;
		case 3: //단어 수정 기능 구현
			updateWord();
			break;
		case 4: //단어 삭제 기능 구현
			deleteWord();
			break;
		case 5: //프로그램 종료
			System.out.println("프로그램 종료!");
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다.");
		}
	}

	private static void deleteWord() {
		System.out.println("============");
		System.out.println("===단어 삭제===");
		System.out.print("삭제할 단어 : ");
		String word = scan.next();
		
		//음수이면 된다.
		int index = -1;//일치하는 단어가 있는 번지
		for(int i = 0; i < count; i++) {
			//입력한 단어와 일치하는 단어를 찾아 번지를 저장
			if(List[i].equals(word)) {
				index = i;
				break;
			}
		}
		//일치하는 단어가 없으면
		if(index == -1) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		//저장된 단어의 개수를 1 줄임
		count--;
		System.out.println("삭제가 완료되었습니다.");
		
		//가장 최근에 등록한 단어를 삭제했다면
		//== 배열에서 가장 마지막에 있는 게시글을 삭제했다면
		if(index == count) {
			return;
		}
		
		//찾은 번지 다음부터 한칸씩 당겨옴
		//기본 배열을 크기가 같은 새 배열을 생성
		Word []tmpList = new Word[List.length];
		//새 배열에 기존 배열을 복사
		System.arraycopy(List, 0, tmpList, 0, List.length);
		//기존 배열에서 찾은 번지 다음부터 나머지 개수를 복사해서
		//새 배열에 찾은 번지부터 덮어씀
		System.arraycopy(tmpList, index+1, List, index, count-index);
	}

	private static void searchWord() {
		System.out.println("============");
		System.out.println("===단어 검색===");
		System.out.print("검색할 단어 : ");
		String word = scan.next();
		
		// 단어장에서 검색해서 결과를 출력
		// 반복문 : 단어 목록 전체
		for(int i = 0; i < count; i++) {
			// 입력한 단어와 일치하는 단어가 단어장에 있으면
			if(List[i].equals(word)) {
				//출력 후 종료
				List[i].print();
				return;
			}
		}
		// 일치하는 단어가 없습니다 라고 출력
		System.out.println("일치하는 단어가 없습니다.");
	}

	private static void updateWord() {
		scan.nextLine(); // 입력 버퍼에 남아있는 엔터 처리
		System.out.println("============");
		System.out.println("===단어 수정===");
		System.out.print("수정할 단어 : ");
		String word = scan.nextLine();
		
		// 반복문 : 단어 목록 전체
		for(int i = 0; i < count; i++) {
			// 입력한 단어와 일치하는 단어가 있으면
			if(List[i].equals(word)) {
				//scan.nextLine(); // 엔터처리
				System.out.print("뜻 : ");
				String updateMeaning = scan.nextLine();
				
				// 뜻을 수정하고 메서드 종료
				List[i].update(updateMeaning);
				System.out.println("단어가 수정되었습니다.");
				return;
			}
		}
		// 일치하는 게시글이 없습니다 라고 출력
		System.out.println("일치하는 게시글이 없습니다.");
	}

	private static void insertWord() {
		System.out.println("============");
		System.out.println("===단어등록===");
		//단어와 뜻 입력
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("뜻 : ");
		scan.nextLine(); // 입력 버퍼에 남아있는 엔터 처리
		String meaning = scan.nextLine();
		//단어와 뜻을 이용하여 Word의 인스턴스를 생성
		Word w = new Word(word, meaning);
		//위에서 생성한 인스턴스를 단어장에 저장
		List[count] = w;
		//저장된 단어의 개수를 1 증가
		++count;
		
		// 테스트용으로 단어장 목록 출력
		for(int i = 0; i < count; i++) {
			List[i].print();
		}
		
		//단어장이 꽉 차면 단어장 크기를 늘림
		if(count == List.length) {
			expandWordList();
		}
	}
	
	public static void expandWordList() {
		// 기존 단어장보다 큰 새 단어장 생성
		Word[] tmpList = new Word[List.length + 10];
		// 새 단어장에 기존 단어들을 복붙
		System.arraycopy(List, 0, tmpList, 0, count);
		// 새로 생성된 배열을 List에 연결
		// 새 단어장을 내 단어장이라고 선언
		List = tmpList;
	}

}

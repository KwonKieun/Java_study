package day11.homework;

import java.util.Scanner;

public class HomeworkEx1 {
	//쉬운 버전
	/* 고등 학생 성적을 관리하는 프로그램을 작성하세요.
	 * 메뉴
	 * 1. 학생 관리
	 * 	- 학생 추가 : 동일한 학생(학년,반,번호가 같은)이 있으면 안됨
	 * 	- 학생 수정
	 * 	- 학생 삭제
	 * 2. 성적 관리
	 * 	- 성적 추가 : 과목과 점수를 입력
	 *  - 성적 수정
	 *  - 성적 삭제
	 * 3. 프로그램 종료
	 * 
	 * - Student 클래스
	 * - Subject 클래스
	 *   - 쉬운 버전 : 과목명, 총점
	 *   - 어려운 버전 : 과목명, 성적(중간, 기말, 수행평가, 총점)
	 * */
	private static Scanner scan = new Scanner(System.in);
	private static Student [] stdList = new Student[10];
	private static Subject [] sbjs = new Subject[20];
	private static int count = 0;
	private static int countS = 1;
	public static void main(String[] args) {
		// 각 학생의 번호를 1번부터 20번까지 지정
		for(int i = 0; i < sbjs.length; i++) {
			sbjs[i] = new Subject(); // *유의하기* 각 번지마다 학생 인스턴스를 만들어줘야 함.
		}
		
		for(Subject sbj : sbjs) {
			sbj.studentNum = countS++;
			//sbj.printInfo();
		}
		
		
		int menu = 0;
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			
			runMenu(menu);
			
		}while(menu != 3);
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1: // 학생 관리
			printStdMenu();
			
			int submenu1 = scan.nextInt();
			
			runStdMenu(submenu1);
			break;
		case 2: // 성적 관리
			printScrMenu();
			
			int submenu2 = scan.nextInt();
			
			runScrMenu(submenu2);
			break;
		case 3: // 프로그램 종료
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void runStdMenu(int submenu1) {
		switch(submenu1) {
		case 1: //1. 학생 추가
			insertStd();
			break;
		case 2: //2. 학생 수정
			updateStd();
			break;
		case 3: //3. 학생 삭제
			deleteStd();
			break;
		case 4: //4. 뒤로 가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default: //잘못된 메뉴 번호 입력
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	private static void deleteStd() {
		System.out.println("====학생삭제====");
		System.out.print("삭제할 학생의 학년 : ");
		int grade = scan.nextInt();
		System.out.print("삭제할 학생의 반 : ");
		int classnum = scan.nextInt();
		System.out.print("삭제할 학생의 번호 : ");
		int num = scan.nextInt();
		System.out.print("삭제할 학생의 이름 : ");
		String name = scan.next();
		
		int index = -1;
		for(int i = 0; i < count; i++) {
			if(stdList[i].equals(name)) {
				if(grade == stdList[i].getGrade()
						 && classnum == stdList[i].getClassnum()
						 && num == stdList[i].getNum()) {
					index = i;
					break;
				 }
			}
		}
		if(index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		count--;
		System.out.println("삭제가 완료되었습니다.");
		
		if(index == count) {
			return;
		}
		
		Student []tmpList = new Student[stdList.length];
		System.arraycopy(stdList, 0, tmpList, 0, stdList.length);
		System.arraycopy(tmpList, index+1, stdList, index, count);
	}

	private static void updateStd() {
		//scan.nextLine();//입력 버퍼에 남아있는 엔터 처리
		System.out.println("====학생수정====");
		System.out.print("수정할 학생의 학년 : ");
		int grade = scan.nextInt();
		System.out.print("수정할 학생의 반 : ");
		int classnum = scan.nextInt();
		System.out.print("수정할 학생의 번호 : ");
		int num = scan.nextInt();
		System.out.print("수정할 학생의 이름 : ");
		String name = scan.next();
		
		for(int i = 0; i < count; i++) {
			if(stdList[i].equals(name)) {
				if(grade == stdList[i].getGrade()
						 && classnum == stdList[i].getClassnum()
						 && num == stdList[i].getNum()) {
					//scan.nextLine();//입력 버퍼에 남아있는 엔터 처리
					System.out.println("-----수정-----");
					System.out.print("학년 : ");
					int editgrade = scan.nextInt();
					System.out.print("반 : ");
					int editclassnum = scan.nextInt();
					System.out.print("번호 : ");
					int editnum = scan.nextInt();
					System.out.print("이름 : ");
					String editname = scan.next();
					
					//동일인 추가 x
					for(int j = 0; j < count; j++) {
						 if(stdList[j].equals(name)) {
							 if(grade == stdList[j].getGrade()
									 && classnum == stdList[j].getClassnum()
									 && num == stdList[j].getNum()) {
								 System.out.println("동일한 학생이 존재합니다.");
								 return;
							 }
						 }
					}
					
					stdList[i].update(editgrade, editclassnum, editnum, editname);
					System.out.println("학생 정보가 수정되었습니다.");
					return;
				 }
				
			}
		}
		System.out.println("일치하는 학생이 없습니다.");
	}

	private static void insertStd() {
		System.out.println("====학생추가====");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classnum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		
		Student std = new Student(grade, classnum, num, name);
		
		//동일인 추가 x
		for(int i = 0; i < count; i++) {
			 if(stdList[i].equals(name)) {
				 if(grade == stdList[i].getGrade()
						 && classnum == stdList[i].getClassnum()
						 && num == stdList[i].getNum()) {
					 System.out.println("동일한 학생이 존재합니다.");
					 return;
				 }
			 }
		}
		stdList[count] = std;
		++count;
		
		//확인용
//		for(int i = 0; i < count; i++) {
//			stdList[i].print();
//		}
		
		if(count < stdList.length) {
			return;
		}
		
		Student[] tmpList = new Student[stdList.length + 5];
		System.arraycopy(stdList, 0, tmpList, 0, count);
		stdList = tmpList;
	}

	private static void runScrMenu(int submenu2) {
		switch(submenu2) {
		case 1: //1. 성적 추가
			System.out.println("====성적추가====");
			insUdtScr();
			break;
		case 2: //2. 성적 수정
			System.out.println("====성적수정====");
			insUdtScr();
			break;
		case 3: //3. 성적 삭제
			deleteScr();
			break;
		case 4: //4. 뒤로 가기
			System.out.println("이전으로 돌아갑니다.");
			break;
		default: //잘못된 메뉴 번호 입력
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private static void deleteScr() {
		System.out.println("====성적삭제====");
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("과목 선택 : ");
		int subject = scan.nextInt();
		System.out.print("학생 선택 : ");
		int studentNum = scan.nextInt();
		
		for(Subject sbj : sbjs) {
			// 입력한 학생 번호와 일치하는 학생 정보를 찾아서 해당하는 과목에 맞는 성적을 수정
			if(sbj.studentNum != studentNum) {
				continue;
			}
			// 일치하는 학생이 있을 때
			switch(subject) {
			case 1:
				sbj.setKor(0);
				//확인용
//				for(int i = 0; i < countS-1; i++) {
//					sbjs[i].printInfo();
//				}
				return;
			case 2:
				sbj.setEng(0);
				return;
			case 3:
				sbj.setMath(0);
				return;
			default:
				System.out.println("잘못된 과목입니다.");
			}
		}
	}

	private static void insUdtScr() {
		System.out.println("1. 국어");
		System.out.println("2. 영어");
		System.out.println("3. 수학");
		System.out.print("과목 선택 : ");
		int subject = scan.nextInt();
		System.out.print("학생 선택 : ");
		int studentNum = scan.nextInt();
		System.out.print("성적 : ");
		double studentScr = scan.nextDouble();
		
		for(Subject sbj : sbjs) {
			// 입력한 학생 번호와 일치하는 학생 정보를 찾아서 해당하는 과목에 맞는 성적을 수정
			if(sbj.studentNum != studentNum) {
				continue;
			}
			// 일치하는 학생이 있을 때
			switch(subject) {
			case 1:
				sbj.setKor(studentScr);
				//확인용 코드
//				for(int i = 0; i < countS-1; i++) {
//					sbjs[i].printInfo();
//				}
				return;
			case 2:
				sbj.setEng(studentScr);
				return;
			case 3:
				sbj.setMath(studentScr);
				return;
			default:
				System.out.println("잘못된 과목입니다.");
			}
		}
		
	}

	private static void printScrMenu() {
		System.out.println("====성적관리====");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}

	private static void printStdMenu(){
		System.out.println("====학생관리====");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void printMenu() {
		System.out.println("============");
		System.out.println("메뉴");
		System.out.println("1. 학생 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}
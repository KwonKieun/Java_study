package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 성적 관리 프로그램을 작성하세요.
		 * - 1반의 성적을 관리
		 * - 최대 30명
		 * - 성적은 번호순으로 관리
		 * - 성적은 국어, 영어, 수학 성적을 관리
		 * 메뉴
		 * 1. 성적 수정
		 * 2. 성적 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 
		 * 
		 * -- 성적 수정 --
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 : 
		 * 
		 * 학생 선택 : 3 번호를 선택
		 * 성적 입력 : 100
		 * 
		 * -- 성적 조회 --
		 * 1. 과목별 조회
		 * 2. 학생별 조회
		 * 선택 : 1
		 * -- 과목별조회 --
		 * 1. 국어
		 * 2. 영어
		 * 3. 수학
		 * 과목 선택 : 1
		 * 1번 : 0점
		 * 2번 : 0점
		 * 3번 : 100점
		 * ....
		 * 30번 : 0점
		 * 
		 * -- 성적 조회 --
		 * 1. 과목별 조회
		 * 2. 학생별 조회
		 * 선택 : 2
		 * 학생 선택 : 3
		 * 국어 : 100점
		 * 영어 : 0점
		 * 수학 : 0점
		 */

		//반복문
			//메인 메뉴출력
			
			//메인 메뉴 선택
		
			//선택한 메인메뉴에 따른 기능 실행
		int menu = 0;
		int sub;
		int studentnum;
		int score;
		int maxStudent = 30;
		int student_kor[] = new int[maxStudent];
		int student_eng[] = new int[maxStudent];
		int student_math[] = new int[maxStudent];
		
		while(menu != 3) {
			System.out.println("메뉴");
			System.out.println("1. 성적수정");
			System.out.println("2. 성적조회");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			
			if(menu == 1) {
				System.out.println("--성적수정--");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				
				sub = scan.nextInt();
				System.out.print("학생 선택 : ");
				studentnum = scan.nextInt();
				System.out.print("성적 입력 : ");
				score = scan.nextInt();
				if(sub == 1) {
					student_kor[studentnum-1] = score;
				}
				else if(sub == 2) {
					student_eng[studentnum-1] = score;
				}
				else if(sub == 3) {
					student_math[studentnum-1] = score;
				}
			}
			else if(menu == 2) {
				System.out.println("--성적조회--");
				System.out.println("1. 과목별 조회");
				System.out.println("2. 학생별 조회");
				System.out.print("선택 : ");
				int view = scan.nextInt();
				
				if(view == 1) {
					System.out.println("--과목별 조회--");
					System.out.println("1. 국어");
					System.out.println("2. 영어");
					System.out.println("3. 수학");
					System.out.print("과목 선택 : ");
					int subview = scan.nextInt();
					
					if(subview == 1) {
						for(int i = 0; i < student_kor.length; i++) {
							System.out.println(i+1 + "번 : " + student_kor[i]);
						}
					}else if(subview == 2){
						for(int i = 0; i < student_eng.length; i++) {
							System.out.println(i+1 + "번 : " + student_eng[i]);
						}
					}else if(subview == 3){
						for(int i = 0; i < student_math.length; i++) {
							System.out.println(i+1 + "번 : " + student_math[i]);
						}
					}	
				}else if(view == 2) {
					System.out.print("학생 선택 : ");
					int studentsel2 = scan.nextInt();
					System.out.println("국어 : " + student_kor[studentsel2-1]);
					System.out.println("영어 : " + student_eng[studentsel2-1]);
					System.out.println("수학 : " + student_math[studentsel2-1]);
				}
				
			}
		}
		System.out.println("프로그램을 종료합니다.");

	}

}

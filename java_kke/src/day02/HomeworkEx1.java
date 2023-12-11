package day02;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * 90 이상 ~ 100 이하 : A
		 * 80 이상 ~ 90 미만 : B
		 * 70 이상 ~ 80 미만 : C
		 * 60 이상 ~ 70 미만 : D
		 * 60 미만 : F
		 * 0보다 작거나 100보다 큰 경우 : 잘못된 점수
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하세요. : ");
		double score = scan.nextDouble();
		
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점 성적은 A입니다.");
		}else if(score >= 80 && score <= 90) {
			System.out.println(score + "점 성적은 B입니다.");
		}else if(score >= 70 && score <= 80) {
			System.out.println(score + "점 성적은 C입니다.");
		}else if(score >= 60 && score <= 70) {
			System.out.println(score + "점 성적은 D입니다.");
		}else if(score < 60) {
			System.out.println(score + "점 성적은 F입니다.");
		}else {
			System.out.println("정확한 성적을 입력하세요.");
		}
		
		
		scan.close();
	}

}

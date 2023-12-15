package day06;

import java.util.Scanner;

public class HomeworkEx1 {

	public static void main(String[] args) {
		/* 숫자 야구게임을 구현하세요.
		 * - 1~9 사이의 중복되지 않는 3개의 수를 랜덤으로 선택해서
		 * 		해당 숫자를 맞추는 게임
		 * - S : 숫자가 있고, 위치가 같은 경우
		 * - B : 숫자가 있지만, 위치가 다른 경우
		 * - O : 일치하는 숫자가 하나도 없는 경우
		 * - 3S : 게임 종료
		 * 
		 * 예시
		 * 랜덤으로 생성된 숫자 : 3 9 1
		 * 입력 : 1 2 3
		 * 결과 : 2B
		 * 입력 : 4 5 6
		 * 결과 : O
		 * 입력 : 7 9 8
		 * 결과 : 1S
		 * 입력 : 3 1 9
		 * 결과 : 1S2B
		 * 입력 : 3 9 1
		 * 결과 : 3S
		 * 정답입니다.
		 */
		
		int min = 1, max = 9;
		int count = 0;
		int num[] = new int[3];
		int userNum[] = new int[3];
		Scanner scan = new Scanner(System.in);
		
		while(count < num.length) {
			//랜덤한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			//중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(num[i] == r) {
					break;
				}
			}
			//중복되지 않으면 저장 후 count증가
			if(i == count) {
				num[count++] = r;
			}
		}
		
		System.out.println("(임시출력)랜덤으로 생성된 숫자 : " + num[0] + " " + num[1] + " " + num[2]);
		while(true) {
			System.out.print("입력 : ");
			userNum[0] = scan.nextInt();
			userNum[1] = scan.nextInt();
			userNum[2] = scan.nextInt();
			
			int strike = 0;
			int ball = 0;
			
			for(int j = 0; j < num.length; j++) {
				for(int k = 0; k < userNum.length; k++) {
					if(num[j] == userNum[k] && j == k) {
						strike++;
					}
					else if(num[j] == userNum[k] && j != k) {
						ball++;
					}
				}
			}
			if(strike == 0 && ball == 0) {
				System.out.println("O");
			}
			else if(strike > 0 && ball > 0) {
				System.out.println(strike + "S" + ball + "B");
			}
			else if(strike > 0 && ball == 0) {
				System.out.println(strike + "S");
				if(strike == 3) {
					break;
				}
			}
			else if(strike == 0 && ball > 0) {
				System.out.println(ball + "B");
			}
			else {
				strike = 0;
				ball = 0;
			}
		}
		System.out.println("정답입니다.");
		
		scan.close();
		
	}

}

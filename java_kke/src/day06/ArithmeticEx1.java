package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/* 랜덤으로 산수(+, -, *) 문제를 생성하여 맞추는 게임
		 * 단, 숫자 범위는 1~99, 연산자는 +, -, *
		 * 1 + 2 = 3
		 * 정답입니다.
		 * 
		 * 2 * 3 = 5
		 * 틀렸습니다.
		 */
		int min = 1, max = 99;
		int min1 = 1, max1 = 3;
		int num1, num2;
		int opr;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			// 정수1, 정수2를 랜덤으로 생성 - 1~99
			num1 = (int)(Math.random() * (max-min+1) + min);
			num2 = (int)(Math.random() * (max-min+1) + min);
			// 정수3(연산자)를 랜덤으로 생성 - 1~3
			opr = (int)(Math.random() * (max1-min1+1) + min1);
			
			
			// 연산자가 1이면
			if(opr == 1) {
				// 정수1 + 정수2 = 을 콘솔에 출력
				System.out.print(num1 + " + " + num2 + " = ");
				// 정답을 입력
				int answer = scan.nextInt();
				// 입력받은 정답과 정수1 + 정수2가 같으면 정답이라고 출력
				if(answer == num1 + num2) {
					System.out.println("정답입니다.");
				}
				// 아니면 틀렸다고 출력
				else {
					System.out.println("틀렸습니다.");
				}
			}
				
			// 연산자가 2이면
			else if(opr == 2) {
				// 정수1 - 정수2 = 을 콘솔에 출력
				System.out.print(num1 + " - " + num2 + " = ");
				// 정답을 입력
				int answer = scan.nextInt();
				// 입력받은 정답과 정수1 - 정수2가 같으면 정답이라고 출력
				if(answer == num1 - num2) {
					System.out.println("정답입니다.");
				}
				// 아니면 틀렸다고 출력
				else {
					System.out.println("틀렸습니다.");
				}
			}
			
			// 연산자가 3이면
			else if(opr == 1) {
				// 정수1 * 정수2 = 을 콘솔에 출력
				System.out.print(num1 + " * " + num2 + " = ");
				// 정답을 입력
				int answer = scan.nextInt();
				// 입력받은 정답과 정수1 * 정수2가 같으면 정답이라고 출력
				if(answer == num1 * num2) {
					System.out.println("정답입니다.");
				}
				// 아니면 틀렸다고 출력
				else {
					System.out.println("틀렸습니다.");
				}
			}
			
			scan.close();
		}
		
		
	}

}

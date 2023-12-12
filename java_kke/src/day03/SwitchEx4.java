package day03;

import java.util.Scanner;

public class SwitchEx4 {

	public static void main(String[] args) {
		/* 산술 연산자와 두 정수를 입력받아
		 * 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요.
		 * ex)
		 * 두 정수와 연산자 입력 (예: 1 + 2) : 1 + 2
		 * 1 + 2 = 3
		 * ex2)
		 * 두 정수와 연산자 입력 (예: 1 / 2) : 1 / 2
		 * 1 / 2 = 0.5
		 * ex3)
		 * 두 정수와 연산자 입력 (예: 1 + 2) : 1 ? 2
		 * ?는 산술연산자가 아닙니다.
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 연산자 입력 (예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char opr = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		switch(opr) {
		case '+':
			System.out.println("" + num1 + opr + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println("" + num1 + opr + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println("" + num1 + opr + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println("" + num1 + opr + num2 + " = " + (num1 / (double)num2));
			break;
		case '%':
			System.out.println("" + num1 + opr + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println(opr + "은 산술연산자가 아닙니다.");
		}
		
		scan.close();
	}

}

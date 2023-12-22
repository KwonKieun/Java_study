package day11.homework;

import java.util.Scanner;

public class HomeworkEx2 {

	/* 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요.
	 * 메서드를 생성
	 */
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("두 정수와 산술연산자를 입력해주세요. (예 : 1 + 2) : ");
		int num1 = scan.nextInt();
		char opr = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		arithmetic(num1, num2, opr);
	}

	public static void arithmetic(int num1, int num2, char opr) {
		if(opr == '+') {
			System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		}else if(opr == '-') {
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		}else if(opr == '*') {
			System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		}else if(opr == '/') {
			System.out.println(num1 + " / " + num2 + " = " + ((double)num1 / num2));
		}else if(opr == '%') {
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		}else {
			System.out.println(opr + "는 산술연산자가 아닙니다.");
		}
		
	}

}
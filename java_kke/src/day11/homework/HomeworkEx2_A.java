package day11.homework;

import java.util.Scanner;

public class HomeworkEx2_A {

	/* 두 정수와 산술 연산자를 입력받아 결과를 출력하는 코드를 작성하세요.
	 * 메서드를 생성
	 */
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("두 정수와 산술연산자를 입력해주세요. (예 : 1 + 2) : ");
		int num1 = scan.nextInt();
		char opr = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		System.out.println(arithmeticCalculator(num1, num2, opr));
	}
	/**두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메서드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @param operator 산술연산자
	 * @return 정수1과 정수2를 산술연산한 결과 => double (나누기 때문에)
	 */

	public static double arithmeticCalculator(int num1, int num2, char opr) {
		switch(opr) {
		case '+':	return num1 + num2;
		case '-':	return num1 - num2;
		case '*':	return num1 * num2;
		case '%':	return num1 % num2;
		case '/':	return num1 / (double)num2;
		}
		//산술 연산자가 아닌 경우. 아직은 예외처리를 안배워서 0으로 리턴
		//그래서 0이 리턴되는 경우 1-1인지, 1*0인지, 4%2인지, 0/2인지, 잘못된 연산자 때문인지 구분이 안됨
		return 0;
		
	}

}
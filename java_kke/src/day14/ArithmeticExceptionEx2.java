package day14;

import java.text.MessageFormat;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {

	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 두 정수와 산술연산자를 입력받아 결과를 출력하는 메서드를 구현하세요.
		// 메서드를 이용, throws와 throw를 이용
		
		System.out.print("두 정수와 산술연산자를 입력해주세요.(예 : 1 + 2) : ");
		try {
			int num1 = scan.nextInt();
			char opr = scan.next().charAt(0);
			int num2 = scan.nextInt();
			double res = calculate(num1, opr, num2);
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1,opr,num2,res));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static double calculate(int num1, char opr, int num2)
		throws RuntimeException {
		switch(opr) {
		case '+':	return num1 + num2;
		case '-':	return num1 - num2;
		case '*':	return num1 * num2;
		case '%':	
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return num1 % num2;
		case '/':	
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return num1 / (double)num2;
		default:
			throw new RuntimeException(opr + "는 산술 연산자가 아닙니다.");
		}
		//산술 연산자가 아닌 경우. 아직은 예외처리를 안배워서 0으로 리턴
		//그래서 0이 리턴되는 경우 1-1인지, 1*0인지, 4%2인지, 0/2인지, 잘못된 연산자 때문인지 구분이 안됨		
	}

}

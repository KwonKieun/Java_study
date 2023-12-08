package day01;

public class VariableEx4 {
	//논리형 변수 선언 예제
	public static void main(String[] args) {
		boolean isEven = true;
		System.out.println(isEven);
		//아래 코드는 논리형 변수가 어떤식으로 사용되는지 보여주는 예제
		isEven = 3 % 2 == 0;
		System.out.println("is Even number? " + isEven);
	}
}

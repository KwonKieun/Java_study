package day02;

public class IfElseEx1 {

	// if else 예제
	public static void main(String[] args) {
		// 정수가 0이면 0이라고 출력하고, 아니면 0이 아닙니다라고 출력하는 예제
		int num = 10;
		
//		if(num이 0과 같다) {
//			0이라고 출력;
//		}else {
//			0이 아닙니다라고 출력;
//		}
		
		// if를 두 번 쓰면 무조건 2번 확인
		// if else를 쓰면 num이 0이면 1번 확인, num이 0이 아니면 2번 확인
		if(num == 0) {
			System.out.println("0입니다.");
		}else {
			System.out.println(num + "는 0이 아닙니다.");
		}

	}

}

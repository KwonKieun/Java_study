package day03;

public class WhileMultipleTableEx1 {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하는 코드를 작성하세요.
		 * ex)
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * ...
		 * 2 X 9 = 18
		 * 반복횟수	: i가 1부터 9까지 1씩 증가
		 * 규칙성		: 2 X i = 2*i 을 콘솔에 출력
		 * 반복문종료후 : 없음
		 */
		
		int n = 2;
		int i = 1;
		while(i <= 9) {
			System.out.println(n + " X " + i + " = " + n * i);
			i++;
		}

	}

}

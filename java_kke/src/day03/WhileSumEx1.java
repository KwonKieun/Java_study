package day03;

public class WhileSumEx1 {

	public static void main(String[] args) {
		/* 1부터 5까지의 합을 구하는 코드를 작성하세요.
		 * 반복횟수	: i는 1부터 5까지 1씩 증가
		 * 규칙성		: sum = sum + i
		 * 반복문종료후 : sum을 출력
		 */

		int i = 1;
		int num = 5;
		int sum = 0;
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}

}

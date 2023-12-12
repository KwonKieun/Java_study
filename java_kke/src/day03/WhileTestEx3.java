package day03;

public class WhileTestEx3 {

	public static void main(String[] args) {
		/* 1에서 10사이의 모든 짝수를 순서대로 출력하는 코드를 작성하세요.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * 방법1 
		 * 반복횟수	: i는 2부터 10까지 2씩 증가
		 * 규칙성		: i를 출력
		 * 
		 * 방법2
		 * 반복횟수	: i는 1부터 10까지 1씩 증가
		 * 규칙성		: i가 짝수이면 i를 출력
		 * 
		 * 방법3
		 * 반복횟수	: i는 1부터 5까지 1씩 증가
		 * 규칙성		: 2*i를 출력
		 */

		int num = 10;
		// 방법1
		int j = 2;
		while(j <= num) {
			System.out.println(j);
			j += 2;
		}
		
		
		// 방법2
		int i = 1;
		while(i <= num) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		// 방법3
		int k = 1;
		while(k <= num/2) {
			System.out.println(2*k);
			k++;
		}
		
	}

}

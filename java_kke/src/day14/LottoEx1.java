package day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoEx1 { //틀린 부분 많음....

	public static void main(String[] args) {
		/* 랜덤으로 당첨 번호를 생성하고, 사용자가 로또 번호를 입력하면 등수를 알려주는 코드를 작성하세요.
		 * 단, 컬렉션을 이용
		 * 당첨번호 : 6개, 보너스 : 1개
		 * 사용자 : 6개
		 * 번호 범위 : 1~45
		 */
		Scanner scan = new Scanner(System.in);
		int count = 6;
		
		Set<Integer> set = new HashSet<Integer>();
		int min = 1, max = 45;
		Random random = new Random();
		
		while(set.size() < 6) {
			int tmp = random.nextInt(max - min + 1) + min;
			set.add(tmp);
		}
		//System.out.println(set);
		
		//보너스 번호
		int bonusNum;
		while(true) {
			bonusNum = random.nextInt(max - min + 1) + min;
			if(!set.contains(bonusNum)) {
				break;
			}
		}
		
		Iterator<Integer> it = set.iterator();
		
		System.out.print("당첨 번호 : ");
		while(it.hasNext()) {
			int tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println("+ " + bonusNum);
		
		Set<Integer> user = new HashSet<Integer>();
		System.out.print("입력번호 : ");
		for(int i = 0; i < count; i++) {
			int tmp = scan.nextInt();
			user.add(tmp);
		}
		//System.out.println(user);
		
		
		
		
		
		//당첨 개수 확인(이중 반복문)
		int sameCount = 0;
		for(int tmp : set) {
			for(int i : user) {
				if(tmp == i || user.contains(bonusNum)) {
					sameCount++;
				}
			}
		}
		
		//당첨 개수에 따른 등수를 출력
		switch(sameCount) {
		case 6:
			System.out.println("1등!");
			break;
		case 5:
			//사용자가 입력한 번호에 보너스와 일치하는 번호가 있는지 확인
			int i = 0;
			for(int tmp : user) {
				if(bonusNum == tmp) {
					break;
				}
				i++;
			}
			//보너스번호와 일치하는 번호가 없으면
			if(i == user.size()) {
				System.out.println("3등!");
			}else {
				System.out.println("2등!");
			}
			break;
		case 4:
			System.out.println("4등!");
			break;
		case 3:
			System.out.println("5등!");
			break;
		default:
			System.out.println("꽝!");
		}
		
	}

}

package day17;

public class ThreadEx1 {

	public static void main(String[] args) {
		//싱글 스레드로 - 출력 후 + 출력
		for(int i = 0; i < 2000; i++) {
			System.out.print("-");
		}
		for(int i = 0; i < 2000; i++) {
			System.out.print("+");
		}
		System.out.println();
		
		//멀티 스레드로 스레드1은 - 출력, 스레드2는 + 출력
		Thread1 t1 = new Thread1();
		t1.start();
		
		//Thread2 tmp = new Thread2();
		//Thread t2 = new Thread(tmp);
		Thread t2 = new Thread(new Thread2());
		t2.start();
		
	}

}

class Thread1 extends Thread{
	
	@Override
	public void run() {
		for(int i = 0; i < 2000; i++) {
			System.out.print("-");
		}
	}
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 2000; i++) {
			System.out.print("+");
		}
	}
	
}
package day11.homework;

public class HomeworkEx3 {

	public static void main(String[] args) {
		/* 사이트에서 회원 관리(로그인, 회원가입 등)를 위한 Member 클래스를 작성하세요.*/
		
		//작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현한 메서드를 테스트해보세요.
		Member mem = new Member();
		
		//로그인 실패
		mem.login("kke0515", "kk1234");
		//로그인
		mem.login("kke0515", "Kieun1234!!");
		//로그아웃
		mem.signInOut();
		//회원가입 실패
		mem.signUp("kii1", "kk1234", 20010101);
		mem.signUp("kii1234", "kk", 20010101);
		mem.signUp("kii1234", "kk1234", 010101);
		//회원가입
		mem.signUp("kii1234", "kk1234", 20010101);
		
	}

}
class Member{
	//필요한 멤버변수 및 메서드를 정리하고 구현하세요.
	
	/* 회원 관리
	 * 로그인
	 * - 아이디, 비밀번호
	 * 회원가입
	 * - 아이디, 비밀번호, 생년월일
	 * 로그인/로그아웃
	 */
	String id;
	String pw;
	int birth;
	String email;
	boolean loginout;
	
	
	//로그인
	public void login(String id, String pw) {
		if(id == "kke0515" && pw == "Kieun1234!!") {
			signInOut();
		}else {
			System.out.println("아이디/비밀번호가 잘못 입력되었습니다.");
		}
	}
	
	//회원가입
	public void signUp(String id, String pw, int birth) {
		if(id.length() < 5) {
			System.out.println("아이디는 5자리 이상으로 생성해주세요.");
			return;
		}
		if(pw.length() < 5) {
			System.out.println("비밀번호는 5자리 이상으로 생성해주세요.");
			return;
		}
		if((int)(Math.log10(birth)+1) != 8) {
			System.out.println("생년월일은 20230101와 같이 8자리로 입력해주세요.");
			return;
		}
		System.out.println("회원가입이 완료되었습니다.");
		return;
	}
	
	//로그인/로그아웃
	//로그인 되어있으면 로그아웃, 로그아웃 상태이면 로그인
	public void signInOut() {
		loginout = !loginout;
		if(loginout) {
			System.out.println("로그인이 완료되었습니다.");
		}else {
			System.out.println("로그아웃이 완료되었습니다.");
		}
	}
}
package day11.homework;

public class Subject_A {
	// 과목명, 총점
	private String title;
	private int score;
	
	//getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//총점을 수정하는 메서드 : setScore와 같은 기능
	public void updateScore(int score) {
		setScore(score);
	}
	//과목 정보를 출력하는 메서드
	public void print() {
		System.out.println("과목명 : " + title + ", 점수 : " + score);
	}
	public boolean equals(String title) {
		if(this.title == null) {
			return false;
		}
		return this.title.equals(title);
	}
	//과목명, 성적이 주어진 생성자, 과목명만 주어진 생성자
	public Subject_A(String title, int score) {
		this.title = title;
		this.score = score;
	}
	public Subject_A(String title) {
		this.title = title;
	}
	
}
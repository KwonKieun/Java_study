package day11.homework;

public class Subject_H {
	// 어려운 버전 : 과목별 성적(중간, 기말, 수행평가, 총점), 학생번호

	double korMiddleScore;
	double korFinalScore;
	double korPeScore;
	double korSumScore;
	double engMiddleScore;
	double engFinalScore;
	double engPeScore;
	double engSumScore;
	double mathMiddleScore;
	double mathFinalScore;
	double mathPeScore;
	double mathSumScore;
	int studentNum;
	
	
	public double getKorMiddleScore() {
		return korMiddleScore;
	}




	public void setKorMiddleScore(double korMiddleScore) {
		this.korMiddleScore = korMiddleScore;
	}




	public double getKorFinalScore() {
		return korFinalScore;
	}




	public void setKorFinalScore(double korFinalScore) {
		this.korFinalScore = korFinalScore;
	}




	public double getKorPeScore() {
		return korPeScore;
	}




	public void setKorPeScore(double korPeScore) {
		this.korPeScore = korPeScore;
	}




	public double getEngMiddleScore() {
		return engMiddleScore;
	}




	public void setEngMiddleScore(double engMiddleScore) {
		this.engMiddleScore = engMiddleScore;
	}




	public double getEngFinalScore() {
		return engFinalScore;
	}




	public void setEngFinalScore(double engFinalScore) {
		this.engFinalScore = engFinalScore;
	}




	public double getEngPeScore() {
		return engPeScore;
	}




	public void setEngPeScore(double engPeScore) {
		this.engPeScore = engPeScore;
	}




	public double getMathMiddleScore() {
		return mathMiddleScore;
	}




	public void setMathMiddleScore(double mathMiddleScore) {
		this.mathMiddleScore = mathMiddleScore;
	}




	public double getMathFinalScore() {
		return mathFinalScore;
	}




	public void setMathFinalScore(double mathFinalScore) {
		this.mathFinalScore = mathFinalScore;
	}




	public double getMathPeScore() {
		return mathPeScore;
	}




	public void setMathPeScore(double mathPeScore) {
		this.mathPeScore = mathPeScore;
	}




	public int getStudentNum() {
		return studentNum;
	}




	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}




	public void printInfo() {
		korSumScore = korMiddleScore + korFinalScore + korPeScore;
		engSumScore = engMiddleScore + engFinalScore + engPeScore;
		mathSumScore = mathMiddleScore + mathFinalScore + mathPeScore;
		System.out.println("---------------");
		System.out.println("번호 : " + studentNum);
		System.out.println("국어중간 : " + korMiddleScore);
		System.out.println("국어기말 : " + korFinalScore);
		System.out.println("국어수행 : " + korPeScore);
		System.out.println("국어총점 : " + korSumScore);
		System.out.println("영어중간 : " + engMiddleScore);
		System.out.println("영어기말 : " + engFinalScore);
		System.out.println("영어수행 : " + engPeScore);
		System.out.println("영어총점 : " + engSumScore);
		System.out.println("수학중간 : " + mathMiddleScore);
		System.out.println("수학기말 : " + mathFinalScore);
		System.out.println("수학수행 : " + mathPeScore);
		System.out.println("수학총점 : " + mathSumScore);
	}
	
	
}

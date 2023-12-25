package day11.homework;

public class Subject {
	// 과목별 점수, 총점, 학생번호
	
	double kor, eng, math;
	double sumScore;
	int studentNum;

	public double getKor() {
		return kor;
	}


	public void setKor(double kor) {
		this.kor = kor;
	}


	public double getEng() {
		return eng;
	}


	public void setEng(double eng) {
		this.eng = eng;
	}


	public double getMath() {
		return math;
	}


	public void setMath(double math) {
		this.math = math;
	}


	public double getSumScore() {
		return sumScore;
	}


	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}


	public int getStudentNum() {
		return studentNum;
	}


	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}


	public void printInfo() {
		sumScore = kor + eng + math;
		System.out.println("---------------");
		System.out.println("번호 : " + studentNum);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + sumScore);
	}
	
}

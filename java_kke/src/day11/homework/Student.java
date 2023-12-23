package day11.homework;

public class Student {
	// 이름, 학년, 반, 번호
	
	private String name;
	private int grade;
	private int classnum;
	private int num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Student(int grade, int classnum, int num, String name) {
		this.grade = grade;
		this.classnum = classnum;
		this.num = num;
		this.name = name;
	}
	
	public void print() {
		System.out.println(grade + " " + classnum + " " + num + " " + name);
	}
	
	public boolean equals(String name) {
		return this.name.equals(name);
	}
	
	public void update(int grade, int classnum, int num, String name) {
		this.grade = grade;
		this.classnum = classnum;
		this.num = num;
		this.name = name;
	}
}

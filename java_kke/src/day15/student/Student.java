package day15.student;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor //반드시 필요한 매개변수들 이용해서 생성자 만듦
public class Student {
	//학년, 반, 번호, 이름, 국어, 영어, 수학 성적
	@NonNull
	private int grade, classNum, num;
	@NonNull
	private String name;
	private int kor, eng, math;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
	
}

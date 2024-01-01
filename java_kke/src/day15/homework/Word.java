package day15.homework;

import java.util.ArrayList;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Word {
	// 단어, 품사, 뜻(리스트)
	@NonNull
	private String word, PoS, meaning;
	private ArrayList<String> means = new ArrayList<String>();
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return this.word.equals(other.word);
	}
	@Override
	public int hashCode() {
		return Objects.hash(word, PoS);
	}
	
//	public Word(String word, String PoS, String meaning) {
//		this.word = word;
//		this.PoS = PoS;
//		means.add(meaning);
//	}
	
	public void addMean(String meaning) {
		means.add(meaning);
		System.out.println("뜻 추가--");
	}
	
	public void delMean(String meaning) {
		means.remove(meaning);
		System.out.println("뜻 삭제--");
	}
	
	public int meansLen() {
		return this.means.size();
	}


}

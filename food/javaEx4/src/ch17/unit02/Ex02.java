package ch17.unit02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("X", "A", "T", "B", "A", "V", "T", "A", "C", "K");
		
		// 중복제거 출력
		/*
		for(int i =0; i<list.size(); i++) {
			if(list.indexOf(list.get(i)) == i) {
				System.out.print(list.get(i) + " ");
			}
		}
		System.out.println();
		*/
		
		Stream<String> stream = list.stream();
		
		stream.distinct() // 중간연산(중복제거)
			.sorted() // 중간연산(정렬)
			.limit(3) // 중간연산(주어진 숫자만큼 스트림)
			.forEach(System.out::println); // 최종연산
		
		// 최종 연산은 스트림 요소를 모두 소모하므로 단 한번만 가능하다.
		// stream.forEach(System.out::println); // 에러
		
		
	}

}

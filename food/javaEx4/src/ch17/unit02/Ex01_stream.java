package ch17.unit02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 	- stream
 		: 컬렉션(List, Set 등)의 요소들을 선언적이고 함수형 스타일로 처리할 수 있게 한다.
 		: 스트림은 데이터의 흐름(연속된 데이터 처리)을 나타낸다.
 		: 컬렉션 자체를 변경하지 않고 그 데이터를 필터링, 매핑, 정렬등의 연산을 통해 가공
 		: 내부 반복을 통해 성능 및 병렬 처리에 유리
 		: 중간 연산은 실제 실행되지 않고 최종 연산만 수행(지연연산)
 		: 한번 사용한 스트림은 다시 사용할 수 없다.
 */

public class Ex01_stream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C");
		
		// 컬력션 사용
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		// 스트림 사용
		Stream<String> stream = list.stream();
		stream.forEach(System.out::print); // 메서드 참조
		// stream.forEach(s - > System.out.print(s)); // 람다식
		System.out.println();
	}

}

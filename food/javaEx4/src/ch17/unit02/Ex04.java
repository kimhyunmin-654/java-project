package ch17.unit02;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04 {

	public static void main(String[] args) {
		// 스트림 중간 연산
		
		IntStream s1 = IntStream.range(0,10); // 0~9
		// skip(n) : 처음부터 n개 만큼 제외
		s1.skip(4).forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		IntStream s2 = IntStream.range(0,10); // 0~9
		// limit(n) : 처음부터 n개 만큼의 요소
		s2.limit(4).forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		IntStream s3 = IntStream.range(0,10); // 0~9
		s3.skip(3).limit(4).forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		IntStream s4 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
		// 중복제거
		s4.distinct().forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		IntStream s5 = IntStream.of(7,5,5,2,1,2,3,5,4,6);
		// filter() : 주어진 조건에 맞는 요소로 구성된 스트림
		s5.filter(n -> n%2 != 0).forEach(n -> System.out.print(n + " "));
			// 홀수만 출력
		System.out.println();
		
		Stream<String> s7 = Stream.of("html", "css", "java", "javascript");
		s7.sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		Stream<String> s8 = Stream.of("html", "css", "java", "javascript");
		// 입력 T 타입 요소를 R 타입 요소로 변환한 새로운 스트림
		s8.map(s -> s.length()).forEach(n -> System.out.print(n + ""));
		System.out.println();
		
		Stream<String> s9 = Stream.of("html css", "c spring java");
		// flatMap() : T 타입의 요소를 1:N의 R타입 요소로 변환하여 새로운 스트림 반환
		s9.flatMap(s -> Stream.of(s.split("\\s"))).forEach(System.out::println);
		
		
	}

}

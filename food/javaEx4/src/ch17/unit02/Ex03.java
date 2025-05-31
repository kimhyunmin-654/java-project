package ch17.unit02;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03 {

	public static void main(String[] args) {
		// 스트림 생성 방법
		
		// 컬렉션에서 스트림 생성
		List<String> list = Arrays.asList("A", "B", "C");
		Stream<String> s = list.stream();
		s.forEach(System.out::print);
		System.out.println();
		
		// 배열에서 스트림 생성
		String[] ss = new String[]{"X", "Y", "Z"};
		Stream<String> s2 = Stream.of(ss);
		s2.forEach(System.out::print);
		System.out.println();
		
		// 특정 범위의 수에서 스트림 생성
		// IntStream s3 = IntStream.range(1, 6); // end 범위 미포함
		IntStream s3 = IntStream.rangeClosed(1, 5); // end 범위 포함
		s3.forEach(System.out::print);
		System.out.println();
		
		// 난수에서의 스트림 생성
		IntStream s4 = new Random().ints(); // 무한 스트림
		s4.limit(5).forEach(System.out::println);
		System.out.println();
	
		IntStream s5 = new Random().ints(5, 1, 10); // 1~9 사이의 난수를 5개 출력
		s5.forEach(System.out::println);
		System.out.println();
		
		// iterate(seed, f) 
		// : seed 부터 람다식(f)에 의해 계산 결과를 다시 seed로 해서 반복
		Stream<Integer> s6 = Stream.iterate(0, n -> n + 2);
							// 0부터 짝수, 무한 스트림
		s6.limit(5).forEach(System.out::println);
		
		// generate(f) 
		// : 람다식에 의해 계산된 값을 요소로 반복. iterate() 처럼 이전 결과를 계산에 사용하지 않음
		Stream<Double> s7 = Stream.generate(Math::random);
						// 난수. 무한 반복
		s7.limit(5).forEach(System.out::println);
		System.out.println();
		
		// 스트림 결합
		Stream<String> s8 = Stream.of(new String[] {"A", "B", "C"});
		Stream<String> s9 = Stream.of(new String[] {"X", "Y", "Z"});
		//Stream<String> s10 = 
		
		
				
	}

}

package ch17.unit01;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class Ex08 {

	public static void main(String[] args) {
		// 표준 API로 제공하는 함수적 인터페이스
		
		// 매개변수가 있고, 리턴값이 void 인 추상메서드를 가진 함수적인터페이스
		Consumer<Long> c = a -> System.out.println(a);
		c.accept(100L);
		
		// 매개변수가 없고, 리턴값이 있는 추상메서드를 가진 함수적인터페이스
		IntSupplier i = () -> (int) (Math.random() * 10) + 1;
		int n = i.getAsInt();
		System.out.println("1~100사이 난수:" + n);
		
		// 두개의 매개변수가 있고, 리턴값이 void 인 추상메서드를 가진 함수적 인터페이스
		BiConsumer<String, String> b = (t, u) -> System.out.println(t + u);
		b.accept("java", "24");
		
		// 매개변수가 없고, 리턴값이 String 인 경우 
		Supplier<String> s = () -> "java";
		String str = s.get();
		System.out.println(str);
		
		// Function(T, R) : 매개변수(T)가 있고 리턴값(R)이 있는 경우
		Function<String, Integer> f = a -> Integer.parseInt(a);
		n = f.apply("100");
		System.out.println(n);

		
		
	
	}

}

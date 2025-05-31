package ch08.unit10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Ex03 {

	public static void main(String[] args) {
		ExService es = new ExService();
		es.sub();
		System.out.println();
		
		// ExService 클래스의 메서드 정보를 얻는다.
		Method[] mm = ExService.class.getDeclaredMethods();
		
		// 메서드를 하나씩 처리
		for(Method m : mm) {
			
			// PrintAnnotation 이 적용된 메서드
			if(m.isAnnotationPresent(PrintAnnotation.class)) {
				// PrintAnnotation 객체 얻기
				PrintAnnotation pa = m.getAnnotation(PrintAnnotation.class);
				
				// 메서드이름 출력
				System.out.println("[" + m.getName() + "]");
				// 구분선 출력
				for(int i =1; i< pa.number(); i++) {
					System.out.print(pa.value());
				}
				System.out.println();
			}
			
			// 메서드 호출
			try {
				m.invoke(es);
			} catch (Exception e) {

			}
			System.out.println();
		}
	}

}

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface PrintAnnotation {
	// 어노테이션 속성 설정
	public String value() default "-";
	public int number() default 15;
}

class ExService {
	public void fun() {
		System.out.println("fun - 실행 내용");
	}
	
	@PrintAnnotation
	public void sub() {
		System.out.println("실행 내용 1");
	}
	
	@PrintAnnotation("*")
	public void sub2() {
		System.out.println("실행 내용 2");
	}
	
	@PrintAnnotation(value = "#", number = 20)
	public void sub3() {
		System.out.println("실행 내용 3");
	}
}


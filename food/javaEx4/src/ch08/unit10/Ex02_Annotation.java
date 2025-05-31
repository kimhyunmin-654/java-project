package ch08.unit10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Ex02_Annotation {

	public static void main(String[] args) {
		TestService ts = new TestService();
		ts.execute();
	}

}

// 사용자 정의 에노테이션
@Target(ElementType.METHOD) // 어노테이션을 적용할 티켓 설정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션의 유지 시점 설정
@interface MyAnnotation {
	
}

class TestService {
	@MyAnnotation
	public void execute() {
		System.out.println("어노테이션 생성 예제...");
	}
}
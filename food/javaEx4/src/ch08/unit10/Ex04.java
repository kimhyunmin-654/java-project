package ch08.unit10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Ex04 {
	public static void main(String[] args) {
		try {
			MyContainer mc = new MyContainer();
			
			UserVO vo = mc.get(UserVO.class);
			
			
			System.out.println(vo.getSubject()); // 스프링
			System.out.println(vo.getDefaultValue()); // 자바
			System.out.println(vo.getPrice()); // 0
			
			
		} catch (Exception e) {

		}
	}
}

// 필드에 어노테이션 설정 
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyData {
	public String value() default "자바";
}

class UserVO {
	@MyData("스프링")
	private String subject;
	@MyData
	private String defaultValue;
	@MyData
	private int price;
	
	public String getSubject() {
		return subject;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public int getPrice() {
		return price;
	}
	
}

class MyContainer {
	// IllegalAccessException : 리플렉션에서 허용되지 않은 클래스 필드나 메서드 접근시 발생하는 예외
	private <T> T invokeAnnotations(T t) throws IllegalAccessException {
		// 어노테이션이 있는 필드의 값을 어노테이션 속성값으로 설정
		
		Field[] ff = t.getClass().getDeclaredFields();
		try {
			for(Field f : ff) {
				MyData md = f.getAnnotation(MyData.class);
				
				if(md != null && f.getType() == String.class) {
					// 리플렉트된 private 필드나 메서드를 호출 가능하도록 설정
					f.setAccessible(true);
					
					// 필드값 변경
					f.set(t, md.value());
				}
			}
			
		} catch (IllegalAccessException e) {
			throw e;
		}
		
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Class<?> cls) throws Exception {
		T t = null;
		
		try {
			// 객체 생성
			Constructor<?> con = cls.getDeclaredConstructor();
			t = (T)con.newInstance();
			
			// 어노테이션이 있는 필드의 값을 어노테이션 속성값으로 설정
			t = invokeAnnotations(t);
		} catch (Exception e) {
			throw e;
		}
		
		return t;
	}
	
}

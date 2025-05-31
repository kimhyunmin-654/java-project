package ch17.unit01;

import java.util.ArrayList;
import java.util.List;

public class Ex15 {

	public static void main(String[] args) {
		List<Test5> list = new ArrayList<Test5>();
		
		// 람다식
		PersonFactory<Test5> f = (a, b) -> new Test5(a,b);
		list.add(f.create("이자바", 20));
		
		// 생성자 메서드 참조
		PersonFactory<Test5> f2 = Test5::new;
		list.add(f2.create("김자바", 22));
		list.add(f2.create("다자바", 21));
		
		for(Test5 o : list) {
			System.out.println(o.getName() + ", " + o.getAge());
		}
	}
}

class Test5 {
	private String name;
	private int age;
	
	public Test5() { 
	}
	
	public Test5(String name) {
		this(name, 0);
	}
	
	public Test5(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

@FunctionalInterface
interface PersonFactory<T> {
	public T create(String name, int age);
}




package ch17.unit02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex05 {

	public static void main(String[] args) {
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이자바", 22));
		list.add(new UserVO("다자바", 17));
		list.add(new UserVO("너자바", 19));
		list.add(new UserVO("하자바", 22));
		list.add(new UserVO("구자바", 20));
		list.add(new UserVO("상자바", 21));
		list.add(new UserVO("홍자바", 16));
		
		// 성인만 필터링하여 나이순 정렬하여 List 객체에 저장
		List<UserVO> list2 = new ArrayList<UserVO>();
		Stream<UserVO> stream = list.stream();
		
		// stream.filter(vo -> vo.getAge() >= 19).sorted().forEach(list2::add);
		stream.filter(vo -> vo.getAge() >= 19).sorted().map(list2::add).toList();
		list2.stream().forEach(System.out::println);
		System.out.println();
		
		// 이름만 가져와서 리스트로 만들기
		List<String> names = list.stream()
				.map(vo -> vo.getName())
				.sorted()
				.collect(Collectors.toList());
		for(String s : names) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		
	}

}

class UserVO implements Comparable<UserVO> {
	private String name;
	private int age;
	
	public UserVO() {	
	}
	public UserVO(String name, int age) {
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
	
	@Override
	public String toString() {
		return name + " : " + age;
	}
	
	@Override
	public int compareTo(UserVO o) {
		return age - o.getAge();
	}
	
	

	
}

package ch17.unit01;

public class Ex07 {

	public static void main(String[] args) {
		// 람다매개변수에 대한 지역변수 추론(var)
		// User7 obj = (var f, var l) -> f + l;
		User7 obj = (f, l) -> f + l;
		
		String s = obj.fun("a", "b");
		System.out.println(s);
	}

}

interface User7 {
	public String fun(String first, String last);
}
package ch15.unit01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex03_ObjectStream {

	public static void main(String[] args) {
		String pathname = "obejct2.txt";
		
		/*
		   - 직렬화 : 자바객체를 파일에 저장하거나 네트워크로 송수신 가능하도록 바이트 형식으로 변환하는 작업
		   - 직렬화 가능한 객체만 ObjectOutputStream 으로 저장 가능
		     writeObject() : 바이트형식으로 직렬화 하여 저장
		   - Serializable 인터페이스 구현 클래스만 직렬화 가능
		 */
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathname))) {
			oos.writeObject(new User("김자바", "010-111", 20));
			oos.writeObject(new User("이자바", "010-222", 21));
			oos.writeObject(new User("다자바", "010-333", 19));
			
			System.out.println("파일 저장 완료...");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		  - ObjectInputStream 
		    : ObjectInputStream 에 의해 저장된 데이터를 읽어 복원하는 역할을 함
		  - readObject() 메소드
		    : 직렬화된 객체를 읽어 복원
		  - 더이상 읽을 데이터가 없으면 EOFException 예외가 발생
		 */
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathname))) {
			System.out.println("\n파일 내용");
			
			while(true) {
				User vo = (User)ois.readObject();
				System.out.println(vo.getName() + ":" + vo.getTel() + ":" + vo.getAge());
			}
			
		} catch (EOFException e) {
			// ObjectInputStream에서 더이상 읽을 자료가 없으면 EOFException 예외발생
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
// Serializable : 객체를 직렬화 가능하도록 설정
// 직렬화 대상에서 제외 되는 것 : 메소드, static 변수, transient 변수
class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String tel;
	private int age;
	
	public User() {
		
	}
	
	public User(String name, String tel, int age) {
		this.name = name;
		this.tel = tel;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

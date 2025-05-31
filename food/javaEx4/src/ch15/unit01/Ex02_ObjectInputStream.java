package ch15.unit01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_ObjectInputStream {

	public static void main(String[] args) {
		String pathname = "object.txt";
		
		// ObjectOutputStream 에 의해 저장된 내용을 원래 객체 형태로 복원하여 입력 받는다.
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathname))) {
			
			@SuppressWarnings("unchecked")
			Hashtable<String, String> ht = (Hashtable<String, String>)ois.readObject();
			
			Iterator<String> it = ht.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				String value = ht.get(key);
				
				System.out.println(key + " : " + value);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

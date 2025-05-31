package ch16.unit01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Ex02_HtmlViewer {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String host, s;
		
		BufferedReader wbr = null;
		
		try {
			System.out.print("웹주소[https://www.naver.com] ? ");
			host = br.readLine();
			
			// URL : 웹상의 리소스에 대한 포인트
			// URL url = new URL(host); // JDK 20 deprecated
			URL url = URI.create(host).toURL(); // JDK 20이상
			InputStream is = url.openStream();
			wbr = new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			while((s = wbr.readLine()) != null) {
				System.out.println(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(wbr != null) {
				try {
					wbr.close();
				} catch (Exception e2) {

				}
			}
		}
		
	}

}

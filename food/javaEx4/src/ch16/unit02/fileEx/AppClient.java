package ch16.unit02.fileEx;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class AppClient {
	private Socket sc = null;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static final String HOST_NAME = "127.0.0.1";
	public static final int BIND_PORT = 7777;
	public static final int BUFFER_SIZE = 8192;
	
	private boolean createConnection() {
		try {
			
			sc = new Socket(HOST_NAME, BIND_PORT);
			System.out.println("서버 접속 !!!");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void sendFile() {
		String pathname = null;
		File file = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			System.out.print("전송할 파일명 ? ");
			pathname = br.readLine();
			
			file = new File(pathname);
			if(! file.exists() || ! file.isFile()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}
			
			if(! createConnection()) {
				System.out.println("서버 접속이 실패했습니다.");
				return;
			}
			
			// 클라이언트 -> 서버 : 파일명, 파일크기, 파일내용 순으로 전송
			byte[] buf = new byte[BUFFER_SIZE];
			
			// 파일의 내용을 읽을 입력 스트림
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			// 파일의 내용을 전송할 소켓 출력
			dos = new DataOutputStream(sc.getOutputStream());
			
			// 파일이름 보내기
			dos.writeUTF(file.getName());
			dos.flush();
			
			// 파일크기 보내기
			dos.writeLong(file.length());
			dos.flush();
			
			int read = 0;
			long passedlen = 0;
			long length = file.length();
			
			// 파일내용 보내기
			while((read = dis.read(buf)) != -1) {
				passedlen += read;
				System.out.println("File [" + file.getName() + "] " + (passedlen * 100L/length) + "% 전송...");
				
				dos.write(buf,0, read);
			}
			dos.flush();
			
			System.out.println("파일 전송 완료 !!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch (Exception e2) {
			}
			
			try {
				if(dis != null) {
					dis.close();
				}
			} catch (Exception e2) {
			}
			
			try {
				if(sc != null) {
					sc.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	
	public static void main(String[] args) {
		new AppClient().sendFile();
	}

}

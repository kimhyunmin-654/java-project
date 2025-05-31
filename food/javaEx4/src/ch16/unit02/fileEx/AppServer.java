package ch16.unit02.fileEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServer implements Runnable {
	private ServerSocket ss = null;
	private Socket sc = null;
	
	public static final String RECEIVE_FILE_PATH = "C:" + File.separator + "receive";
	public static final int BIND_PORT = 7777;
	public static final int BUFFER_SIZE = 8192;
	
	
	public static void main(String[] args) {
		AppServer obj = new AppServer();
		obj.serverStart();
	}
	
	public void serverStart() {
		try {
			ss= new ServerSocket(BIND_PORT);
			System.out.println("서버 시작 !!!\n");
			
			sc = ss.accept();
			
			// 스레드 시작
			Thread t = new Thread(this);
			t.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// 클라이언트 -> 서버 : 파읾명, 파일크기, 파일 내용 순으로 전송
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			File f = new File(RECEIVE_FILE_PATH);
			if(! f.exists()) {
				f.mkdirs();
			}
			
			// 클라이언트가 보낸 정보를 받을 입력 스트림
			dis = new DataInputStream(new BufferedInputStream(sc.getInputStream()));
			
			// 파일이름 받기 
			String filename = dis.readUTF();
			String savePath = RECEIVE_FILE_PATH + File.separator + filename;
			
			// 파일크기 받기
			long length = dis.readLong();
			
			// 파일을 저장하기 위한 출력 스트림
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(savePath)));
			
			byte[] buf = new byte[BUFFER_SIZE];
			long passedlen = 0;
			int read = 0;
			
			System.out.println("파일 다운로드 시작 !!!");
			
			// 파일내용 받기
			while((read = dis.read(buf)) != -1) {
				passedlen += read;
				dos.write(buf, 0, read);
				
				System.out.println("File [" + filename + "] : " + (passedlen * 100L / length) + "% 다운...");  
			}
			System.out.println("파일 다운로드 완료 !!!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("파일 다운로드 실패 !!!");
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
}

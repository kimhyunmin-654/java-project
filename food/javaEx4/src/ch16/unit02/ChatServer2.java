package ch16.unit02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


// 1:다 채팅
public class ChatServer2 {
	private Vector<Socket> client = new Vector<>();
	private ServerSocket ss = null;
	private int port = 8000;
	
	public ChatServer2() {
		
	}
	
	// 내부 클래스
	class WorkerThread extends Thread {
		private Socket sc = null;
		
		public WorkerThread(Socket sc) {
			this.sc = sc;
		}
		
		// 다른 클라이언트에게 메시지 전송
		public void sendMsg(String msg) {
			for(Socket s : client) {
				if(s == sc) { // 자기 자신은 메시지를 보내지 않음
					continue;
				}
				
				try {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(msg);
				} catch (IOException e) {
					
				}
			}
		}
		
		@Override
		public void run() {
			String ip = null;
			String msg = null;
			
			try {
				// 접속한 클라이언트의 입력 스트림
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				ip = sc.getInetAddress().getHostAddress();
				
				// 클라이언트 소켓을 벡터에 저장
				client.add(sc);
				
				// 다른 클라이언트에게 접속 사실을 알림
				msg = "[" + ip + "] 입장 !!!";
				sendMsg(msg);
				
				System.out.println(msg);
				
				// 클라이언트가 보낸 정보 받음
				while((msg = br.readLine()) != null) {
					// 다른 클라이언트에게 보냄
					sendMsg(msg);
				}
				
			} catch (IOException e) {
				// 접속을 해제한 경우
				
				// 다른 클라이언트에게 접속 사실 알림
				msg = "[" + ip + "] 퇴장 !!!";
				sendMsg(msg);
				
				client.remove(sc);
				sc = null;
				
				System.out.println(msg);
			}
		}
		
	}
	
	public void serverStart() {
		try {
			ss = new ServerSocket(port);
			System.out.println("서버 시작...");
			
			while(true) {
				// 클라이언트가 접속하기를 기다린다.
				Socket sc = ss.accept();
				
				// 접속한 클라이언트 만큼 스레드가 만들어짐
				WorkerThread t = new WorkerThread(sc);
				t.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 	
	public static void main(String[] args) {
		new ChatServer2().serverStart();		
	}

}

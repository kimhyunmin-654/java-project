package ch16.unit02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 1:1 채팅
public class ChatServer extends JFrame implements ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	
	private JTextField tf = new JTextField();
	private JTextArea ta = new JTextArea();
	
	private ServerSocket ss = null;
	private int port = 8000;
	private Socket sc = null;
	
	public ChatServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);
		add(pane, BorderLayout.CENTER);
		

		tf.addActionListener(this);
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅-서버");
		setSize(500, 550);
		setResizable(false);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		cs.serverStart();
	}
	
	public void serverStart() {
		try {
			// 서버소켓 생성
			ss = new ServerSocket(port);
			ta.setText("서버 시작!!!\n");
			
			// 클라이언트 접속을 기다린다.
			sc = ss.accept();
			
			// 스레드 실행
			Thread t = new Thread(this);
			t.start();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String str;
		String ip = null;
		
		if(sc == null) {
			return;
		}
		
		try {
			// 클라이언트가 보낸 정보 닫기
			// : 접속한 클라이언트의 입력 스트림을 이용하여 정보를 받는다.
			// : sc.getInputStream() -> 접속한 클라이언트의 InputStream 객체
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			
			// 클라이언트의 IP 확인
			ip = sc.getInetAddress().getHostAddress();
			ta.append("[" + ip + "] 접속 !!!\n");
			
			// 클라이언트가 보낸 정보를 읽어온다.
			while((str = br.readLine()) != null) {
				ta.append(str + "\n");
			}
			
		} catch (IOException e) {
			// 클라이언트가 접속을 해제하면 IOException이 발생한다.
			str = "[" + ip + "] 접속 해제 !!!";
			ta.append(str+ "\n");
			sc = null;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == tf) {
			String s = tf.getText().trim();
			if(s.isEmpty()) { 
				return;
			}
			
			try {
				if(sc == null) {
					return;
				}
				
				// 클라이언트에게 정보를 보낸다.
				PrintStream ps = new PrintStream(sc.getOutputStream());
				ps.println("서버> " + s);
				
				ta.append("보냄> " + s + "\n");
				
				tf.setText("");
				tf.requestFocus();
			} catch (IOException e2) {
				// 클라이언트가 접속이 해제 되면 IOException이 발생
				ta.append("클라이언트가 나갔다.");
				sc = null;
				// e2.printStackTrace();
			}
		}
		
	}

}

package ch16.unit02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	private static final long serialVersionUID = 1L;
	
	private JTextField tf = new JTextField();
	private JTextArea ta = new JTextArea();
	
	private Socket sc = null;
	private String host = "127.0.0.1";
	private int port = 8000;
	private String nickName = "김현민";
	
	public ChatClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);
		add(pane, BorderLayout.CENTER);
		

		tf.addActionListener(this);
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅-클라이언트");
		setSize(500, 550);
		setResizable(false);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		new ChatClient().connect();
	}
	
	public void connect() {
		try {
			// 서버에 연결
			sc = new Socket(host, port);
			ta.setText("서버에 접속 !!!\n");
			
			Thread t = new Thread(this);
			t.start();
			
		} catch (IOException e) {
			// 서버가 죽어 있거나 접속 실패하면 IOException 발생
			sc = null;
			e.printStackTrace();
			
		}
	}

	@Override
	public void run() {
		String s;
		
		if(sc == null) {
			return;
		}
		
		try {
			// 서버에서 보낸 정보 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			
			while((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}
		} catch (Exception e) {
			// 서버가 종료된 경우 IOException 발생
			
			ta.append("서버가 종료되었습니다.\n");
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
				
				PrintStream ps = new PrintStream(sc.getOutputStream());
				ps.println(nickName + ">" + s);
				
				ta.append("보냄> " + s + "\n");
				
				tf.setText("");
				tf.requestFocus();
			} catch (IOException e2) {
				sc = null;
				e2.printStackTrace();
			}
		}
		
	}

}

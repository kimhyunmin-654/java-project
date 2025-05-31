package ch16.unit01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ex01_Swing extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
		
	public Ex01_Swing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Calendar cal = Calendar.getInstance();
				String s = String.format("%tF %tT", cal, cal);
				setTitle(s);
			}
		};
		
		Timer t = new Timer();
		t.schedule(task, new Date(), 1000);
		
		btn1 = new JButton("버튼1");
		add(btn1, BorderLayout.CENTER);
		btn1.addActionListener(this); // 이벤트등록
		
		btn2 = new JButton("버튼2");
		add(btn2, BorderLayout.WEST);
		
		btn3 = new JButton("버튼3");
		add(btn3, BorderLayout.EAST);
		
		btn4 = new JButton("버튼4");
		add(btn4, BorderLayout.NORTH);
		
		btn5= new JButton("버튼5");
		add(btn5, BorderLayout.SOUTH);
		
		
		//setTitle("스윙 예제");
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex01_Swing();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			JOptionPane.showMessageDialog(this, "안녕...");
		}
	}

}

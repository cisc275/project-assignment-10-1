package mainpkg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizView extends View {

	public JTextField Q;
	public JTextField blank; //For question Spacing
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
	
	public void startQuiz(int quiznum) {
		if (quiznum == 1) {
			
			Q = new JTextField("Q1", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q1A");
			B = new JButton("Q1B");
			C = new JButton("Q1C");
			D = new JButton("Q1D");
				
		}
		
		else if (quiznum == 2) {
			Q = new JTextField("Q2", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q2A");
			B = new JButton("Q2B");
			C = new JButton("Q2C");
			D = new JButton("Q2D");
		}
		
		else if (quiznum == 3) { 
			
			Q = new JTextField("Q3", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q3A");
			B = new JButton("Q3B");
			C = new JButton("Q3C");
			D = new JButton("Q3D");
		}
		
		
		JPanel panel = new JPanel(new GridLayout(0, 2));
		
		A.setFont(new Font("Arial", Font.PLAIN, 50));
		B.setFont(new Font("Arial", Font.PLAIN, 50));
		C.setFont(new Font("Arial", Font.PLAIN, 50));
		D.setFont(new Font("Arial", Font.PLAIN, 50));
		Q.setFont(new Font("Arial", Font.PLAIN, 24));
		
		
		panel.add(Q);
		panel.add(blank);
		panel.add(A);
		panel.add(B);
		panel.add(C);
		panel.add(D);
		
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
	
	
	
}

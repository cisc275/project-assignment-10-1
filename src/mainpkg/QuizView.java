package mainpkg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizView extends View {

	public JTextField Q;
	public JTextField blank; //For question Spacing
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
	public String Answer = "";
	
	public void changeAnswer(String Answer) {
		this.Answer = Answer;
	}
	
	public void startQuiz(int quiznum) {
		
		
		//Set Quizzes (I imagine all of our questions can be hardcoded here easily, just replace strings appropriately)
		
		if (quiznum == 1) { // Frogger game question
			
			Q = new JTextField("Q1", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q1A");
			B = new JButton("Q1B");
			C = new JButton("Q1C");
			D = new JButton("Q1D");
				
		}
		
		else if (quiznum == 2) { // Food game Question
			Q = new JTextField("Q2", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q2A");
			B = new JButton("Q2B");
			C = new JButton("Q2C");
			D = new JButton("Q2D");
		}
		
		else if (quiznum == 3) { // FlappyBird Question
			
			Q = new JTextField("Q3", 1);
			Q.setEditable(false);
			blank = new JTextField("",0);
			blank.setEditable(false);
			
			A = new JButton("Q3A");
			B = new JButton("Q3B");
			C = new JButton("Q3C");
			D = new JButton("Q3D");
		}
		
		//-----------------------------------------------
		
		//Add the actionlisteners in common to the buttons after assigning them their question/answer values 
		//based on the quiz #
		A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changeAnswer("A");
			}
		});

		B.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				changeAnswer("B");
			}
		});
		
		C.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				changeAnswer("C");
			}
		});

		D.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				changeAnswer("D");
			}
		});
		
		
		//Panel with a grid layout for buttons
		JPanel panel = new JPanel(new GridLayout(0, 2));
		
		
		//May want to change these sizes based on length of question/answers
		A.setFont(new Font("Arial", Font.PLAIN, 50));
		B.setFont(new Font("Arial", Font.PLAIN, 50));
		C.setFont(new Font("Arial", Font.PLAIN, 50));
		D.setFont(new Font("Arial", Font.PLAIN, 50));
		Q.setFont(new Font("Arial", Font.PLAIN, 50));
		
		//add everything to panel in this order so that the question is at the top
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

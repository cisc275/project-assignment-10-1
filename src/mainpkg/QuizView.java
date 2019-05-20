package mainpkg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class QuizView extends View {

	public JLabel Q;
	public JLabel wrong; //For question Spacing
	public JButton A;
	public JButton B;
	public JButton C;
	public JButton D;
	public String Answer = "";
	public JPanel panel;
	public JButton Save = new JButton("Save");
	
	public int BUTTON_WIDTH = frameWidth/5;
	public int BUTTON_HEIGHT = frameHeight/16;
	public int TOP_ROW = (frameHeight/2) - BUTTON_HEIGHT;
	public int BOTTOM_ROW = (frameHeight/2);
	public int LEFT_COL = (frameWidth/2) - BUTTON_WIDTH;
	public int RIGHT_COL = (frameWidth/2);
	
	
	public void changeAnswer(String Answer) {
		this.Answer = Answer;
	}
	
	public void startQuiz(int quiznum) {
		
		wrong = new JLabel("Wrong answer, please try again!");

		//Set Quizzes (I imagine all of our questions can be hardcoded here easily, just replace strings appropriately)
		
		
		//OSPREY QUESTIONS --------------------------------------
		if(isOsprey) {
		
		if (quiznum == 1) { // Frogger game question
			
			Q = new JLabel("What is a threat to Osprey while they migrate?");

			
			A = new JButton("Air traffic");
			B = new JButton("Foxes");
			C = new JButton("Predatory whales");
			D = new JButton("Deadly nightshade");
				
		}
		
		else if (quiznum == 2) { // Food game Question
			Q = new JLabel("What is the main diet of the Osprey?");

			A = new JButton("Mice");
			B = new JButton("Fish");
			C = new JButton("Fruit");
			D = new JButton("Insects");
		}
		
		else if (quiznum == 3) { // FlappyBird Question
			
			Q = new JLabel("Where does the Osprey typically make its nest?");

			
			A = new JButton("On the ground");
			B = new JButton("In the water");
			C = new JButton("In a tree");
			D = new JButton("It does not nest");
		}
		}
		
		
		//NORTHERN HARRIER QUESTIONS ------------------------------------------
		else {
		if (quiznum == 1) { // Frogger game question
			
			Q = new JLabel("What is a threat to Northern Harrier as they traverse Delaware?");
			
			A = new JButton("Foxes");
			B = new JButton("Drones");
			C = new JButton("Predatory whales");
			D = new JButton("Deadly nightshade");
				
		}
		
		else if (quiznum == 2) { // Food game Question
			Q = new JLabel("What is the main diet of the Northern Harrier?");

			
			A = new JButton("Fish");
			B = new JButton("Mice");
			C = new JButton("Fruit");
			D = new JButton("Insects");
		}
		
		else if (quiznum == 3) { // FlappyBird Question
			
			Q = new JLabel("Where does the Northern Harrier typically make its nest?");
			
			A = new JButton("In the tree");
			B = new JButton("In the water");
			C = new JButton("On the ground");
			D = new JButton("It does not nest");
		}
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
		panel = new JPanel();
		panel.setLayout(null);
		
		A.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		A.setLocation(LEFT_COL, TOP_ROW );
		
		B.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		B.setLocation(RIGHT_COL, TOP_ROW  );
		
		C.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		C.setLocation(LEFT_COL, BOTTOM_ROW  );
		
		D.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		D.setLocation(RIGHT_COL, BOTTOM_ROW  );
		
		Q.setSize(frameWidth, BUTTON_HEIGHT);
		Q.setLocation(0, TOP_ROW - BUTTON_HEIGHT);
		Q.setHorizontalAlignment(JLabel.CENTER);
		
		Save.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		Save.setLocation(0,0);
		
		
		wrong.setSize(frameWidth,BUTTON_HEIGHT);
		wrong.setLocation(0, BOTTOM_ROW + BUTTON_HEIGHT);
		wrong.setHorizontalAlignment(JLabel.CENTER);

		
		//May want to change these sizes based on length of question/answers
		A.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		B.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		C.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		D.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		Q.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		wrong.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		Save.setFont(new Font("Arial", Font.PLAIN, frameWidth/50));
		
		
		
		//add everything to panel in this order so that the question is at the top

		panel.add(Q);
		//panel.add(blank);
		panel.add(A);
		panel.add(B);
		panel.add(C);
		panel.add(D);
		panel.add(Save);
		
		frame.add(panel);
		frame.setVisible(true);
		
		
		
	}
	
	
	
	
}

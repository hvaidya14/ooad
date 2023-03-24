/**
 * 
 */
package jasti.assign.topquiz.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jasti.assign.topquiz.gui.result.SubjectListener;
import jasti.assign.topquiz.gui.takequiz.QuizPanel;
import jasti.assign.topquiz.gui.takequiz.SubjectPanel;

public class TopQuizFrame extends JFrame {

	//member components
	
	private JLabel lblTitle;
	
	
	private JButton btnStart;
	private JLabel lblError;
	private JLabel nameError;
	private HeaderPanel headerPane;
	private SubjectPanel subjectPane;
	
	private QuizPanel quizPane;
	
	
	private Container contentPane;
	
	private String subjectChosen;
	private String name;
	private JTextField textField;
	
	/**
	 * Initialize values for first load
	 */
	private void initValues()
	{
		headerPane=null;
		subjectPane=null;
		quizPane=null;
		contentPane=null;
		subjectChosen=null;
		
		
	}

	/**
	 * Create the TopQuiz frame.
	 */
	public TopQuizFrame() {
		
		super("TOP QUIZ");
		
		initValues();
		//get content pane
		contentPane=getContentPane();
	//	contentPane.setBackground(new Color(255, 255, 255));
		
		//FRAME properties
		//set default size and minimum size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	setSize((screenSize.width)-200, (screenSize.height)-200);
    	setMinimumSize(new Dimension(800,500));
		//center the frame on screen
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		headerPane=new HeaderPanel();
		
		//set layout and add components
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(headerPane,BorderLayout.NORTH);
		
		createWelcomePanel();
		
		
	}
	
	/**
	 * Creates welcome panel
	 */
	private void createWelcomePanel()
	{
		JPanel welcomePane=new JPanel();
		welcomePane.setLayout(new GridLayout(1, 0));
				
		
		//topic selection panel
		subjectPane=new SubjectPanel();
		subjectPane.setSubjectListener(new SubjectListener() {
			
			@Override
			public void subjectChosen(String subject) {
				// update the subject chosen for quiz
				subjectChosen=subject;
				
			}
		});
		
		lblError=new JLabel("",SwingConstants.CENTER);
		
		//add start button
		JPanel startPane=new JPanel();
		btnStart=new JButton();
		btnStart.setBorderPainted(false);
		btnStart.setContentAreaFilled(false);
		btnStart.setIcon(new ImageIcon("./Resources/LayoutImages/startbutton.png"));
		btnStart.setToolTipText("Start Playing");
		btnStart.setPreferredSize(new Dimension(100, 100));
		startPane.add(btnStart,Component.CENTER_ALIGNMENT);
		
		//add text box
		JPanel textPane=new JPanel();
		textPane.setLayout(new GridLayout(20, 20));
		
		JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(5, 20));
        setVisible(true);
   
        nameError=new JLabel("",SwingConstants.CENTER);	
        
        JLabel label = new JLabel("Enter your Name :");
        textPane.add(label);
        textPane.add(textField);
        
        
       // System.out.println("Name enteredbbbbbbbb: " + name);
        
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                if (name.trim().isEmpty()) {
                	lblError.setText("Name cant be empty.");//add lblError to layout
					lblError.setForeground(Color.RED);
                    System.out.println("TextField is empty");
                } else {
                    System.out.println("Name entered: " + name);
                }
            }
        });
		
		/**
		 * Start button click event
		 */
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
            
				
				// Validate Subject selection
				System.out.println("subjectChosen:"+subjectChosen +"Name : "+name);
				if(subjectChosen!=null && name!=null && !name.trim().isEmpty())
				{
					//ok, display QuizPanel, hide welcomePanel
					welcomePane.setVisible(false);
					
					//QUIZ PANEL
					
					quizPane=new QuizPanel(subjectChosen);
					quizPane.setVisible(true);
					
					
					contentPane.add(quizPane,BorderLayout.CENTER);//add quizPane to contentPane
				}
				else
				{
					//else, show error message
					lblError.setText("Please choose a topic and Name to proceed.");//add lblError to layout
					lblError.setForeground(Color.RED);
				}
				
			}
		});
		
		
		   
		welcomePane.add(textPane);
		welcomePane.add(subjectPane);
		welcomePane.add(startPane);
		welcomePane.add(lblError);
	    welcomePane.add(nameError);
	        
		
		contentPane.add(welcomePane,BorderLayout.CENTER);//add to content pane
		
	}

}

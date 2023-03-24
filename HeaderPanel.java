package jasti.assign.topquiz.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.SystemColor;
import java.awt.Rectangle;

public class HeaderPanel extends JPanel {

	private JLabel lblTitle;
	private JLabel lblSubTitle;
	
	/**
	 * Create the Title panel.
	 */
	public HeaderPanel() {
		
	//	setBackground(new Color(150, 110, 255));
		setLayout(new GridLayout(0,1));
		
		//set size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMaximumSize(new Dimension(screenSize.width, screenSize.height/4));
		setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		
		lblTitle=new JLabel("Top Quiz",SwingConstants.CENTER);
		lblTitle.setToolTipText("Top Quiz - Learning through fun ");
	//	lblTitle.setForeground(new Color(0, 0, 255));
	//	lblTitle.setBackground(new Color(255, 255, 128));
	//	lblTitle.setFont(new Font("Century Schoolbook", Font.BOLD, 40));
		
		lblSubTitle=new JLabel("Learning through fun",SwingConstants.CENTER);
	//	lblSubTitle.setForeground(new Color(255, 255, 255));
	//	lblSubTitle.setBackground(new Color(0, 0, 128));
	//	lblSubTitle.setFont(new Font("Century Schoolbook", Font.ITALIC, 40));
		
		//add to layout
		add(lblTitle);
		add(lblSubTitle);
		

	}

}

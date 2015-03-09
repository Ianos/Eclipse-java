package iprog2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Canvas canvas = new Canvas();
	MyThread myThread = new MyThread(canvas);
		
	public static void main(String[] args) {
		new MyFrame();
	}
	
	public MyFrame() throws HeadlessException { 
		super("This is my frame"); 
		setVisible(true);  
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		getContentPane().add(canvas); 

		myThread.start(); 
		pack();
	}

}

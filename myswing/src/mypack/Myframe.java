package mypack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Myframe extends JFrame implements ActionListener {
	
	
	private Canvas canvas =new Canvas();
	
	
	private String[] selections = {"Circle","Square"};
	

	public Myframe() throws HeadlessException {
		super();
		
		setLayout(new BorderLayout());
		add(canvas,BorderLayout.CENTER);
		JPanel pnl=new JPanel();
		pnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		pnl.add(new JLabel("Select shape:"));
		
		JComboBox combo = new JComboBox(selections);
		combo.addActionListener(this);
		pnl.add(combo);
		// Mehri edo den vlepo tipota mono kiklo kathos ta eho
		// ftiaksei men den ta eho valei 
		add(pnl,BorderLayout.NORTH);
		// Tora ta evala!
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
	}

	public static void main(String [] args){
		new Myframe();
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
	if (ev.getSource() instanceof JComboBox);{
	if (((String)((JComboBox)ev.getSource()).getSelectedItem()).equals(selections[0]))
			canvas.setCircle(true);
	else if (((String)((JComboBox)ev.getSource()).getSelectedItem()).equals(selections[1]))
	canvas.setCircle(false);
	canvas.repaint();
	}
	
	}
}

package iprog2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener{

	private int x = -1;
	private int y = -1;
	private int rad = 50;
	private boolean myred = true; //true gia red
	private int count = 0;
	private int [] xs = new int[100];
	private int [] ys = new int[100];
	private int [] side = new int [100];


	public boolean isRed() {
		return myred;
	}
	
	public void changeCol (boolean redthing){
		this.myred = redthing;
	}
	
	public Canvas() {
		setPreferredSize(new Dimension(500,500));
		addMouseListener(this);
	}

	public void paint(Graphics g){
		if (myred == true){
			g.setColor(Color.red);
			rad = 50;
		} else {
			g.setColor(Color.green);
			rad = 100;
		}	
		for (int i=0; i<count; i++) {
			g.drawRect(xs[i]-(side[i]/2), ys[i]-(side[i]/2), side[i], side[i]);
		}
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		boolean found = false;
		for (int i = 0; i < count; ++i)
			if ((xs[i] > 0) && (ev.getX() > xs[i]-side[i]/2) && (ev.getX() < (xs[i]+side[i]/2) )
					&& (ev.getY() > ys[i]-side[i]/2) && (ev.getY() < (ys[i]+side[i]/2))) {
				xs[i] = -300;	//out of my sight!
				ys[i] = -300;
				found = true;
				repaint();
			}
		if (found == false){
			count++;
			xs[count-1]= ev.getX();
			ys[count-1]= ev.getY();
			side[count-1] = (int) (Math.random() * 100) ;
			repaint();
		} 
	}

	/* DO NOT CROSS THIS LINE - DUMMY STUFF BELOW! */


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
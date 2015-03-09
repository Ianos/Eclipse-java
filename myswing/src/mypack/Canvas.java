package mypack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener{
	
	private int x=-1;
	private int y=-1;
	private int rad=50;
	private boolean circle = true;
	
	
	private Thread timer ;
	

	public boolean isCircle() {
		return circle;
	}

	public void setCircle(boolean circle) {
		this.circle = circle;
	}

	public Canvas() {
		super();
		setPreferredSize(new Dimension(500,500));
		addMouseListener(this);
		// TODO Auto-generated constructor stub
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		if (x<0)
			reset();
		if (circle)
		g.drawOval(x-rad,y-rad,2*rad,2*rad);
		else g.drawRect(x-rad,y-rad,2*rad,2*rad);
	}
	
	
	public void reset(){
	x=getWidth()/2;
	y=getHeight()/2;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	   x = arg0.getX();
	   y = arg0.getY();
	   repaint();
	   if (timer!=null)
		   timer.interrupt();
	   timer = new Thread (new myTimer(4000,this));
	   timer.start();
	}

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

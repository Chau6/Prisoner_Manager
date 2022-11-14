package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;

public class LoginUI extends JFrame {
	
	public float getAnimate() {
		return animate;
	}
	public void setAnimate(float animate) {
		this.animate=animate;
	}
	
	private float animate;
	
	
	public LoginUI() {
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
@Override
public void paint(Graphics grphcs) {
	Graphics2D g2 = (Graphics2D)grphcs;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	int height = (int)(getHeight()*(1f-animate));
	g2.setColor(new Color(220,219,255));
	g2.fill(createShape(height,50,70,50,100));
	g2.setColor(new Color(201,199,255));
	g2.fill(createShape(height,80,50,100,50,100,50));
	g2.setColor(new Color(157,153,255));
	g2.fill(createShape(height,70,20,60,20,70));
	g2.dispose();
	super.paint(grphcs);
}
	private Shape createShape(int location, int startInit, int...points) {
		int width = getWidth();
		int height = getHeight();
		int ss = width / points.length;
		int size = location;
		
		GeneralPath p = new GeneralPath();
		
		int space = 0;
		int xs = 0;
		int ys = location - startInit;
		for(int point : points) {
			point = size - point;
			int s = space + ss/2;
			p.append(new CubicCurve2D.Double(xs,ys,s,ys,s,point,xs+ss,point), true);
			space+=ss;
			xs +=ss;
			ys= point;
		}
		p.lineTo(width, ys);
		p.lineTo(width, height);
		p.lineTo(0, height);
		return p;
	}
	
}

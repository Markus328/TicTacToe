package tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import base.Entity;
import base.EntityView;
import base.ImageFactory;
import base.Renderable;
import base.Sprite;
import base.Stepwatch;

public class Panel extends JPanel{
	private World world;
	private Stepwatch sw;
	private Graphics2D graphics;
	private ArrayList<Renderable> views;
	private BufferedImage offscreen;
	public Panel(JFrame master) {
		setVisible(master.isVisible());
		setBounds(master.getBounds());
		sw = new Stepwatch();
		views = new ArrayList<Renderable>();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		offscreen = gc.createCompatibleImage(getWidth(), getHeight());
		graphics = (Graphics2D) offscreen.getGraphics();
		
		graphics.setBackground(getBackground());
		graphics.clearRect(getX(),getY(),getWidth(),getHeight());
		
		world = World.create_instance(getWidth(), getHeight());
	}
	public void paint(Graphics g) {
		try {
		step(sw.tick());
		g.drawImage(offscreen, 0, 0, null);
		repaint();
		try { 
			Thread.sleep(1000/30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		catch(Exception e) {
			g.dispose();
			graphics.dispose();
			throw e;
		}
	}
	public void addNotify() {
		super.addNotify();
		this.setup();
	}
	public void setup() {
		
		world.setup();
		for(Entity e : world.getEntities()) {
			views.add(e.getView());
		}
		
	}
	public void step(double tick) {
		world.step(tick);
		graphics.setColor(Color.BLACK);
		for(Renderable e : views) {
			
			if(e.update()) {
				e.render(graphics);
			}
		}
		
	}
}

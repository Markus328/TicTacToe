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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class Panel extends JPanel implements MouseListener{
	private World world;
	private Graphics2D graphics;
	private ArrayList<Renderable> views;
	private BufferedImage offscreen;
	private Controller controller;
	public Panel(JFrame master) {
		setVisible(master.isVisible());
		setBounds(master.getBounds());
		addMouseListener(this);
		views = new ArrayList<Renderable>();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		offscreen = gc.createCompatibleImage(getBounds().width, getBounds().height);
		graphics = (Graphics2D) offscreen.getGraphics();
		
		graphics.setBackground(getBackground());
		graphics.clearRect(getX(),getY(),getWidth(),getHeight());
		
		world = World.create_instance(getWidth(), getHeight());
	}
	public void paint(Graphics g) {
		step();
		g.drawImage(offscreen, 0, 0, null);
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
		this.repaint();
		
	}
	public void step() {
		world.step(1);
		for(Renderable e : views) {
			
			if(e.update()) {
				e.render(graphics);
			}
		}
		
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
		controller.setPanel(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		controller.tap(e.getX(), e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

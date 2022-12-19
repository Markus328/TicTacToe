package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Sprite {
	private Point2D position;
	private Dimension2D dimensions;
	private BufferedImage img;
	private double rotation = 0;
	private Point translatation;
	
	public Point2D getTranslatation() {
		return translatation;
	}
	public void setTranslatation(Point translatation) {
		this.translatation = translatation;
	}
	public double getRotation() {
		return rotation;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
	public Point2D getPosition() {
		return position;
	}
	public void setPosition(Point2D position) {
		this.position.setLocation(position);
	}
	public Dimension2D getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimension2D dimensions) {
		this.dimensions.setSize(dimensions);
	}
	public void setImage(BufferedImage image) {
		this.img = image;
	}
	public Sprite(BufferedImage img) {
		// TODO Auto-generated constructor stub
		this.img = img;
		this.position = new Point();
		this.dimensions = new Dimension();
	}
	public void render(Graphics g) {
		if(rotation != 0) {
			Graphics2D copy = (Graphics2D) g.create();
			Point translate = this.translatation != null ? this.translatation : new Point((int)(getPosition().getX() + getDimensions().getWidth()/2),(int)(
					getPosition().getY() + getDimensions().getHeight()/2));
			copy.rotate(Math.toRadians(getRotation()),translate.getX(),translate.getY());
			copy.drawImage(img,(int)position.getX(), (int)position.getY(), (int)dimensions.getWidth(), (int)dimensions.getHeight(),null);
			copy.dispose();
		}
		else
		g.drawImage(img,(int)position.getX(), (int)position.getY(), (int)dimensions.getWidth(), (int)dimensions.getHeight(),null);
	}
}

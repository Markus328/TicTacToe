package base;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	
	public Point2D getPosition() {
		return position;
	}
	public void setPosition(Point2D position) {
		this.position = position;
	}
	public Dimension2D getDimensions() {
		return dimensions;
	}
	public void setDimensions(Dimension2D dimensions) {
		this.dimensions = dimensions;
	}
	public void setImage(BufferedImage image) {
		this.img = image;
	}
	public Sprite(BufferedImage img) {
		// TODO Auto-generated constructor stub
		this.img = img;
	}
	public void render(Graphics g) {
		g.drawImage(img,(int)position.getX(), (int)position.getY(), (int)dimensions.getWidth(), (int)dimensions.getHeight(),null);
	}
}

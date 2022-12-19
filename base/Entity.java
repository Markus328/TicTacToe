package base;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import tictactoe.World;

public class Entity {
	
	private static int ID_COUTER = 0;
	private static World WORLD;
	private int id;
	private Point position;
	private Dimension dimensions;
	private EntityView view;
	private int flags;
	private boolean dirty;
	
	private Rectangle area;
	
	public Entity(double x, double y, double w, double h) {
		this.id = Entity.ID_COUTER++;
		this.position = new Point((int)x,(int)y);
		this.dimensions = new Dimension((int)w,(int)h);
		this.area = new Rectangle();
		dirty = false;
		flags = 0;
	}
	public void setup() {}
	public void step(double tick) {}
	public Point getPosition() {
		return position;
	}
	public void setPosition(double x, double y) {
		this.position.setLocation(x, y);
	}
	public Dimension getDimensions() {
		return dimensions;
	}
	public void setDimensions(int w, int h) {
		this.dimensions.setSize(w, h);
	}
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public boolean update() {
		boolean tmp = dirty;
		this.dirty = false;
		return tmp;
	}
	public void requestUpdate() {
		this.dirty = true;
	}
	public boolean isDirty() {
		return dirty;
	}
	public int getId() {
		return id;
	}
	public Rectangle getArea() {
		area.setLocation(position);
		area.setSize(dimensions);
		return area;
	}
	public EntityView getView() {
		return view;
	}
	public void setView(EntityView view) {
		this.view = view;
	}
	public boolean hasInside(int x, int y) {
		int left,right,top,bottom;
		left = this.getPosition().x; right = left + this.getDimensions().width;
		top = this.getPosition().y; bottom = top + this.getDimensions().height;
		if(left <= x && x <= right
				&& top <= y && y <= bottom) {
			return true;
		}
		return false;
	}
	
	
}

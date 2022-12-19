package tictactoe;

import java.awt.image.BufferedImage;

import base.Entity;
import base.ImageFactory;

public class Cell extends Entity {

	public static final int IS_NONE = 2;
	
	
	private int type;
	private boolean modified;
	private double timer = 0;
	public Cell(double x, double y, double w, double h) {
		super(x, y, w, h);
		setType(IS_NONE);
		setView(new CellView(this));
		// TODO Auto-generated constructor stub
	}
	public int getType() {
		return type;
	}
	public void requestUpdate() {
		super.requestUpdate();
		World.get_instance().getGrid().requestUpdate();
		modified = true;
	}
	public void setType(int type) {
		this.type = type;
		requestUpdate();
	}
	public void tap() {
		if(type == IS_NONE) {
			setType(World.get_instance().getPlaying());
			World.get_instance().switchPlayer();
		}
		setType(getType());
		
	}
	
}

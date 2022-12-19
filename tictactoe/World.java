package tictactoe;

import java.awt.Dimension;
import java.util.ArrayList;

import base.Entity;

public class World {
	
	private int GRID_ID = -1;
	private int SCORE_ID = -1;
	public static final int PLAYER_X = 0, PLAYER_O = 1;
	private static World instance;
	
	public static World create_instance(int width, int height) {
		if(instance == null) {
			instance = new World(width,height);
		}
		return instance;
	}
	public static World get_instance() {
		return instance;
	}
	
	private Dimension dimensions;
	private Grid grid;
	private ArrayList<Entity> entities;
	private int playing;
	private boolean running;
	
	protected World(int width, int height) {
		dimensions = new Dimension(width, height);
		entities = new ArrayList<Entity>();
		int gx,gy;
		int minor = height > width ? width : height;
		minor = (int)(minor*0.8);
		int major = width + height - minor;
		gx = (width - minor)/2;
		gy = (height - minor)/2;
		grid = new Grid(gx, gy, minor, minor);
		GRID_ID = grid.getId();
	}
	public void setup() {
		grid.setup();
		setPlaying(PLAYER_O);
		setRunning(true);
		for (Cell c : grid.getCells())
			entities.add(c);
		entities.add(grid);
		
	}
	public void step(double tick) {
		grid.step(tick);
	}
	public Entity getEntity(int id) {
		for (Entity e : entities) {
			if(e.getId() == id)
				return e;
		}
		return null;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public Grid getGrid() {
		return grid;
	}
	public void tap(int x,int y) {
		if(isRunning()) {
		getGrid().tap(x, y);
		}
		else {
			getGrid().reset();
			setRunning(true);
		}
		
	}
	public int getPlaying() {
		return playing;
	}
	public void setPlaying(int playing) {
		this.playing = playing;
	}
	public void switchPlayer() {
		this.playing = this.playing == PLAYER_O ? PLAYER_X : PLAYER_O;
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	
}
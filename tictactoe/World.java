package tictactoe;

import java.awt.Dimension;
import java.util.ArrayList;

import base.Entity;

public class World {
	
	private int GRID_ID = -1;
	private int SCORE_ID = -1;
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
	
	protected World(int width, int height) {
		dimensions = new Dimension(width, height);
		entities = new ArrayList<Entity>();
		grid = new Grid(0, 0, 840, 840);
		GRID_ID = grid.getId();
	}
	public void setup() {
		grid.setup();
		
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
	
}
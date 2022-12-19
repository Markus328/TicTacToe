package tictactoe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import base.Entity;
import base.EntityView;
import base.ImageFactory;
import base.Sprite;

public class GridView extends EntityView {
	private Sprite grid;
	public static BufferedImage GRID_IMG = (BufferedImage) ImageFactory.createImage("/assets/grade.png", GridView.class);
	
	public GridView(Grid g) {
		super(g);
		// TODO Auto-generated constructor stub
		System.out.println("a");
		grid = new Sprite(GridView.GRID_IMG);
		grid.setPosition(g.getPosition());
		grid.setDimensions(g.getDimensions());
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		grid.render(g);
	}

}

package tictactoe;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import base.Entity;
import base.EntityView;
import base.ImageFactory;
import base.Sprite;

public class GridView extends EntityView {
	private Sprite grid;
	private Sprite lineRect;
	private Sprite lineDgn;
	public static BufferedImage GRID_IMG = (BufferedImage) ImageFactory.createImage("/assets/grade.png", GridView.class);
	public static BufferedImage LINE_RECT_IMG = (BufferedImage) ImageFactory.createImage("/assets/lineRect.png", GridView.class);
	public static BufferedImage LINE_DGN_IMG = (BufferedImage) ImageFactory.createImage("/assets/lineDgn.png", GridView.class);
	
	public GridView(Grid g) {
		super(g);
		// TODO Auto-generated constructor stub
		System.out.println("a");
		grid = new Sprite(GridView.GRID_IMG);
		
		grid.setPosition(g.getPosition());
		grid.setDimensions(g.getDimensions());
		lineRect = new Sprite(LINE_RECT_IMG);
		lineRect.setPosition(g.getPosition());
		lineRect.setDimensions(new Dimension(this.entity.getDimensions().width,this.entity.getDimensions().height/70));
		lineDgn = new Sprite(LINE_DGN_IMG);
		lineDgn.setPosition(g.getPosition());
		lineDgn.setDimensions(g.getDimensions());
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Grid e = (Grid) this.entity;
		int line = e.getStatus()[1], line_pos = e.getStatus()[2];
		
		if(line == Grid.LINE_CLEAR) {
			super.render(g);
			e.getStatus()[1] = line = -1;
		}
		
		grid.render(g);
		if (line == -1)
			return;
		
		Sprite s;
		if ((line & Grid.LINE_RECT) != 0) {
			s = lineRect;
			
			Point cellPos = e.getCells()[line_pos].getPosition();
			Dimension cellDim = e.getCells()[line_pos].getDimensions();
			if(line == Grid.LINE_HORIZONTAL) {
			s.setRotation(0);
			s.setPosition(new Point(cellPos.x, cellPos.y + cellDim.height/2));
			}
			else {
				s.setRotation(90);	
				s.setPosition(new Point(cellPos.x + cellDim.width/2,cellPos.y));
			}
			s.setTranslatation(new Point((int)s.getPosition().getX(),(int)s.getPosition().getY()));
			
		}
		else {
			s = lineDgn;
			s.setRotation((line - Grid.LINE_DIAGONAL) * 90);
		}
		s.render(g);
	}

}

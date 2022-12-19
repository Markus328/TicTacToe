package tictactoe;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import base.Entity;
import base.EntityView;
import base.ImageFactory;
import base.Renderable;
import base.Sprite;

public class CellView extends EntityView  implements Renderable{
	private Sprite x,o;
	public static BufferedImage X = (BufferedImage) ImageFactory.createImage("/assets/xis.png", CellView.class);
	public static BufferedImage O = (BufferedImage) ImageFactory.createImage("/assets/circle.png", CellView.class);

	public CellView(Cell cell) {
		super(cell);
		this.x = new Sprite(CellView.X);
		this.o = new Sprite(CellView.O);
		this.x.setPosition(cell.getPosition());
		this.x.setDimensions(cell.getDimensions());
		this.o.setPosition(cell.getPosition());
		this.o.setDimensions(cell.getDimensions());
		// TODO Auto-generated constructor stub
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		super.render(g);
		int type = ((Cell)this.entity).getType();
		if(type == Cell.IS_O)
			o.render(g);
		else if (type == Cell.IS_X)
			x.render(g);
	}

}

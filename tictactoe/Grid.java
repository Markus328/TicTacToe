package tictactoe;

import java.awt.Dimension;

import base.Entity;

public class Grid extends Entity {
	
	private Cell []cells;
	private Dimension gap;
	public Grid(double x, double y, double w, double h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		cells = new Cell[9];
		gap = new Dimension((int)w/70, (int)h/70);
		setView(new GridView(this));
		
	}
	public void setup() {
		int x = getPosition().x, y = getPosition().y;
		int w = (getDimensions().width - 2*gap.width)/3, h = (getDimensions().height - 2*gap.height)/3;
		for(int i = 0; i < cells.length; ++i) {
			cells[i] = new Cell(x,y,w,h);
			if(x + w >= getPosition().x + w*3) {
				x = getPosition().x;
				y += h + gap.height;
			}
			else
				x += w + gap.width;
		}
	}
	public void step(double tick) {
		for(int pos = 0; pos < cells.length; ++pos) {
			Cell c = cells[pos];
			c.step(tick);
			
		}
		if(this.isDirty()) {
			int line = check(0,1,3);
			int column = check(0,3,1);
			int diagr = check(2,2,0);
			int diagl = check(0,4,0);
			if (line != -1)
				System.out.printf("line:%d\n",line);
			if(column != -1) {
				System.out.printf("column:%d\n",column);
			}
			if(diagr != -1) {
				System.out.printf("diagonal right:%d\n",diagr);
			}
			if(diagl != -1) {
				System.out.printf("diagonal left:%d\n",diagl);
			}
			System.out.printf("refresh\n");
			
		}
	}
	private int getCellPos(Cell cell) {
		for(int i = 0;i < cells.length; ++i) {
			if (cells[i] == cell)
				return i;
		}
		return -1;
	}
	private int check(int start,int i0,int i1) {
		label0:
		for(int j = 0; j < 3; ++j) {
			int pos = start;
			int backValue = cells[start].getType();
			start += i1;
			if(backValue == Cell.IS_NONE)
				continue;
			label1:
			for(int n = 0; n < 2; ++n) {
				pos += i0;
				if(cells[pos].getType() != backValue)
					continue label0;
			}
			return start - i1;
		}
		return -1;
	}
	public Cell[] getCells() {
		return cells;
	}

}

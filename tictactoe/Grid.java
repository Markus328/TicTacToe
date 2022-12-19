package tictactoe;

import java.awt.Dimension;

import base.Entity;

public class Grid extends Entity {
	
	public static final int LINE_CLEAR = 0;
	public static final int LINE_RECT = 4, LINE_VERTICAL = 5,LINE_HORIZONTAL=6;
	public static final int LINE_DIAGONAL = 8,LINE_DIAGONAL_LEFT = 9, LINE_DIAGONAL_RIGHT = 10;
	private Cell []cells;
	private Dimension gap;
	private int[] status;
	public Grid(double x, double y, double w, double h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		cells = new Cell[9];
		gap = new Dimension((int)w/70, (int)h/70);
		setView(new GridView(this));
		status = new int[3];
		status[0] = Cell.IS_NONE;
		status[1] = -1;
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
		
		if(this.isDirty()) {
			boolean ok = false;
			for(Cell c: cells) {
				if(c.getType() == Cell.IS_NONE) {
					ok = true;
					break;
				}
					
			}
			if(!ok) {
				reset();
				return;
			}
			checkAndSetWinner();
		}
	}
	private int getCellPos(Cell cell) {
		for(int i = 0;i < cells.length; ++i) {
			if (cells[i] == cell)
				return i;
		}
		return -1;
	}
	private void checkAndSetWinner() {
		int []values = {check(0,3,1),check(0,1,3),check(0,4,0),check(2,2,0)};
		int i;
		for(i = 0;i< values.length; ++i) {
			if(values[i] != -1) {
				status[0] = cells[values[i]].getType();
				status[1] = i < 2 ? (i + 1) + LINE_RECT : (i-1) + LINE_DIAGONAL;
				status[2] = values[i];
				World.get_instance().setRunning(false);
				break;
			}
		}		
	}
	private int check(int start,int i0,int i1) {
		label0:
		for(int j = 0; j < 3; ++j) {
			int pos = start;
			int backValue = cells[start].getType();
			start += i1;
			if(backValue == Cell.IS_NONE)
				continue;
			
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
	public int[] getStatus() {
		return status;
	}
	public void tap(int x,int y) {
		
		for(Cell c : cells) {
			if(c.hasInside(x, y)) {
				c.tap();
			}
		}
	}
	public void reset() {
		status[0] = 0;
		status[1] = LINE_CLEAR;
		status[2] = -1;
		requestUpdate();
		for(Cell c : cells) {
			c.setType(Cell.IS_NONE);
		}
	}

}

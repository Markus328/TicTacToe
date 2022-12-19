package tictactoe;

public class Controller {
	public void tap(int x, int y) {
		// TODO Auto-generated method stub
		int left,right,top,bottom;
		for(Cell c : World.get_instance().getGrid().getCells()) {
			left = c.getPosition().x; right = left + c.getDimensions().width;
			top = c.getPosition().y; bottom = top + c.getDimensions().height;
			if(left <= x && x <= right
					&& top <= y && y <= bottom) {
				c.tap();
			}
		}
	}

}

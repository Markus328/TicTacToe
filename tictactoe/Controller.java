package tictactoe;

public class Controller {
	private Panel panel;
	public void tap(int x, int y) {
		panel.repaint();
		World.get_instance().tap(x, y);
	}
	public void setPanel(Panel p) {
		panel = p;
	}

}

package tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		Panel gp = new Panel(frame);
		frame.add(gp);
		Controller controller = new Controller();
		gp.setController(controller);
		

	}

}

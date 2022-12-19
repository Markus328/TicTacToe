package tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame frame = new GameFrame();
		Panel gp = new Panel(frame);
		Controller controller = new Controller();
		frame.setController(controller);
		SwingUtilities.invokeLater(new Runnable(){
			private GameFrame frame;
			private Panel panel;
			public Runnable init(GameFrame frame, Panel panel) {
				this.frame = frame;
				this.panel = panel;
				return this;
			}
			public void run() {
				frame.getContentPane().add(panel);
			}
		}.init(frame, gp));

	}

}

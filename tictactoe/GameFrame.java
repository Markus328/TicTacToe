package tictactoe;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	public GameFrame() {
		super("Tic-Tac-Toe");
		setFocusable(true);
		this.setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setVisible(true);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

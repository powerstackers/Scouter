package tournaments;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CascadeEffectEntryScreen extends MatchEntryScreen{

	
	
	/**
	 * Create a new match data entry screen, built for the Cascade Effect game
	 */
	public CascadeEffectEntryScreen(){
		super();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		
		CascadeEffectEntryScreen screen = new CascadeEffectEntryScreen();
		
		frame.add(screen);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

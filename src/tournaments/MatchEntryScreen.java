package tournaments;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import matches.Match;

@SuppressWarnings("serial")
public abstract class MatchEntryScreen extends JPanel{
	
	// The match whose data we will be entering
	private Match match = new Match();
	
	private JPanel redPanel = new JPanel();
	private JPanel bluePanel = new JPanel();
	
	/**
	 * Create a new match entry screen, with some generic things
	 */
	public MatchEntryScreen(){
		// Set the layout of the JPanel to a grid layout, with 2 columns and 1 row
		this.setLayout(new GridLayout(1, 2));
		
		// Set the borders for the two panels
		redPanel.setBorder(new TitledBorder("Red Alliance"));
		bluePanel.setBorder(new TitledBorder("Blue Alliance"));
		
		// Add the panels to this object
		this.add(redPanel);
		this.add(bluePanel);
	}
	
	public int winner(){
		return match.getRedScore()>match.getBlueScore()? Match.RED_WINS : Match.BLUE_WINS;
	}
}

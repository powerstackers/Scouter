package userinterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * An application for storing, viewing, and tracking information about FIRST Tech Challenge
 * teams and matches. This application stores relevant data on file, and can load and display
 * that information. Users can also enter the data themselves and add it to the archive.
 * The application has planned support for many FTC games, and can track across multiple events
 * and seasons.
 * 
 * @author Jonathan Thomas
 */
public class ScoutingApp extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConsoleWindow console = new ConsoleWindow();
	
	/* 
	 * MENU BAR
	 */
	private MenuBar menuBar = new MenuBar();
	
	
	/*
	 *PANELS 
	 */
	private JPanel teamPanel = new JPanel(new GridLayout(1, 2));
	private JPanel matchPanel = new JPanel(new GridLayout(1, 2));

	private TeamsListPanel teamsListPanel = new TeamsListPanel();
	private MatchesListPanel matchesListPanel = new MatchesListPanel();
	
	/**
	 * Creates a new ScoutingApp window. Loads all relevant information from file and dislpays it.
	 */
	public ScoutingApp(){
		// Add menu items to their respective menus
		
		// Create listeners for the menu items in the TEAMS menu
		setMenuBarFunctions();
		
		// Add the main con
		teamPanel.add(teamsListPanel);
		matchPanel.add(matchesListPanel);
		
		add(teamPanel, BorderLayout.WEST);
		add(matchPanel, BorderLayout.EAST);
		//add(console.checkboxEnableConsole, BorderLayout.SOUTH);
		add(menuBar, BorderLayout.NORTH);
		
		teamsListPanel.setConsoleWindow(console);
		
		addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(WindowEvent e){
				teamsListPanel.list.saveAllTeams();
				matchesListPanel.list.saveAllMatches();
				System.exit(0);
			}
		});
		console.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Scouting Application");
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		setExtendedState(getExtendedState() | MAXIMIZED_BOTH);
	}
	
	/**
	 * Set functions for the menu bar options. Could be combined with constructor, but I'll figure it out later.
	 */
	private void setMenuBarFunctions(){
		menuBar.addTeamMenuItem.addActionListener(new ActionListener(){ 
			@Override public void actionPerformed(ActionEvent e) {
				teamsListPanel.showAddTeamDialog();
			}
		});
		
		menuBar.removeTeamMenuItem.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent e) {
				teamsListPanel.deleteTeam();
			}
		});
		
		menuBar.showConsoleMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(menuBar.showConsoleMenuItem.isSelected())
					console.setVisible(true);
				else
					console.setVisible(false);
			}
		});
		
		menuBar.addMatchMenuItem.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent ev){
				matchesListPanel.showAddMatchDialog();
			}
		});
	}
	
	/**
	 * Set the visibility of the console output window.
	 * 
	 * @param vis
	 */
	public void setConsoleVisible(boolean vis){
		console.setVisible(vis);
	}
	
	public static void main(String[] args) {		

	}
}

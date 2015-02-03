package tournaments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import matches.Match;
import matches.MatchesList;
import teams.Team;
import teams.TeamsList;
import userinterface.ConsoleWindow;

public class Tournament {
	
	public static String tournamentSavePath = "data/tournaments/";
	public static String tournamentSaveExt = ".dat";

	private TeamsList roster = new TeamsList();
	private MatchesList matches = new MatchesList();
	
	private String eventName = "";
	private String eventLocation = "";
	
	private ConsoleWindow cons = new ConsoleWindow();
	
	public void setEventName(String eventName){
		this.eventName = eventName;
	}
	
	public String getEventName(){
		return eventName;
	}
	
	public void setEventLocation(String eventLocation){
		this.eventLocation = eventLocation;
	}
	
	public String getEventLocation(){
		return eventLocation;
	}
	
	public void setRoster(TeamsList roster){
		this.roster = roster;
	}
	
	public TeamsList getRoster(){
		return roster;
	}
	
	public void setMatches(MatchesList matches){
		this.matches = matches;
	}
	
	public MatchesList getMatches(){
		return matches;
	}
	
	public void addTeam(Team team){
		roster.addTeam(team);
	}
	
	public void addMatch(Match match){
		matches.addMatch(match);
	}
	
	public void setConsoleWindow(ConsoleWindow cons){
		this.cons = cons;
	}
	
	/**
	 * Save a tournament object to a file.
	 * @param tour
	 * @param file
	 */
	public static void save(Tournament tour, File file){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(tour);
			out.close();
		}catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Load a tournament object from a file.
	 * @param file
	 * @return
	 */
	public static Tournament load(File file){
		Tournament tour = null;
		
		try {
			ObjectInputStream in =  new ObjectInputStream(new FileInputStream(file));
			tour = (Tournament) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(tour==null){
			tour = new Tournament();
			tour.cons.printConsoleLine("There was a problem reading the tournament data.");
		}
		
		return tour;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

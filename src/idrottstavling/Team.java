package idrottstavling;

public class Team {

		private String teamTitle;
		private int startNumber;
		
	public Team(String teamTitle, int startNumber){
		this.teamTitle = teamTitle;
		this.startNumber = startNumber;
	}
	
	public String getTeamTitle(){
		return teamTitle;
	}
	
	public void setTeamTitle(String teamTitle){
		this.teamTitle = teamTitle;
	}
	
	public int getStartNumber(){
		return startNumber;
	}

}

package idrottstavling;

import java.util.*;

public class Participant extends Competition {
	
	// arraylist för att spara resultaten. Vet ej om det är korrekt med competition..
	
 ArrayList<Result> participantResults = new ArrayList<Result>();


	private String firstName;
	private String lastName;
	private String team;
	private int startNumber;
	private static int sNumber = 100;
	
	private double result; //lagt till det 

//	//konstruktor utan resultat
	public Participant(String firstName, String lastName, String team) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.team = team;
			startNumber=sNumber;
			sNumber++;
			
	}
	
			//konstruktor med resultat
			public Participant(String firstName, String lastName, String team, double result) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.team = team;
				this.result = result;
				startNumber=sNumber;
				sNumber++;

	}

			public Participant(){
				
			}
			
			
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getTeam() {
		return team;

	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getStartNumber() {
		return startNumber;

	}
 

	public double getResult(){
		return result;
	}

	public void setResult(double result){
		this.result = result;
	}
	
	
	public void addParticipantResult(Result pResult) {

		
		participantResults.add(pResult);
	}
	

	// -----------------------------------------------------------------
	//Behöver vi en metod för getResultsForParticipants??? TESTAR HÄR
	
	public void getResultForParticipants (){
		for(Result p:participantResults){	
			System.out.println(String.format("Results for %s in %s: %s",getFullName(),p.getNameE(), p));
	}
		
	}
	// -----------------------------------------------------------------
	
	
	public Result getResultForEvent (Event events){
		for(Result r:participantResults){
			if(r.getNameE().getEventName().equals(events.getEventName())){
				return r;
			}
		}
		return null;
	}


	public void printList() {
		System.out.println(participantResults.size());
	}
	
	
	//REMOVE ALL?????
	public void removeAll(){
		participantResults.removeAll(participantResults);
		}

	
	
	public String toString() {
		return firstName + " " + lastName + " with " + startNumber;
	}

}

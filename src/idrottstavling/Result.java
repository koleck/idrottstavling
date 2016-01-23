package idrottstavling;

public class Result {
	

	private double [] results;
	
	private int attempts = 0;
	private Participant nameP;
	private Event nameE;
	// tog bort result variabeln och allt med result att göra här.. vet ej om det är rätt.. Flyttade de till Participant
	
	public Result(Participant nameP, Event nameE){
		this.nameP = nameP;
		this.nameE = nameE;
		results = new double [nameE.getAttempts()];
		
	}
	
	public Participant getNameP(){
		return nameP;
	}
	
	public Event getNameE(){
		return nameE;
	}
	
	public void addResult(double r){
		if(attempts < results.length){
		results[attempts] = r;
		attempts++;
		} else {
			System.out.println("För många försök.");
		}
	}
	
	
	
	public String toString() {
		return results.toString();
	}
	
}

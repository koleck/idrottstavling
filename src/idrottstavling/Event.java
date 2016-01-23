package idrottstavling;

import java.util.ArrayList;

public class Event {

	 ArrayList<Result> eventResults = new ArrayList<Result>();
	 
	private String eventName;
	private int attempts;
	private boolean biggerBetter;

	public Event(String eventName, int attempts, boolean biggerBetter) {
		this.eventName = eventName;
		this.attempts = attempts;
		this.biggerBetter = biggerBetter;

	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public boolean getBiggerBetter() {
		return biggerBetter;
	}

	public void setBiggerBetter(boolean biggerBetter) {
		this.biggerBetter = biggerBetter;
	}
	
	public void addResult(Result re){
		eventResults.add(re);
	}
	
	//REMOVE ALL
	public void removeAll(){
		eventResults.removeAll(eventResults);
		}

	public String toString() {
		return "Event: " + eventName + "Attempts: " + attempts + "Bigger better? Yes or no. " + biggerBetter;
	}
}

package idrottstavling;

import java.util.Scanner;
import java.util.ArrayList;

public class Competition extends StartCompetition {

	ArrayList<Participant> participants = new ArrayList<Participant>();
	ArrayList<Event> events = new ArrayList<Event>();

	boolean biggerBetter = false;
	int foundStartNumber = 0;
	

	Scanner scan = new Scanner(System.in);

	public void removeParticipant() {
		int participantNumber = scan.nextInt();
		scan.nextLine();
		boolean foundParticipant = false;
		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getStartNumber() == (participantNumber)) {
				foundParticipant = true;
		
				System.out.println(participants.remove(i) + "is removed.");
				break;
			} 
			}
		if (foundParticipant == false) {
			System.out.println("Deltagarnumret finns inte.");

		}
		foundParticipant = false;
	}

	public Participant findParticipant() {
		int participantNumber = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < participants.size(); i++) {
			if (participants.get(i).getStartNumber() == (participantNumber)) {
				foundStartNumber = participantNumber;
				return participants.get(i);
				
			} 
			
		}

		return null;
	}

	public Event findEvent() { //denna är false...
		
		String eventName = scan.nextLine();
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getEventName().equalsIgnoreCase(eventName)) {
				
				return events.get(i);
			}
		}
		
		return null;

	}

	public String scanString() {
		String s = scan.nextLine();
		s = s.toLowerCase().trim();
		s = Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
		return s;
	}

	
		public String messageFormat(String c, int m){
			return String.format("%1$"+m+"c", c);
		}
		
		//REMOVE ALL
//		public void removeAll(){
//			
//			participants.removeAll(participants);
//			events.removeAll(events);
//			Participant removeP = removeP.removeAll();
//			
//			}
		
		//reset startnumber??
		
		
		public void participantResults(){
			
		}
		
		
		public String padRight(String s, int n) {
		     return String.format("%1$-" + n + "s", s);  
		}

		public String padLeft(String s, int n) {
		    return String.format("%1$" + n + "s", s);  
		}
		
		public void showMessage(String ord){
			String star = "*";
			String repeatStar = new String(new char[60]).replace("\0", star);
			int totalSpaces = 58;
			String space = String.format("%"+ totalSpaces +"s", " ");
			
			
			if (ord.length()<56){
				totalSpaces = totalSpaces-ord.length();
			}else{
				ord = ord.substring(0, 56);
				totalSpaces = totalSpaces-ord.length();
			}
			int totalSpacesLeft = totalSpaces/2;
			
			if (ord.length() %2 != 0){
				totalSpacesLeft = totalSpaces/2+2;
			}else if(ord.length()!=56){
				totalSpacesLeft +=1;
			}
			
			for(int i=0;i<5;i++){
				if(i == 0 || i == 4){
					System.out.println(repeatStar);
				}else if(i == 1 || i == 3){
					System.out.print(star);
					System.out.print(space);
					System.out.println(star);
				}else if (i == 2){
					 System.out.print(padRight("* ", totalSpaces/2));
					 System.out.print(ord);
					 System.out.println(padLeft("", totalSpacesLeft) + "*");
				}
			}
		}
	

	public void starta() {

		for (;;) {
			
			System.out.println(
					"Make one of the following choices: \nAdd event \nAdd participant \nRemove participant \nAdd result \nParticipant "
							+ "\nEventname (enter the eventname) \nTeams \nMessage \nReinitialize  \nExit. ");
			
			String choice = scan.nextLine().toLowerCase();
			
			for (int i = 0; i < events.size(); i++) {
				if (events.get(i).getEventName().equalsIgnoreCase(choice)) {
				
				}
			}
			
			switch (choice) {

			// lägg till gren
			case "add event":
				System.out.println("Event name: ");
				String eventName = scanString();

				System.out.println("Attempts allowed: ");
				int attempts = scan.nextInt();
				scan.nextLine();

				System.out.println("BiggerBetter? (Y/N): ");
				String isBiggerBetter = scanString();

				if (isBiggerBetter.equals("Y")) {
					biggerBetter = true;
				} else {
					biggerBetter = false;

				}
				Event e = new Event(eventName, attempts, biggerBetter);
				events.add(e);

				System.out.println(eventName + " with " + attempts + " allowed attepmts, has been added!");
		
				break;

				// Lägg till deltagare
			case "add participant":
				
				System.out.println("First name: ");
				String firstName = scanString();

				System.out.println("Last name: ");
				String lastName = scanString();

				System.out.println("Team: ");
				String team = scanString();

			
				
				Participant p = new Participant(firstName, lastName, team);
				participants.add(p);

				System.out.println(firstName + " " + lastName + " from team " + team + " has been given participant number "
						+ p.getStartNumber());
				break;

			case "remove participant":
				System.out.println("Number: ");

				removeParticipant();

				break;

			case "add result":
				
				System.out.println("Number: ");
				Participant participantFound = findParticipant();
				if (participantFound == null) {
					System.out.println("There is no participant with that number");
					break;
				}
				System.out.println("Event: ");
				Event event = findEvent();
				if (event == null) {
					System.out.println("There is no such event");
					break;
				}
				
			
				if (participantFound != null && event!= null) {

					System.out.println("Result for " + participantFound.getFullName() + " from Team " + participantFound.getTeam() +
							": ");
					double result = Double.parseDouble(scan.nextLine());
					do{
						System.out.println("Must be greater than or equal to zero!");
						System.out.println("Result for " + participantFound.getFullName() + " from Team " + participantFound.getTeam() +
								": ");
						result = Double.parseDouble(scan.nextLine());
					} while (result<0);
					
					Result newResult = participantFound.getResultForEvent(event);
					if(newResult == null){
						newResult = new Result(participantFound, event);
						participantFound.addParticipantResult(newResult);
						event.addResult(newResult);
					} 
					
		
							newResult.addResult(result);

						
							System.out.println("Result added");
							
				}
				
				break;
				// // Visa resultatlista: deltagare
			case "participant":
				System.out.println("number: ");
				Participant partFound = findParticipant();
				if (partFound == null) {
					System.out.println("No participant with that number");
					break;
				}
				partFound.getResultForParticipants();
				
				
				
			// case "eventname":
				
				
			//case "teams":
				
			
				
//				case "reinitialize":
//				removeAll();
				
//				break;

				// Systemet avslutas
			case "exit":
				System.exit(0);

			default:
				if(choice.startsWith("message")){
					showMessage(choice.substring(8));
				} else {
				System.out.println("The alternative doesn't exist. Try again.");
				}
			}

		}
	}
}

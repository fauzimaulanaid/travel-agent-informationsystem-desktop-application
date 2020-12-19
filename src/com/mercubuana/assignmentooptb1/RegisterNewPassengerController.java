package com.mercubuana.assignmentooptb1;

import java.util.Date;

public class RegisterNewPassengerController {
	//We need to declare a static variable to record the selected ElfMicroBus
	private static ElfMicroBus savedSelectedElfMicroBus;
	//And we also nned a get method
	public static ElfMicroBus getSelectedElfMicroBus() {
		return savedSelectedElfMicroBus;
	}
	
	//A. Static method to save new passenger data
	public static void savePassengerData(String name, Date dateOfBirth) {
		//1. Create new passenger object
		/*We get the typeOfElfMicroBus of the passenger 
		 * from the typeOfElfMicroBus of the ElfMicroBus
		 * and we get the selected ElfMicroBus 
		 * from the selected ElfMicroBus data in the static variable
		 */
		Passenger newPassenger = new Passenger(name, 
				savedSelectedElfMicroBus.getTypeOfElfMicroBus(), dateOfBirth, 
				savedSelectedElfMicroBus);
		
		//2. Add the new passenger object to application global data
		ApplicationGlobalData.listOfPassenger.add(newPassenger);
		
		//3. Decrease the emptySeat attribute because now there is less capacity
		savedSelectedElfMicroBus.setEmptySeat(savedSelectedElfMicroBus.getEmptySeat()-1);
	}
	
	//Another static method to get the list of patient in the app global data
	public static String getListOfPassenger() {
		String listOfPassenger = "";
		for (Passenger p:ApplicationGlobalData.listOfPassenger) {
			listOfPassenger += String.format("Name: %s\n"
					+ "Type of Elf MicroBus: %s\n"
					+ "Date of Birth: %s\n"
					+ "Destination City: %s\n\n",
					p.getName(),
					p.getTypeOfElfMicroBus()=='L'?"Long MicroBus":"Short MicroBus",
					p.getDateOfBirth().toString(),
					p.getElfMicroBusOfPassenger().getNameOfDestination());
		}
		return listOfPassenger;
	}
	
	public static String searchAvailableElfMicroBus(char typeOfElfMicroBus) {
		String selectedElfMicroBus = "";
		/*1. Loop into each ElfMicroBus object in the global data to check for
		 * the suitable ElfMicroBus.
		 * The condition for suitable ElfMicroBus are:
		 * a. The typeOfElfMicroBus of the ELfMicroBus must be the same with the 
		 * typeOfElfMicroBus that the passenger need
		 * b. It must have at least one available seat (emptySeat>0)
		 * c. If condition a and b are fulfilled for ore than one ElfMicroBUs,
		 * then select the ElfMicroBus with more emptySeat.
		 */
		int mostEmptySeat = 0;
		for (ElfMicroBus e:ApplicationGlobalData.listOfElfMicroBus) {
			//1a. Check for condition a, b and c
			if (e.getTypeOfElfMicroBus()==typeOfElfMicroBus && e.getEmptySeat()>0 &&
					mostEmptySeat < e.getEmptySeat()) {
				//1a1. Set the selected ElfMicroBus to this ElfMicroBus obeject
				selectedElfMicroBus = e.getNameOfDestination();
				//1a2. Set the mostEmptySeat to this object's emptySeat
				mostEmptySeat = e.getEmptySeat();
				//1a3 Save the selected ward to a static variable
				savedSelectedElfMicroBus = e;
			}
		}
		return selectedElfMicroBus;
	}
}

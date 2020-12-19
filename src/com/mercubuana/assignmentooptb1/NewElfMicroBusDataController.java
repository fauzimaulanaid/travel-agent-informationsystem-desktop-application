package com.mercubuana.assignmentooptb1;

public class NewElfMicroBusDataController {
	public static void AddNewElfMicroBusData(String nameOfDestionation, char typeOfElfMicrobus,
			int capacity) {
		//Create a new Object from the ElfMicroBus Class, but first
		//we need to create the new ElfMicroBus class in eclipse
		//we will also add the new object to the class that hold
		//global application data
		ElfMicroBus newElfMicroBus = new ElfMicroBus(nameOfDestionation, typeOfElfMicrobus, capacity);
		ApplicationGlobalData.listOfElfMicroBus.add(newElfMicroBus);
	}
	
	public static String getListOfElfMicroBus() {
		String view = "";
		//use a loop to Build the view stringby using 
		//all the objects data in the class that hold the global data
		for (ElfMicroBus aElfMicroBus:ApplicationGlobalData.listOfElfMicroBus) {
			view += String.format("\nName of Destination: %s\n"
					+ "Type: %s\n"
					+ "Capacity %d\n\n", aElfMicroBus.getNameOfDestination(),
					aElfMicroBus.getTypeOfElfMicroBus()=='L'? "Long MicroBus": "Short MicroBus", 
						aElfMicroBus.getCapacity());
		}
		
		return view;
	}
}

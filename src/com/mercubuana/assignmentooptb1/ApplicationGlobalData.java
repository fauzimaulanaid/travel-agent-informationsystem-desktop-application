package com.mercubuana.assignmentooptb1;

import java.util.ArrayList;

public class ApplicationGlobalData {
	/*1. Declare a static variable, so it will be created
	 * even when the object of this class is not created
	 * The static variable is a list or collection that can hold multiple object in it
	 */
	public static ArrayList<ElfMicroBus> listOfElfMicroBus = new ArrayList<ElfMicroBus>();
	
	//Declare a static variable, to save the list of patients
	public static ArrayList<Passenger> listOfPassenger = new ArrayList<Passenger>();

}

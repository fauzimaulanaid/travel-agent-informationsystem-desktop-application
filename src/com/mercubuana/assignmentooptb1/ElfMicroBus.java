package com.mercubuana.assignmentooptb1;

import java.util.ArrayList;

public class ElfMicroBus {
	//Declare the variable
	private String nameOfDestination = "";
	private char typeOfElfMicroBus = 'L';
	private int capacity = 0;
	private int emptySeat = 0;
	
	/* Because a ward can have one-to-many association with severall patients,
	 * we need to declare the relationship as an attribute of the ward class
	 * (Import the corresponding package for ArrayList: Java util arraylist
	 */
	ArrayList<Passenger> listOfPassengerElfMicroBus = new ArrayList<Passenger>();
	
	//This is the Constructor
	public ElfMicroBus(String nameOfDestination, char typeOfElfMicroBus, int capacity) {
		super();
		this.nameOfDestination = nameOfDestination;
		this.typeOfElfMicroBus = typeOfElfMicroBus;
		this.capacity = capacity;
		this.emptySeat = capacity;
	}

	public String getNameOfDestination() {
		return nameOfDestination;
	}

	public void setNameOfDestination(String nameOfDestination) {
		this.nameOfDestination = nameOfDestination;
	}

	public char getTypeOfElfMicroBus() {
		return typeOfElfMicroBus;
	}

	public void setTypeOfElfMicroBus(char typeOfElfMicroBus) {
		this.typeOfElfMicroBus = typeOfElfMicroBus;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getEmptySeat() {
		return emptySeat;
	}

	public void setEmptySeat(int emptySeat) {
		this.emptySeat = emptySeat;
	}
	
	
	
	
}

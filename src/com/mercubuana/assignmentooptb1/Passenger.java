package com.mercubuana.assignmentooptb1;

import java.util.Date;

public class Passenger {
	//List of Attributes
	private String name;
	private char typeOfElfMicroBus = 'L';
	private Date dateOfBirth; //we have to import java util date
	private ElfMicroBus elfMicroBusOfPassenger;
	
	//Contructor
	public Passenger(String name, char typeOfElfMicroBus, Date dateOfBirth, ElfMicroBus elfMicroBusOfPassenger) {
		super();
		this.name = name;
		this.typeOfElfMicroBus = typeOfElfMicroBus;
		this.dateOfBirth = dateOfBirth;
		this.elfMicroBusOfPassenger = elfMicroBusOfPassenger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getTypeOfElfMicroBus() {
		return typeOfElfMicroBus;
	}

	public void setTypeOfElfMicroBus(char typeOfElfMicroBus) {
		this.typeOfElfMicroBus = typeOfElfMicroBus;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public ElfMicroBus getElfMicroBusOfPassenger() {
		return elfMicroBusOfPassenger;
	}

	public void setElfMicroBusOfPassenger(ElfMicroBus elfMicroBusOfPassenger) {
		this.elfMicroBusOfPassenger = elfMicroBusOfPassenger;
	}
	
	
	
	
	
}

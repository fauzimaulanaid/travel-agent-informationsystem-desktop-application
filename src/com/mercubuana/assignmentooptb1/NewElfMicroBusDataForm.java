package com.mercubuana.assignmentooptb1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewElfMicroBusDataForm {

	private JFrame frmNewTravelMicrobus;
	private JTextField txtNameOfDestination;
	private JTextField txtCapacity;
	private JComboBox cmbTypeOfElfMicroBus;
	
	//	This is for the collection of MicroBus, so our program can hhold and display data
	//	for more than one MicroBus object
	private ArrayList<ElfMicroBus> listOfElfMicroBus = new ArrayList<ElfMicroBus>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewElfMicroBusDataForm window = new NewElfMicroBusDataForm();
					window.frmNewTravelMicrobus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewElfMicroBusDataForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewTravelMicrobus = new JFrame();
		frmNewTravelMicrobus.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				/*If the add new ward data form is closed, this event will be
				 * trigerred. In this event we will do 2 steps
				 */
				
				//1. Open the main menu form
				MainMenuForm.main(null);
				//2. Dispose this form
				frmNewTravelMicrobus.dispose();
			}
		});
		frmNewTravelMicrobus.setTitle("New Travel MicroBus Form");
		frmNewTravelMicrobus.setBounds(100, 100, 330, 228);
		frmNewTravelMicrobus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNewTravelMicrobus.getContentPane().setLayout(null);
		
		JLabel lblDestinationName = new JLabel("Name of Destination:");
		lblDestinationName.setBounds(10, 22, 128, 21);
		frmNewTravelMicrobus.getContentPane().add(lblDestinationName);
		
		txtNameOfDestination = new JTextField();
		txtNameOfDestination.setBounds(141, 22, 114, 20);
		frmNewTravelMicrobus.getContentPane().add(txtNameOfDestination);
		txtNameOfDestination.setColumns(10);
		
		JLabel lblType = new JLabel("Type of Elf MicroBus:");
		lblType.setBounds(10, 54, 128, 16);
		frmNewTravelMicrobus.getContentPane().add(lblType);
		
		txtCapacity = new JTextField();
		txtCapacity.setBounds(141, 85, 114, 20);
		frmNewTravelMicrobus.getContentPane().add(txtCapacity);
		txtCapacity.setColumns(10);
		
		cmbTypeOfElfMicroBus = new JComboBox();
		cmbTypeOfElfMicroBus.setModel(new DefaultComboBoxModel(new String[] {"Long MicroBus", "Short MicroBus"}));
		cmbTypeOfElfMicroBus.setBounds(141, 50, 114, 25);
		frmNewTravelMicrobus.getContentPane().add(cmbTypeOfElfMicroBus);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBounds(10, 87, 55, 16);
		frmNewTravelMicrobus.getContentPane().add(lblCapacity);
		
		JButton btnSaveMicroBusData = new JButton("Save New Elf MicroBus Data");
		btnSaveMicroBusData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Read data from user in the GUI Components
				String nameOfDestination = txtNameOfDestination.getText();
				
				//Set the default type to Short MicroBus('S')
				char typeOfElfMicroBus = 'L';
				
				//Convert "local" comboBox into "field" comboBox
				//Check the selected type in the "cmbType" component
				if (cmbTypeOfElfMicroBus.getSelectedIndex() != 0) {
					//If its not equal to zero, then it means that the second
					//option (index==1) is selected, So we change the type
					//Long MicroBus ('L')
					typeOfElfMicroBus = 'S';
				}
				
				//Get numeric data from the GUI Component
				String temp = txtCapacity.getText();
				
				//Convert string from the GUI component to the numeric data
				int capacity = 0;
				try {
					capacity = Integer.parseInt(temp);
				} catch (NumberFormatException e) {
					//IF there is error while converting the string into numeric (line 105)
					//, the execution of code will show the error message (line 109)
					JOptionPane.showMessageDialog(null,
							"The number in capacity field is not valid."
							+ "Please fix the number");
					
					//Return and get out from this function (line 117, 118,...)
					return;
				}
				
				//4. Create a new ElfMicroBus Object by calling a static method in the
				//controller class.
				//Calling a static method can be done without even creating a controller
				//object of the controller class
				NewElfMicroBusDataController.AddNewElfMicroBusData(nameOfDestination, typeOfElfMicroBus, capacity);
				
				
				//Generate a string to hold newMicroBus objects attributes
				String view = "List of Elf MicroBus:\n";
				
				/* Get the list of ward by calling a static method in the controller
				 * class
				 */
				view += NewElfMicroBusDataController.getListOfElfMicroBus();
				
				//And now display the string
				JOptionPane.showMessageDialog(null, view);
			}
		});
		btnSaveMicroBusData.setBounds(10, 125, 245, 26);
		frmNewTravelMicrobus.getContentPane().add(btnSaveMicroBusData);
	}

}

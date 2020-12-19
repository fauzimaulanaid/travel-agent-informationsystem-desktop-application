package com.mercubuana.assignmentooptb1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JPanel;

public class RegisterNewPassengerForm {

	private JFrame frmRegisterNewPassenger;
	private JTextField txtnameOfDestination;
	private JTextField txtNameOfPassenger;
	private JTextField textDateOfBirth;
	private JPanel panelPassengerData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterNewPassengerForm window = new RegisterNewPassengerForm();
					window.frmRegisterNewPassenger.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterNewPassengerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisterNewPassenger = new JFrame();
		frmRegisterNewPassenger.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				//1. Open the main menu form
				MainMenuForm.main(null);
				
				/*We dont actually need call the dispose method here.
				 * Because we have already define it in the default close operation
				 * property
				 */
			}
		});
		frmRegisterNewPassenger.setTitle("Register New Passenger");
		frmRegisterNewPassenger.setBounds(100, 100, 415, 334);
		frmRegisterNewPassenger.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegisterNewPassenger.getContentPane().setLayout(null);
		
		JLabel lblTypeOfElfmicrobus = new JLabel("Type of Elf MicroBus that Passenger need:");
		lblTypeOfElfmicrobus.setBounds(10, 24, 249, 14);
		frmRegisterNewPassenger.getContentPane().add(lblTypeOfElfmicrobus);
		
		JComboBox cmbTypeOfElfMicroBus = new JComboBox();
		cmbTypeOfElfMicroBus.setModel(new DefaultComboBoxModel(new String[] {"Long MicroBus", "Short MicroBus"}));
		cmbTypeOfElfMicroBus.setBounds(256, 19, 118, 25);
		frmRegisterNewPassenger.getContentPane().add(cmbTypeOfElfMicroBus);
		
		JButton btnSearchAvailableElf = new JButton("Search Available Elf MicroBus");
		btnSearchAvailableElf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Search for available Elf MicroBus
				
				//Read the typeOfElfMicroBus that passenger need
				char typeOfElfMicroBus = 'L';
				if (cmbTypeOfElfMicroBus.getSelectedIndex()==1) {
					typeOfElfMicroBus = 'S';
				}
				
				/*Call a static method in the controller to return
				 * the name of the available ElfMicroBus or to display an error message
				 * if there is no available ward
				 */
				String selectedElfMicroBus = RegisterNewPassengerController.searchAvailableElfMicroBus(typeOfElfMicroBus);
				
				/*Check if the selected ElfMicroBus is not empty.
				 * (Note the way of comparing string, without equal sign ==)
				 */
				if (selectedElfMicroBus.equals("")) {
					JOptionPane.showMessageDialog(null, "There is no available Elf MicroBus");
					return;
				}
				txtnameOfDestination.setText(selectedElfMicroBus);
				panelPassengerData.setVisible(true);
				
			}
		});
		btnSearchAvailableElf.setBounds(10, 59, 364, 26);
		frmRegisterNewPassenger.getContentPane().add(btnSearchAvailableElf);
		
		JLabel lblSelectedElfMicrobus = new JLabel("Selected Elf MicroBus:");
		lblSelectedElfMicrobus.setBounds(10, 109, 143, 16);
		frmRegisterNewPassenger.getContentPane().add(lblSelectedElfMicrobus);
		
		txtnameOfDestination = new JTextField();
		txtnameOfDestination.setEditable(false);
		txtnameOfDestination.setBounds(164, 107, 131, 20);
		frmRegisterNewPassenger.getContentPane().add(txtnameOfDestination);
		txtnameOfDestination.setColumns(10);
		
		panelPassengerData = new JPanel();
		panelPassengerData.setVisible(false);
		panelPassengerData.setBounds(10, 148, 377, 135);
		frmRegisterNewPassenger.getContentPane().add(panelPassengerData);
		panelPassengerData.setLayout(null);
		
		JLabel lblNameOfPassenger = new JLabel("Name of Passenger:");
		lblNameOfPassenger.setBounds(12, 12, 123, 16);
		panelPassengerData.add(lblNameOfPassenger);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setBounds(12, 40, 123, 16);
		panelPassengerData.add(lblDateOfBirth);
		
		txtNameOfPassenger = new JTextField();
		txtNameOfPassenger.setBounds(153, 10, 212, 20);
		panelPassengerData.add(txtNameOfPassenger);
		txtNameOfPassenger.setColumns(10);
		
		textDateOfBirth = new JTextField();
		textDateOfBirth.setBounds(153, 38, 131, 20);
		panelPassengerData.add(textDateOfBirth);
		textDateOfBirth.setColumns(10);
		
		JButton btnSavePassengerData = new JButton("Save Passenger Data");
		btnSavePassengerData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//to save passenger data, there are several steps to do
				//1. Get the data from GUI
				String name = txtNameOfPassenger.getText();
				
				/*1a. For now, we just create a dummy date without reading the date
				 * from the GUI. Later during the database recording sessions,
				 * we will modify this. Don forget to import java util date
				 */
				Date dateOfBirth = new Date();
				
				//2. create patient data by calling a static method in controller
				RegisterNewPassengerController.savePassengerData(name, dateOfBirth);
				
				//3. Get all of patient list by calling a static method in controller
				//3a. Declare the display string
				String display = "List of all Passenger in the Fauzi Travel:\n\n";
				
				//3b. Call a static method
				display += RegisterNewPassengerController.getListOfPassenger();
				
				//4. Display the list of all patients
				JOptionPane.showMessageDialog(null, display);
				
				//5. Turn off the panel, so user have to click search again
				panelPassengerData.setVisible(false);
				
			}
		});
		btnSavePassengerData.setBounds(12, 79, 166, 26);
		panelPassengerData.add(btnSavePassengerData);
	}
}

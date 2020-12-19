package com.mercubuana.assignmentooptb1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuForm {

	private JFrame frmFauziTravelAgent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuForm window = new MainMenuForm();
					window.frmFauziTravelAgent.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFauziTravelAgent = new JFrame();
		frmFauziTravelAgent.setTitle("Fauzi Travel Agent Information System");
		frmFauziTravelAgent.setBounds(100, 100, 450, 300);
		frmFauziTravelAgent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFauziTravelAgent.getContentPane().setLayout(null);
		
		JButton btnAddNewElfMicroBus = new JButton("Add New Elf MicroBus");
		btnAddNewElfMicroBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewElfMicroBusDataForm.main(null);
				frmFauziTravelAgent.dispose();
			}
		});
		btnAddNewElfMicroBus.setBounds(116, 41, 186, 40);
		frmFauziTravelAgent.getContentPane().add(btnAddNewElfMicroBus);
		
		JButton btnRegisterNewPassenger = new JButton("Register New Passenger");
		btnRegisterNewPassenger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterNewPassengerForm.main(null);
				frmFauziTravelAgent.dispose();
			}
		});
		btnRegisterNewPassenger.setBounds(116, 93, 186, 40);
		frmFauziTravelAgent.getContentPane().add(btnRegisterNewPassenger);
	}

}

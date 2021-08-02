package com.ss.uto.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.ss.uto.service.AdminService;

public class Main {

	public static void main(String[] args) throws SQLException {

		// Generate objects for menu pages
		Agent agent = new Agent();
		Admin admin = new Admin();
		Traveler traveler = new Traveler();

		// Set scanner to collect user input
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Utopia Airlines Management System. Which category of a user are you");

		// Menu infinite loop
		while (true) {
			// Display menu options
			System.out.println("1) Employee/Agent");
			System.out.println("2) Administrator");
			System.out.println("3) Traveler");

			// Collect user selection
			String input = scan.nextLine();

			// Enter sub menu based on user selection or loop if invalid input
			if (input.equals("1")) {
				// Take user to the agent menu for interaction
				agent.agentMenu();
			} else if (input.equals("2")) {
				// Take user to the administrator menu for interaction
				admin.adminMenu();
			} else if (input.equals("3")) {
				// Take user to the traveler menu for interaction
				traveler.travelerMenu();
			} else {
				System.out.println("Incorrect input.\n");
			}
		}

	}

}

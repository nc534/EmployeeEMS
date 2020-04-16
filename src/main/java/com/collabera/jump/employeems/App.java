package com.collabera.jump.employeems;

import java.util.Scanner;

import com.collabera.jump.ems.app.EmployeeManagementSystem;
import com.collabera.jump.ems.model.Employee;
import com.collabera.jump.ems.util.ScannerUtil;
import com.collabera.jump.ems.util.ScannerUtil.Result;
import com.collabera.jump.ems.util.ScannerUtil.TYPES;

public class App {

	private static boolean exitFlag = true;

	public static void main(String[] args) {

		EmployeeManagementSystem ems = new EmployeeManagementSystem();

		// ScannerUtil scannerUtil = new ScannerUtil();

//		System.out.println("++++++++++++++++++++");
//		System.out.println("+++++++++EMS++++++++");
//		System.out.println("++++++++++++++++++++");
		
		System.out.println(
				" #####  ####### #       #          #    ######  ####### ######     #    \n" + 
				"#     # #     # #       #         # #   #     # #       #     #   # #   \n" + 
				"#       #     # #       #        #   #  #     # #       #     #  #   #  \n" + 
				"#       #     # #       #       #     # ######  #####   ######  #     # \n" + 
				"#       #     # #       #       ####### #     # #       #   #   ####### \n" + 
				"#     # #     # #       #       #     # #     # #       #    #  #     # \n" + 
				" #####  ####### ####### ####### #     # ######  ####### #     # #     # \n" + 
				"                                                                        \n" + 
				"");

		System.out.println(
				" _       __     __                             __           ________  ________\n" + 
				"| |     / /__  / /________  ____ ___  ___     / /_____     / ____/  |/  / ___/\n" + 
				"| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / __/ / /|_/ /\\__ \\ \n" + 
				"| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /___/ /  / /___/ / \n" + 
				"|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/  /_____/_/  /_//____/  \n" + 
				"                                                                              ");

		do {
			System.out.println("Please choose an option to proceed:");

			System.out.println("1. CREATE");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SEARCH");
			System.out.println("5. EXIT");
			
			Employee emp = new Employee();
			
			Employee emp1 = new Employee();
			
			if( emp.equals(emp1))
			{
				System.out.println("They are same employee");
			}

			Result option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 5);

			switch (option.getValueAsInt()) {
			case 1: {
				System.out.println("Please choose an option to proceed:");
				System.out.println("1. EMPLOYEE");
				System.out.println("2. MANAGER");
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 2);
				// scanner.nextLine();
				switch (option.getValueAsInt()) {
				case 1:
					ems.createEmployeeWithInputs();
					break;
				case 2:
					System.out.println("Create Manager");
					ems.createEmployeeWithInputs();
					ems.createManagerWithInputs();
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}

			}
				break;
				
			case 2:
				 Scanner stdin = new Scanner(System.in);

				 System.out.println("Enter the employee's ID to be updated:");
				      ems.updateEmployee(Integer.parseInt(stdin.nextLine()));
				
				break;
				
			case 3:
				System.out.println("Deleting record.");
				System.out.println("Which column to delete from: \n"
						+ "1.emp_id \n"
						+ "2.emp_snn \n"
						+ "3.emp_email_id \n"
						+ "4.emp_name \n"
						+ "5.emp_age \n");
			
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 5);
				
				switch (option.getValueAsInt()) {
				
					case 1:
					case 2:	
					case 3:
					case 4:
					case 5:
						ems.deleteEmployee(emp, option.getValueAsInt());
						break;
					default:
						System.out.println("Invalid Input");
						break;
				
				}
				break;
				
			case 4:
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Please enter the number of the field you want to search by.");
				System.out.println("1. ID | 2. Name");
				String input = sc.nextLine();
				System.out.println("Please enter the value for this field.");
				String value = sc.nextLine();
				
				switch (input) {
				case "1" :
					try {
						ems.getEmployeeWithId(Integer.valueOf(value));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
					
					
				case "2" :
						ems.getEmployeeWithName(value);
					break;				
				}
				break;
				
			case 5:
				exitFlag = false;
				System.out.println("Thanks for using EMS!");
				break;
			default:
				break;
			}
		} while (exitFlag);

		ScannerUtil.close();

	}

}

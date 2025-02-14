
import java.io.File;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;



public class AADASunopto {

	public static Scanner reader = new Scanner(System.in); // declaring all strings that will be produced from the csv
															// file into the array.
	public final String SEP = (",");
	public String Eventid;
	public String InvestigationType;
	public String accidetnNumber;
	public String EventDate;
	public static int Eventyear;
	public String Location;
	public String Country;
	public String Latitude;
	public String Longitude;
	public String Airportcode;
	public String AirportName;
	public String InjurySeverity;
	public String AircraftDamage;
	public String AircraftCategory;
	public String RegistrationNumber;
	public String Make;
	public String Model;
	public String AmateurBuilt;
	public String NunberOfEngines;
	public String EngineType;
	public String FARDescription;
	public String Schedule;
	public String PurposeOfFlight;
	public String AirCarrier;
	public int TotalFatalInjuries;
	public int TotalSeriousInjuries;
	public int TotalMinorInjuries;
	public int TotalUninjured;
	public String WeatherCondition;
	public String BroadPhaseofFlight;
	public String ReportStatus;
	public String PublicationDate;

	public AADASunopto(String csvString) { // reading the strings into an array
		String[] csvParts = parseCSV(csvString); // csvString.split(SEP, -1);
		int i = 0;
		Eventid = csvParts[i++];
		InvestigationType = csvParts[i++];
		accidetnNumber = csvParts[i++];
		EventDate = csvParts[i++];
		Location = csvParts[i++];
		Country = csvParts[i++];
		Latitude = csvParts[i++];
		Longitude = csvParts[i++];
		Airportcode = csvParts[i++];
		AirportName = csvParts[i++];
		InjurySeverity = csvParts[i++];
		AircraftDamage = csvParts[i++];
		AircraftCategory = csvParts[i++];
		RegistrationNumber = csvParts[i++];
		Make = csvParts[i++];
		Model = csvParts[i++];
		AmateurBuilt = csvParts[i++];
		NunberOfEngines = csvParts[i++];
		EngineType = csvParts[i++];
		FARDescription = csvParts[i++];
		Schedule = csvParts[i++];
		PurposeOfFlight = csvParts[i++];
		AirCarrier = csvParts[i++];
		TotalFatalInjuries = safeParse(csvParts[i++]);
		TotalSeriousInjuries = safeParse(csvParts[i++]);
		TotalMinorInjuries = safeParse(csvParts[i++]);
		TotalUninjured = safeParse(csvParts[i++]);
		WeatherCondition = csvParts[i++];
		BroadPhaseofFlight = csvParts[i++];
		ReportStatus = csvParts[i++];
		PublicationDate = csvParts[i++];

	}

	
	
	// String method to read locations in " " and split them with comma
	public static String[] parseCSV(String csv) {
		String[] split = new String[0];

		ArrayList<String> strings = new ArrayList<>();
		boolean inQuotes = false;
		String currentString = "";
		for (char c : csv.toCharArray()) {

			if (c == '\"') { // switch modes = in quotes or not
				inQuotes = !inQuotes;
				continue;
			}

			if (!inQuotes && c == ',') { // if a comma, but not in quotes
				strings.add(currentString); // add to list of output strings
				currentString = ""; // blank "current" string
				continue;
			}

			currentString = currentString + c; // concatenate current string

		}
		strings.add(currentString);

		split = new String[strings.size()];
		split = strings.toArray(split);

		return split;
	}

	

	public static int safeParse(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}

	}

	public String toCSVString() { // how to strings will be formatted if all were printed and how they can be
									// called from the array list
		return Eventid + SEP + InvestigationType + SEP + accidetnNumber + SEP + EventDate + SEP + Location + SEP
				+ Country + SEP + Latitude + SEP + Longitude + SEP + Airportcode + SEP + AirportName + SEP
				+ InjurySeverity + SEP + AircraftDamage + SEP + AircraftCategory + SEP + RegistrationNumber + SEP + Make
				+ SEP + Model + SEP + AmateurBuilt + SEP + NunberOfEngines + SEP + EngineType + SEP + FARDescription
				+ SEP + Schedule + SEP + PurposeOfFlight + SEP + AirCarrier + SEP + TotalFatalInjuries + SEP
				+ TotalSeriousInjuries + SEP + TotalMinorInjuries + TotalUninjured + SEP + WeatherCondition + SEP
				+ BroadPhaseofFlight + SEP + ReportStatus + SEP + PublicationDate;

	}

	public String getYear() {
		return EventDate.substring(6, 10);
	}

	public int getYearparse() {
		return Eventyear = Integer.parseInt(getYear());

	}

	public int compare(MakeRecord p1, MakeRecord p2) {
		if (p1.getmakemodel().compareTo(p2.getmakemodel()) < 0) {
			return -1;
		} else if (p1.getmakemodel().compareTo(p2.getmakemodel()) > 0) {
			return 1;
		}
		return 0;
	}

	public static void insertSortint (ArrayList<String> yearslisted) {
		for (int i = 1; i < yearslisted.size(); i++) {
			for (int j = i; j > 0; j--) {
				String lower = yearslisted.get(j - 1);
				String higher = yearslisted.get(j);
				if (higher.compareTo(lower) < 0) {
					yearslisted.set(j, lower);
					yearslisted.set(j - 1, higher);
				} else
					break;
			}
		}
	}

	public static void insertSort(List<MakeRecord> list) {
		for (int i = 1; i < list.size(); i++) {
			for (int j = i; j > 0; j--) {
				MakeRecord lower = list.get(j - 1);
				MakeRecord higher = list.get(j);
				if (higher.compareTo(lower) < 0) {
					list.set(j, lower);
					list.set(j - 1, higher);
				} else
					break;
			}
		}
	}
	// main method currently contains file reader and basic menu system to be
	// updated as more work is added
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(
				"Welcome to the Air Accident data Analysis System. \nBelow are the available search options: ");
		menu();

	}

	// test class which outputs all data from csv to test file size
	private static void outputCrashes(List<AADAS> crash) {
		for (int i = 0; i < crash.size(); i++) {
			AADAS currentCrash = crash.get(i);
			if (currentCrash != null) {
				System.out.println("Crash id: " + currentCrash.Eventid + " Investigation Type: "
						+ currentCrash.InvestigationType + " Accident Number: " + currentCrash.accidetnNumber
						+ " Event Date: " + currentCrash.EventDate + " Location: " + currentCrash.Location
						+ " country: " + currentCrash.Country + " Latitude: " + currentCrash.Latitude + " Longitude: "
						+ currentCrash.Longitude + " Airport Code: " + currentCrash.Airportcode + " Airport name: "
						+ currentCrash.AirportName + " Injury Severity: " + currentCrash.InjurySeverity
						+ " Aircraft Damage: " + currentCrash.AircraftDamage + " Aircraft Catagory: "
						+ currentCrash.AircraftCategory + " Registration Number " + currentCrash.RegistrationNumber
						+ " Make: " + currentCrash.Make + " Model " + currentCrash.Model + " Amateur built: "
						+ currentCrash.AmateurBuilt + " Number of engines: " + currentCrash.NunberOfEngines
						+ " Engine type: " + currentCrash.EngineType + " FAR Description: "
						+ currentCrash.FARDescription + " Schedule: " + currentCrash.Schedule + " Purpose of flight: "
						+ currentCrash.PurposeOfFlight + " Air Carrier: " + currentCrash.AirCarrier
						+ " Total Fatal injuries: " + currentCrash.TotalFatalInjuries + " Total Serious Injuries: "
						+ currentCrash.TotalSeriousInjuries + " Total Minor injuries: "
						+ currentCrash.TotalMinorInjuries + " Total Uninjured: " + currentCrash.TotalUninjured
						+ " Weather condition: " + currentCrash.WeatherCondition + " Broad phase of flight: "
						+ currentCrash.BroadPhaseofFlight + " Report status: " + currentCrash.ReportStatus
						+ " Publication Date: " + currentCrash.PublicationDate);

			}
		}

	}

	// FEATURE A - OUTPUT ALL YEARS - UNOPTOMIZED DONE
	public static void FeatureA(List<AADAS> crash) { // DECLARE PUBLIC CLASS

		ArrayList<String> yearslisted = new ArrayList<String>();
		ArrayList<String> years = new ArrayList<String>(); 
		
		// declare array lists
		
		for (int i = 0; i < crash.size(); i++) { 				//loop through whole file
			AADAS currentCrash = crash.get(i);					//current crash = current crash element
			years.add(currentCrash.getYear());					//add current crash year to array parse it using get year method to only get 4 digits for the year
			String yearsinarray = currentCrash.getYear();		//yearsinarray becomes current year element for comparison purpose
			if (!yearslisted.contains(yearsinarray)) 			//if yearslistedarray does not contain yearsinarray 
			{
				yearslisted.add(yearsinarray);					//add year element to array if if statement is met
			}

		}

		insertSortint(yearslisted);						

		

		for (String counter : yearslisted) {                    //For length of years listed
			System.out.println(counter);						//print years

			}
		}

	// FEATURE B - OUTPUT PHASES OF FLGHT - UNOPTOMIZED DONE
	public static void FeatureB(List<AADAS> crash) {

		ArrayList<String> phaseslisted = new ArrayList<String>();
		ArrayList<String> phases = new ArrayList<String>();
		
		// declare array lists
		
		for (int i = 0; i < crash.size(); i++){ 					//loop through whole file
			AADAS currentCrash = crash.get(i); 						//current crash = current crash element
			phases.add(currentCrash.BroadPhaseofFlight); 			//add all broadphaseofflights elements to the array phases
			String phasesinarray = currentCrash.BroadPhaseofFlight; // String phases in array = current phase of flight for comparison purposes
			if (!phaseslisted.contains(phasesinarray)) {			//if no match add element to the array
				phaseslisted.add(phasesinarray);					//add if if statement is met
	        }

		}

		for (int i = 0; i < phaseslisted.size(); i++)  {			//for length of array of added elements
			System.out.println(phaseslisted.get(i));				// print out loop iterations 
		}

		System.out.println("\nThere are " + phaseslisted.size() + " phases of flight stages available");  // print out array size with message letting user know how many options are available
	    }

	// FEATURE C - OUTPUT SPECIFIC PHASE OF FLIGHT AND YEAR DATA - UNOPTOMIZED DONE
	public static void FeatureC(List<AADAS> crash) {

		
		String inputflight = ""; 																			//declare new string
		String inputyear = ""; 																				//declare new string

		System.out.println("Please specify the phase of flight you would like to view the options are:\n"); //Output message to user prompting them to input option
		
		FeatureB(crash); 																					// call method to output all phases of flight
		
		System.out.println("\nSelection: ");                                                                // print out prompt for user to enter choice
		inputflight = reader.nextLine().toUpperCase(); 														// input flight will store what user types and will make each character uppercase

		System.out.println("\nPlease specify the year you would like to view the options are:\n"); 			//Output message to user prompting them to input option
		
		FeatureA(crash); 					                                                         		//Call method to output years
		
		System.out.println("\nYear selection: "); 															// prompt for year input
		inputyear = reader.nextLine(); 																		// take year input

		List<AADAS> matches = new ArrayList<>(); 															// initalise new arraylist called matches

		for (AADAS c : crash) {                                                                             // reading through inital array list through whole csv
			if (c.BroadPhaseofFlight.equals(inputflight) && c.getYear().equals(inputyear)) 					// if statement
																							
			matches.add(c);                                                                                 // if conditions met add whole string of data into new array 

		}

		outputCrashes(matches);                                                                             //method to output all crashes that are stored in array
		
		System.out.println("\nThere are " + matches.size() + " records that contain " + inputflight + " and match the year " + inputyear); // Ouput message to user saying how many records matched conditions

        }

	// FEATURE D - OUTPUT SPECIFIC OPTIONS FROM MENU - UNOPTOMIZED DONE
	public static void FeatureD(List<AADAS> crash) throws FileNotFoundException {

	
		while (!reader.equals("Q")) { 																										//While statement stateing if user input doesnt equal q run loop
			
			// MENU SYSTEM
			// each option will print what is stated by matching conditons in arrays and printing correct elements
			
			System.out.println("\n1 - Flights that killed everybody aboard");
			System.out.println("2 - Flights that were deadly but the amount of survivors was greater than or equal to the amount perished");
			System.out.println("3 - Flights that were not deadly but resulted in serious or minor inujury");
			System.out.println("4 - Flights that resulted in no fatalities or injuries");
			System.out.println("Q - Quit to main menu ");
			System.out.print("\nSelection: ");
			
			String selection = reader.nextLine().toUpperCase();																				//new string selection = next input if letter will set to uppercase incase user inputs Q

			// MENU OPTION 1 
			
			if (selection.equals("1")) {
				List<AADAS> matches = new ArrayList<>(); 																					//initalise new arraylist called matches
				int p = 0;																													//Declare new int which will count iterations
				for (AADAS c : crash) { 																									//reading through inital array list through whole csv
					if (c.TotalSeriousInjuries == 0 && c.TotalUninjured == 0 && c.TotalMinorInjuries == 0 && c.TotalFatalInjuries > 1)      //if statement 
					
					{ 																			
						matches.add(c); // add into array matches                                                                           //if conditions met add to arry
						p++;                                                                                                                //++ to track iterations
					}
				}
				
				outputCrashes(matches); 																									//output the new array
				System.out.println("\nThere are " + p + " records that match the criteria of eveybody onboard dying");                      //outout how many iterations there were with message for user
				
				FeatureESubMenu(); 																											//method to print sub menu
				String choice = reader.nextLine().toUpperCase(); 																			//scanner to uppercaase

				if (choice.equals("Y")) { 																									//if statment for user choice
					
																																			//initalize new string 
					menuFeatureE(matches); 																									// output menu method which has method inside to carry out options from menu

				} else if (choice.contentEquals("N")) { 																					//if user types "n" return them to feature 4 menu
					
					FeatureD(null);                                                                                                         //if user types N rerun featureD method
				
				} else {
					
					menu(); 																												// else return them to main menu
				
				}

				// MENU OPTION 2
				// TO SEE COMMENTS ON WORKING LOOK AT MENU OPTION 1 AS CODE LAYOUT IS COPY

			} else if (selection.equals("2")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalFatalInjuries >= 1
							&& c.TotalSeriousInjuries + c.TotalMinorInjuries >= c.TotalFatalInjuries) {
						// if user inputs meets conditions add that current csv string in to the array
						matches.add(c); // add into array matches
						p++;

					}

				}

				outputCrashes(matches);
				System.out.println("There are " + p
						+ " records that match the criteria of the flight being deadly but the amount of surviviors being greater or equal to the amount perished");
				FeatureESubMenu();
				String choice = reader.nextLine().toUpperCase();
				if (choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeatureE(matches);
					// while loop to output menu and read the users input

				} else if (choice.contentEquals("N")) {
					FeatureD(null);
				} else {
					menu();
				}
			}

			// MENU OPTION 3
			// TO SEE COMMENTS ON WORKING LOOK AT MENU OPTION 1 AS CODE LAYOUT IS COPY

			else if (selection.equals("3")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalFatalInjuries == 0 && c.TotalSeriousInjuries >= 1 && c.TotalMinorInjuries >= 1) { // if
																													// user
																													// inputs
																													// meets
																													// conditions
																													// add
																													// that
																													// current
																													// csv
																													// string
																													// to
																													// the
																													// array
						matches.add(c); // add into array matches
						p++;

					}

				}

				outputCrashes(matches);
				System.out.println("There are " + p + " records that match the criteria");
				FeatureESubMenu();
				String choice = reader.nextLine().toUpperCase();
				if (choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeatureE(matches);
					// while loop to output menu and read the users input

				} else if (choice.contentEquals("N")) {
					FeatureD(null);
				} else {
					menu();
				}
			}

			// MENU OPTION 3
			// TO SEE COMMENTS ON WORKING LOOK AT MENU OPTION 1 AS CODE LAYOUT IS COPY

			else if (selection.equals("4")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalFatalInjuries == 0 && c.TotalSeriousInjuries == 0 && c.TotalMinorInjuries == 0) {

						matches.add(c); // add into array matches
						p++;
					}
				}

				outputCrashes(matches);
				System.out.println("There are " + p
						+ " records that match the criteria of flights that had 0 fatalities or injuries");
				FeatureESubMenu();
				String choice = reader.nextLine().toUpperCase();
				if (choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeatureE(matches);
					// while loop to output menu and read the users input

				} else if (choice.contentEquals("N")) {
					FeatureD(null);
				} else {
					menu();

				}
			} else if (selection.equals("Q")) { // if selection is quit from feature 4 menu return to main menu
				menu();
			} else {
				System.out.println("\nPlease enter a valid input from the menu system\n"); // if not valid input retrun
																							// this message
			}
		}

	}

	// FEATURE E - PHASE OF FLIGHT - UNOPTOMIZED DONE
	public static void FeatureEphase(List<AADAS> crash) throws FileNotFoundException {
		
		String inputflight = "";																			 //initalize new string
		
		System.out.println("Please specify the phase of flight you would like to view the options are:\n");  //output prompt to user 
		
		FeatureB(crash); 																					 //call method to output all phases of flight
		
		System.out.println("\nSelection: ");                                                                 //print out prompt for user to enter choice
		inputflight = reader.nextLine().toUpperCase();                                                       //input for user must always go to uppercase as csv is uppercase

		List<AADAS> matches = new ArrayList<>();                                                             //initalise new arraylist called matches

		for (AADAS c : crash) { 																			 //for loop
			if (c.BroadPhaseofFlight.equals(inputflight))                                                    //if conditions
															
				matches.add(c); 																			 //add into array matches

		} 

		outputCrashes(matches); 																			 //call method to output all crashes with the array matches for what to print
		System.out.println("\nThere are " + matches.size() + " records that contain " + inputflight);        //print message letting user know how many records matched

	}

	// FEATURE E - AIRCRAFT TYPE - UNOPTIMIZED DONE
	public static void FeatreEAircraft(List<AADAS> crash) throws FileNotFoundException {
		
		int p = 0; 																					//initialised int p for counter later of how many phases are read through to
		
		ArrayList<String> aircraftlisted = new ArrayList<String>();							        //new arraylist
		ArrayList<String> aircraft = new ArrayList<String>();                                       //new arraylist 
		
		for (int i = 0; i < crash.size(); i++) { 													//reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); 														//populating array with lines
			
			aircraft.add(currentCrash.AirCarrier);													//array populated with aircraft data
			String aircraftarray = currentCrash.AirCarrier;                                 		//string populated with current data 
			
			if (!aircraftlisted.contains(aircraftarray)) {                                          //if statment
				aircraftlisted.add(aircraftarray);                                                  //if conditions met add to array
			}
		}

		System.out.println("\nThere are " + aircraftlisted.size() + "aircraft type available");     //print to user showing how many options

	}

	// FEATURE E - MAKE - UNOPTIMIZED DONE
	public static void FeatreEmake(List<AADAS> crash) throws FileNotFoundException {
		int p = 0; // initialised int p for counter later of how many phases are read through to
		// display
		ArrayList<String> make = new ArrayList<String>(); // new arraylist called phases
		ArrayList<String> makeinarray = new ArrayList<String>(); // new arraylist called phases
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			make.add(currentCrash.Make);
			String makes = currentCrash.Make;		  //countryinarray becomes current year element for comparison purpose
			if (!makeinarray.contains(makes)) 			      //if yearslistedarray does not contain yearsinarray 
			{
				makeinarray.add(makes);				  //add country element to array if if statement is met
				p++;
			}
		}
		
		for (String counter : makeinarray) {                    //For length of countries listed
			System.out.println(counter);						//print countries

			}
		}

    // FEATURE E - TYPE - UNOPTIMIZED DONE
	public static void FeatreEtype(List<AADAS> crash) throws FileNotFoundException {
		int p = 0; // initialised int p for counter later of how many phases are read through to
		// display
		ArrayList<String> type = new ArrayList<String>(); // new arraylist called phases
		ArrayList<String> typeinarray = new ArrayList<String>();
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			type.add(currentCrash.EngineType);
			String types = currentCrash.EngineType;		  //countryinarray becomes current year element for comparison purpose
			if (!typeinarray.contains(types)) 			      //if yearslistedarray does not contain yearsinarray 
			{
				typeinarray.add(types  );				  //add country element to array if if statement is met
				p++;
			}
		}
		
		for (String counter : typeinarray) {                    //For length of countries listed
			System.out.println(counter);						//print countries

			}
		}
			
	// FEATURE E - MAKE AND TYPE - UNOPTIMIZED DONE
	public static void FeatureEMakeAndType(List<AADAS> crash) throws FileNotFoundException {

		Scanner s = new Scanner(System.in); // declare new scanner
		String inputmake = ""; // declare input for flight
		String inputtype = ""; // declare input for year

		System.out.println("Please specify the make of plane you would like to view the options are:\n"); // output
																											// message
																											// to user
		FeatreEmake(crash); // call method to output all phases of flight
		System.out.println("\nSelection: "); // print out prompt for user to enter choice
		inputmake = s.nextLine().toUpperCase(); // input for user must always go to uppercase as csv is uppercase

		System.out.println("\nPlease specify the model you would like to view the options are:\n"); // print prompt for
																									// years
		FeatreEtype(crash); // method to print years
		System.out.println("\nYear selection: "); // prompt for year input
		inputtype = s.nextLine(); // take year input

		List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches

		for (AADAS c : crash) { // reading through inital array list through whole csv
			if (c.Make.equals(inputmake) && c.EngineType.equals(inputtype)) // if user inputs meets
																		// conditions add that
																		// current csv string in to
																		// the array
				matches.add(c); // add into array matches

		}

		System.out.println("\nThere are " + matches.size() + " records that contain " + inputmake
				+ " and the type " + inputtype); // print out message showing user how many records match

		// for (AADAS c: matches)
		// System.out.println(c.getYear()+", "+c.AirCarrier);

		outputCrashes(matches); // call method to output all crashes with the array matches for what to print

	}

	// FEATURE E - MAIN MENU
	public static void menuFeatureE(List<AADAS> matches) throws FileNotFoundException { 

		ArrayList<AADAS> crash = readFile("src/aviationdata.csv");                         // Crash array list read from the .csv file
		
		String userInput = "";                                                             // initalize string

		
		while (!userInput.equals("Q")) {                                                   // while loop to output menu and read the users input

			// MENU SYSTEM
			System.out.println(" \n          --Additional Filtering--           ");
			System.out.println("[ 1 - 10 year period                           ]");
			System.out.println("[ 2 - Phase of flight                          ]");
			System.out.println("[ 3 - Aircraft Make and Type                   ]");
			System.out.println("[ Q - Quit                                     ]\n");
			System.out.print("Enter Choice:");
			userInput = reader.nextLine().toUpperCase();

			
			switch (userInput) {                                                           // Switch statement to allow the user to select which method to load

			//each case calls new method which will run option specified in the menu
			
			case "1":
				System.out.println("\n-- You have selected 10 year period --\n");
				System.out.println("-- Below you have a list of all of the crashes recorded --\n");
				FeatureEyears(matches);
				FeatureD(crash);
				break;
			case "2":
				System.out.println("\n-- You have selected Phase of flight --\n");
				System.out.println("-- Below you have a list of all of the Event dates --\n");
				FeatureEphase(matches);
				FeatureD(crash);

				break;
			case "3":
				System.out.println("\n-- You have selected Aircraft Make and Type --\n");
				System.out.println("-- Below you will see all of the phases of flight --\n");
				FeatureEMakeAndType(matches);
				FeatureD(crash);
				break;

				
			// case "Q" gives options to exit system or return to specific menu 
			case "Q":

				Scanner sure = new Scanner(System.in);
				System.out.println("* Are you sure you wish to exit? Y/N *");
				String result = sure.nextLine();
				switch (result) {
				case "Y":
					System.out.println("Thanks for using the system!");
					System.exit(1);
					break;
				case "y":
					System.out.println("Thanks for using the system!");
					System.exit(1);
					break;
				case "N":
					System.out.println("Ok! Returning to menu.\n");
					main(null);
				case "n":
					System.out.println("Ok! Returning to menu.\n");
					main(null);
				default:
					System.out.println("* Input Failed. Please restart the programme * \n\n");
					break;
				}

				break;
			default:
				System.out.println("Please enter a valid option\n\n");

			}
		}
	}

	// FEATURE E - SUBMENU
	public static void FeatureESubMenu() {
		System.out.println("Would you like to further refine your search");
		System.out.println("Y - Access the menu of more options");
		System.out.println("N - Return to the Feature 4 menu");
		System.out.println("M - Return to the Main Menu");
		System.out.print("Choice:");
	}

	// FEATURE E - 10 YEAR
	public static void FeatureEyears(List<AADAS> crash) {
		
		System.out.println("This option will show you all records for the option previously selected in a 10 year window of your choice.");                  //Ouput message to user

		FeatureA(crash); 																																	 // call year method
		
		System.out.println("Above are the years we have on record, please enter one below and we will show all records from that date to 10 years ahead of that date"); // output message showing what will happen
		System.out.println("choice: ");   																													 // prompt
		String choice = reader.nextLine(); 																													 // scanner

		int chosenYear = Integer.parseInt(choice);                                                                                                           // INT chosenyear = user choice but parses to an int
		int tenyear = chosenYear + 10;                                                                                                                       // int ten year is event date + 10 to give us a stop point 10 years in the future
										
		List<AADAS> matches = new ArrayList<>(); 																											 // new array

		for (AADAS c : crash) { 																															 // each loop of eventdate (2001, 2002, 2003....) run the whole array
			int year = c.getYearparse();                                                                                                                     // etsablish new int as result of parse method
			if (year >= chosenYear && year <= tenyear) {                                                                                                     // if statement
				matches.add(c);                                                                                                                              // add to array
			}
		}
		
			outputCrashes(matches);                                                                                                                          // output all crashes in array
			System.out.println("\nThere are " + matches.size()+ " records which match that criteria in this 10 year period between " + choice + " and "+ tenyear); // output letting user know how records match
		
	}

	// FEATURE F/G - Aircraft Make and Type with the highest.. (10 Year Period) - NOT DONE
	public static void FeatureF(List<AADAS> crash) throws FileNotFoundException {
	
		FeatureA(crash);
		System.out.println("Please specify the year that you would like to view 10 years worth of data from : e.g. 2001, 1978\n");

		String choice = reader.nextLine(); // scanner

		Eventyear = Integer.parseInt(choice); // INT event year = user choice but parses to an int
		int tenyear = Eventyear + 10; // int ten year is event date + 10 to give us a stop point 10 years in the
										// future
		List<AADAS> matches = new ArrayList<>(); // new array

		for (int i = Eventyear; i <= tenyear; i++) { 
			for (AADAS c : crash) { 
				if (c.getYearparse() == i) { 
					matches.add(c); 
				}
			}
		}
		
		System.out.println("\nThere are " + matches.size() + " records which match that criteria in this 10 year period between " + choice + " and " + tenyear + "\n"); 

	
		ArrayList<String> makeModel = new ArrayList<String>();
		ArrayList<Integer> makeModelFatalCount = new ArrayList<Integer>();
		ArrayList<Integer> makeModelAccidentCount = new ArrayList<Integer>();
		List<MakeRecord> make = new ArrayList<MakeRecord>();
		List<MakeRecord> amount = new ArrayList<MakeRecord>();
		List<AADAS> sortFatal = new ArrayList<>();

		// for loop to iterate through the matches array
		for (int i = 0; i < matches.size(); i++) {
			AADAS currentCrash = crash.get(i);
			String makeModelStr = currentCrash.Make + " " + currentCrash.Model; // Concatenating the make and model
																				// variables
			if (!makeModel.contains(makeModelStr)) // if the makeModel array contains the above string then add the
													// string to make model and add 0 to both arrays for later counting
			{
				makeModelFatalCount.add(0);
				makeModelAccidentCount.add(0);
				makeModel.add(makeModelStr);
			}
		}
		// loop through matches array the index enable the fatalities to be counted and
		// added to the makeModelFatalCount
		for (int i = 0; i < matches.size(); i++) {
			AADAS currentCrash = crash.get(i);
			String makeModelStr = currentCrash.Make + " " + currentCrash.Model;
			int index = makeModel.indexOf(makeModelStr);
			int currentFatal = makeModelFatalCount.get(index);
			currentFatal = currentCrash.TotalFatalInjuries;
			makeModelFatalCount.set(index, currentFatal);

       //find appropriate MakeRecord (or create a new one)
			MakeRecord theOne = null;
			for (MakeRecord makerec : make) {
				if (makerec.getmakemodel().equals(makeModelStr))
					theOne = makerec;
			}
			if (theOne == null) {
				theOne = new MakeRecord(makeModelStr, 0);
				make.add(theOne);
			}

			theOne.setamount(theOne.amount() + currentFatal);
		}

	

		String option1 = "";

		int highI = 0;

		// loop through matches array the index enable the records to be counted and
		// added to the makeModelAccidentCount
		for (int i = 0; i < matches.size(); i++) {
			AADAS currentCrash = crash.get(i);
			String makeModelStr = currentCrash.Make + " " + currentCrash.Model;
			int index = makeModel.indexOf(makeModelStr);
			int count = makeModelAccidentCount.get(index);
			
			makeModelAccidentCount.set(index, count);
			
			
			MakeRecord theOne = null;
			for (MakeRecord makerec : amount) {
				if (makerec.getmakemodel().equals(makeModelStr))
					theOne = makerec;
				
			}
			if (theOne == null) {
				theOne = new MakeRecord(makeModelStr, 0);
				amount.add(theOne);
				
			}
			count++;
			theOne.setamount(theOne.amount() + count);
			
		}
		

	

		int highR = 0;
		String option = "";
		System.out.println("\nPlease select which option you would like to view: \n");
		System.out.println("[ 1 - View the Highest Accident Rate between " + choice + " and " + tenyear +             "]");
		System.out.println("[ 2 - View the Highest Fatality Count between " + choice + " and " + tenyear +            "]");
		System.out.println("[ 3 - View the Highest Fatality Count in Reverse between " + choice + " and " + tenyear + "]");
		System.out.println("[ 4 - View the Highest Accident Rates in Reverse between " + choice + " and " + tenyear + "]");
		System.out.println("[ Q - Quit to the Main Menu                                                                ]");
		System.out.print("Enter Choice:");
		option = reader.nextLine().toUpperCase();

		
		if (option.equals("1")) {

			for (int i = 0; i < makeModel.size(); i++) {
				if (makeModelAccidentCount.get(i) > makeModelAccidentCount.get(highR)) {

					highR = i;
				}
			}
			System.out.println(
					"\nThe Aircraft Make and Model with the highest Accident rate over the specified 10 year period is:\n");
			System.out.println("Make/Model = [" + makeModel.get(highR) + "] and the Total Accident Rate = ["
					+ makeModelAccidentCount.get(highR) + "] (Between " + choice + " and " + tenyear + ")");
			System.out.println(
					"\nPlease press Enter to continue to reselect a 10 year period\nOr Type Q then Enter to return to the Main Menu");

			option1 = reader.nextLine().toUpperCase();
			if (option1.equals("Q")) {
				menu();
			} else {
				FeatureF(crash);
			}
		}
			
		
		
		if (option.equals("2")) {

				for (int i = 0; i < makeModel.size(); i++) {																			
					
					if (makeModelFatalCount.get(i) > makeModelFatalCount.get(highI))
						highI = i;
				}
				System.out.println(
						"\nThe Aircraft Make and Model with the highest fatality count over the specified 10 year period is:\n");
				System.out.println("Make/Model = [" + makeModel.get(highI) + "] and the Total Fatalities = ["
						+ makeModelFatalCount.get(highI) + "] (Between " + choice + " and " + tenyear + ")");
				System.out.println(
						"\nPlease press Enter to continue to reselect a 10 year period\nOr Type Q then Enter to return to the Main Menu");
				option1 = reader.nextLine().toUpperCase();
				if (option1.equals("Q")) {
					menu();
				} else {
					FeatureF(crash);
				}
		} 
		
		
		else if (option.equals("3")) {
			insertSort(make);
			for (MakeRecord comparator : make) {
				System.out.println(comparator.getmakemodel() + " + " + comparator.amount());
				}
				System.out.println("\nThe Aircraft Make and Models are listed below in decending order by Higest fatality count first.:\n");
				System.out.println("\nPlease press Enter to continue to reselect a 10 year period\nOr Type Q then Enter to return to the Main Menu");
				
			option1 = reader.nextLine().toUpperCase();
			
			if (option1.equals("Q")) {
				
				menu();
			} else {
				
				FeatureF(crash);
			
			}
		} 
		
		
		else if (option.equals("4")) {

			insertSort(amount);
			for (MakeRecord comparator : amount) {
				System.out.println(comparator.getmakemodel() + " + " + comparator.amount());

			
			
			}
			System.out.println("\nThe Aircraft Make and Models are listed below in decending order by Higest Accident Rate first.:\n");
			System.out.println(
					"\nPlease press Enter to continue to reselect a 10 year period\nOr Type Q then Enter to return to the Main Menu");
			option1 = reader.nextLine().toUpperCase();
			if (option1.equals("Q")) {
				menu();
			} else {
				FeatureF(crash);
			}
		}

		else if (option.equals("Q")) {
			System.out.println("-- Returning To Main Menu --");
			menu();
		} else {
			System.out.println("**Please select a Valid Option**");
		}
	}

    // FEATURE H - Custom Feature 10 year country - UNOPTIMIZED DONE
	public static void featureH(List<AADAS> crash) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		// new array
		List<AADAS> matches = new ArrayList<>(); // new array
		String inputCountry = "";
		String choice = "";
		FeatureA(crash);
		System.out.println(
				"Above are the years we have on record, please enter one below and we will show all records from that date to 10 years ahead of that date"); // output
																																								// message
																																								// of
																																								// what
																																								// will
																																								// happen
		System.out.println("choice: "); // prompt
		choice = reader.nextLine(); // scanner
		FeatureHcountry(crash);
		System.out.println("Please choose a Country by typing the name exactly as seen above");
		System.out.print("Choice: ");

		inputCountry = reader.nextLine();
		String Country = inputCountry.substring(0, 1).toUpperCase() + inputCountry.substring(1);
		int chosenYear = Integer.parseInt(choice); // INT event year = user choice but parses to an int
		int tenyear = chosenYear + 10; // int ten year is event date + 10 to give us a stop point 10 years in the
										// future

		for (AADAS c : crash) {
			if (Country.equals(c.Country)) {
				int year = c.getYearparse();
				if (year >= chosenYear && year <= tenyear) {
					matches.add(c);
				}

			}
		}
		outputCrashes(matches);
		menu();

		while (matches.size() == 0) {
			System.out.println(
					"No records found for that country check spelling or make sure the country is on the list");
			menu();
		}
	}

	// FEATURE H - COUNTRY - UNOPTIMIZED DONE
	public static void FeatureHcountry(List<AADAS> crash) throws FileNotFoundException {
			int p = 0;                                                // initialised int p for counter later of how many phases are read through to display
			
			ArrayList<String> Country = new ArrayList<String>(); 	  // new arraylist called country
			ArrayList<String> Countrysort = new ArrayList<String>();  // new arraylist called countrysort
			
			for (int i = 0; i < crash.size(); i++) {                  // reading through inital array list through whole csv
				AADAS currentCrash = crash.get(i);                    // populating array with lines
				Country.add(currentCrash.Country);  
				String countryinarray = currentCrash.Country;		  //countryinarray becomes current year element for comparison purpose
				if (!Countrysort.contains(countryinarray)) 			      //if yearslistedarray does not contain yearsinarray 
				{
					Countrysort.add(countryinarray);				  //add country element to array if if statement is met
					p++;
				}
			}
			
			for (String counter : Countrysort) {                    //For length of countries listed
				System.out.println(counter);						//print countries

				}

			System.out.println("Above are all the countries on record there are currently " +p+ " different countries on record in this 10 year period");
			
		}
	
	// SYSTEM MAIN MENU
	public static void menu() throws FileNotFoundException { // DECLARE PUBLIC CLASS
		ArrayList<AADAS> crash = readFile("aviationdata.csv"); // Crash array list read from the .csv file
		Scanner s = new Scanner(System.in); // Initialise Scanner
		String userInput = ""; // Allow for user input

		// while loop to output menu and read the users input
		while (!userInput.equals("q")) {

			System.out.println(" \n      		-----Menu-----");
			System.out.println("[ 1 - All Recorded Crashes                      ]");
			System.out.println("[ 2 - Event Dates                               ]");
			System.out.println("[ 3 - Phases of Flight                          ]");
			System.out.println("[ 4 - Specific phase of flight and year         ]");
			System.out.println("[ 5 - Specifcs of crashes                       ]");
			System.out.println("[ 6 - Highest Accident/Fatalities               ]");
			System.out.println("[ 7 - Country of Crashes                        ]");

			System.out.println("[ Q - Quit                                      ]\n");
			System.out.print("Enter Choice:");
			userInput = s.nextLine().toUpperCase();

			// Switch statement to allow the user to select which method to load
			switch (userInput) {

			case "1":
				System.out.println("\n-- You have selected All Crashes --\n");
				System.out.println("-- Below you have a list of all of the crashes recorded --\n");
				outputCrashes(crash);
				break;
			case "2":
				System.out.println("\n-- You have selected Event Dates --\n");
				System.out.println("-- Below you have a list of all of the Event dates --\n");

				FeatureA(crash);
				break;
			case "3":
				System.out.println("\n-- You have selected Phases of Flight --\n");
				System.out.println("-- Below you will see all of the phases of flight --\n");
				FeatureB(crash);
				break;
			case "4":
				System.out.println("\n-- You have selected specific phase of flight and year --\n");
				System.out.println(
						"-- Below you have a list of all of the accidents recorded for the options you have chosen --\n");
				FeatureC(crash);
				break;
			case "5":
				System.out.println("\n-- You have selected Specifcs of crashes --\n");
				System.out.println("-- Below you have a list of all the specifc records we can provide --");
				FeatureD(crash);
				break;
			case "6":
				System.out.println("\n-- You have selected Highest Accident/Fatalities --\n");
				System.out.println("-- Below are the options for a specified 10 year period --\n ");
				FeatureF(crash);
				break;
			case "7":
				System.out.println("\n-- You have selected Crashes within countries--\n");
				System.out.println("-- Below you have a list of all the specifc records we can provide --");
				featureH(crash);

			case "Q":

				Scanner sure = new Scanner(System.in);
				System.out.println("* Are you sure you wish to exit? Y/N *");
				String result = sure.nextLine();
				switch (result) {
				case "Y":
					System.out.println("Thanks for using the system!");
					System.exit(1);
					break;
				case "y":
					System.out.println("Thanks for using the system!");
					System.exit(1);
					break;
				case "N":
					System.out.println("Ok! Returning to menu.\n");
					main(null);
				case "n":
					System.out.println("Ok! Returning to menu.\n");
					main(null);
				default:
					System.out.println("* Input Failed. Please restart the programme * \n\n");
					break;
				}

				break;
			default:
				System.out.println("Please enter a valid option\n\n");

			}
		}
	}

	// file reader to populate array
	public static ArrayList<AADAS> readFile(String filename) throws FileNotFoundException {
		ArrayList<AADAS> crashes = new ArrayList<>(); // initalising new arraylist
		File csvFile = new File(filename); // new filereader
		Scanner csvScan = new Scanner(csvFile);// new scanner

		csvScan.nextLine(); // read next line from scanner
		while (csvScan.hasNextLine()) { // while next line is available run this
			String line = csvScan.nextLine(); // whilst next line populate string line with line from file

			AADAS crash = new AADAS(line); // add line to array

			crashes.add(crash);// add to array

		}

		csvScan.close();
		return crashes;

	}
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class AADAS {

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

	public AADAS(String csvString) { // reading the strings into an array
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
			
			if (!inQuotes && c == ',') { //if a comma, but not in quotes 
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
						+ " country: " + currentCrash.Country + " Latitude: "
						+ currentCrash.Latitude + " Longitude: " + currentCrash.Longitude + " Airport Code: "
						+ currentCrash.Airportcode + " Airport name: " + currentCrash.AirportName + " Injury Severity: "
						+ currentCrash.InjurySeverity + " Aircraft Damage: " + currentCrash.AircraftDamage
						+ " Aircraft Catagory: " + currentCrash.AircraftCategory + " Registration Number "
						+ currentCrash.RegistrationNumber + " Make: " + currentCrash.Make + " Model "
						+ currentCrash.Model + " Amateur built: " + currentCrash.AmateurBuilt + " Number of engines: "
						+ currentCrash.NunberOfEngines + " Engine type: " + currentCrash.EngineType
						+ " FAR Description: " + currentCrash.FARDescription + " Schedule: " + currentCrash.Schedule
						+ " Purpose of flight: " + currentCrash.PurposeOfFlight + " Air Carrier: "
						+ currentCrash.AirCarrier + " Total Fatal injuries: " + currentCrash.TotalFatalInjuries
						+ " Total Serious Injuries: " + currentCrash.TotalSeriousInjuries + " Total Minor injuries: "
						+ currentCrash.TotalMinorInjuries + " Total Uninjured: " + currentCrash.TotalUninjured
						+ " Weather condition: " + currentCrash.WeatherCondition + " Broad phase of flight: "
						+ currentCrash.BroadPhaseofFlight + " Report status: " + currentCrash.ReportStatus
						+ " Publication Date: " + currentCrash.PublicationDate);

			}
		}

	}

	// FEATURE 1 - OUTPUT ALL YEARS
	public static void year(List<AADAS> crash) { // DECLARE PUBLIC CLASS
		int j = 0; // initialised int j for counter later of how many years are read through to
					// display
		ArrayList<String> years = new ArrayList<String>(); // new arraylist called years
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			years.add(currentCrash.getYear()); // adding EventDate to years arraylist characted 6 - 10 (year 4 digits)

		}
		TreeSet<String> myTreeSet = new TreeSet<String>(); // initialising new treeset called myTreeSet
		myTreeSet.addAll(years); // adding all data from years array (all dates) to tree set (ordered set)
		for (Object s : myTreeSet) // reading through tree set
			System.out.println(s); // output dates in order
		for (int y = 0; y < myTreeSet.size(); y++) { // for loop which calculates how many times my tree size loops and
														// prints
			j++; // +1 every loop meaning that outcome will be amount of years printed

		}
		System.out.println("\nThere are " + j + " years of data available"); // prints how many years of data are shown
																				// from treeset
	}

	// FEATURE 2 - OUTPUT PHASES OF FLGHT
	public static void flightPhase(List<AADAS> crash) {
		int p = 0; // initialised int p for counter later of how many phases are read through to
					// display
		ArrayList<String> phases = new ArrayList<String>(); // new arraylist called phases
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			phases.add(currentCrash.BroadPhaseofFlight);
		}

		TreeSet<String> newTreeSet = new TreeSet<String>(); // initialising new treeset called myTreeSet
		newTreeSet.addAll(phases); // adding all data from phases array to tree set (ordered set)
		for (Object s : newTreeSet) // reading through tree set
			System.out.println(s); // output phases in order
		for (int y = 0; y < newTreeSet.size(); y++) { // for loop which calculates how many times new tree size loops
														// and prints
			p++; // +1 every loop meaning that outcome will be amount of phases printed
		}
	}

	// FEATURE 3 - OUTPUT SPECIFIC PHASE OF FLIGHT AND YEAR DATA
	public static void Feature3(List<AADAS> crash) {

		Scanner s = new Scanner(System.in); // declare new scanner
		String inputflight = ""; // declare input for flight
		String inputyear = ""; // declare input for year

		System.out.println("Please specify the phase of flight you would like to view the options are:\n"); // output
																											// message
																											// to user
		flightPhase(crash); // call method to output all phases of flight
		System.out.println("\nSelection: "); // print out prompt for user to enter choice
		inputflight = s.nextLine().toUpperCase(); // input for user must always go to uppercase as csv is uppercase

		System.out.println("\nPlease specify the year you would like to view the options are:\n"); // print prompt for
																									// years
		year(crash); // method to print years
		System.out.println("\nYear selection: "); // prompt for year input
		inputyear = s.nextLine(); // take year input

		List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches

		for (AADAS c : crash) { // reading through inital array list through whole csv
			if (c.BroadPhaseofFlight.equals(inputflight) && c.getYear().equals(inputyear)) // if user inputs meets
																							// conditions add that
																							// current csv string in to
																							// the array
				matches.add(c); // add into array matches

		}

		System.out.println("\nThere are " + matches.size() + " records that contain " + inputflight
				+ " and match the year " + inputyear); // print out message showing user how many records match

		// for (AADAS c: matches)
		// System.out.println(c.getYear()+", "+c.AirCarrier);

		outputCrashes(matches); // call method to output all crashes with the array matches for what to print

	}

	// FEATURE 4 - OUTPUT SPECIFIC OPTIONS FROM MENU
	public static void Feature4(List<AADAS> crash) throws FileNotFoundException {

		Scanner s = new Scanner(System.in);
		while (!s.equals("Q")) {
			System.out.println("\n1 - Flights that killed everybody aboard");
			System.out.println("2 - Flights that were deadly but the amount of survivors was greater than or equal to the amount perished");
			System.out.println("3 - Flights that were not deadly but resulted in serious or minor inujury");
			System.out.println("4 - Flights that resulted in no fatalities or injuries");
			System.out.println("Q - Quit to main menu ");
			System.out.print("\nSelection: ");
			String selection = s.nextLine().toUpperCase();

			
			// Selections to invoke features
			// MENU OPTION 1
			
			if (selection.equals("1")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalSeriousInjuries == 0 && c.TotalUninjured == 0 && c.TotalMinorInjuries == 0
							&& c.TotalFatalInjuries > 1) { // if user inputs meets conditions add that current csv string to the array
						matches.add(c); // add into array matches
						p++;
					}
				}
				outputCrashes(matches); // output the new array 
				System.out.println("\nThere are " + p + " records that match the criteria of eveybody onboard dying"); // show how many records match what the user selected
				Feature5SubMenu(); // method to print sub menu 
				String choice = reader.nextLine().toUpperCase(); // scanner to uppercaase
				
				if(choice.equals("Y")) { // if statment for user choice
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeature5(matches); // output menu method which has method inside to carry out options from menu
					
				} else if(choice.contentEquals("N")) { // if user types "n" return them to feature 4 menu 
				    Feature4(null);
				} else {
					menu(); // else return them to main menu 
				}
			
				//MENU OPTION 2
				// TO SEE COMMENTS ON WORKING LOOK AT MENU OPTION 1 AS CODE LAYOUT IS COPY
				
				} else if (selection.equals("2")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalFatalInjuries >= 1 && c.TotalSeriousInjuries + c.TotalMinorInjuries >= c.TotalFatalInjuries) { 
						// if user inputs meets conditions add that current csv string in to the array
						matches.add(c); // add into array matches
						p++;

					}

				}
				
				outputCrashes(matches);
				System.out.println("There are " + p + " records that match the criteria of the flight being deadly but the amount of surviviors being greater or equal to the amount perished");
				Feature5SubMenu();
				String choice = reader.nextLine().toUpperCase();
				if(choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeature5(matches);
					// while loop to output menu and read the users input
					
				
				} else if(choice.contentEquals("N")) {
				    Feature4(null);
				} else {
					menu();
				}
			}
			
			//MENU OPTION 3
			// TO SEE COMMENTS ON WORKING LOOK AT MENU OPTION 1 AS CODE LAYOUT IS COPY

			else if (selection.equals("3")) {
				List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
				int p = 0;
				for (AADAS c : crash) { // reading through inital array list through whole csv
					if (c.TotalFatalInjuries == 0 && c.TotalSeriousInjuries >= 1 && c.TotalMinorInjuries >= 1) { // if user inputs meets conditions add that current csv string to the array
				matches.add(c); // add into array matches
						p++;

					}

				}
				
				outputCrashes(matches);
				System.out.println("There are " + p + " records that match the criteria");
				Feature5SubMenu();
				String choice = reader.nextLine().toUpperCase();
				if(choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeature5(matches);
					// while loop to output menu and read the users input
					
				
				} else if(choice.contentEquals("N")) {
				    Feature4(null);
				} else {
					menu();
				}
			}

			//MENU OPTION 3
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
				System.out.println("There are " + p + " records that match the criteria of flights that had 0 fatalities or injuries");
				Feature5SubMenu();
				String choice = reader.nextLine().toUpperCase();
				if(choice.equals("Y")) {
					Scanner t = new Scanner(System.in); // Initialise Scanner
					String userInput = ""; // Allow for user input
					menuFeature5(matches);
					// while loop to output menu and read the users input
					
				
				} else if(choice.contentEquals("N")) {
				    Feature4(null);
				} else {
					menu();
				
				}
			} else if (selection.equals("Q")) { // if selection is quit from feature 4 menu return to main menu 
				menu();
			} else {
				System.out.println("\nPlease enter a valid input from the menu system\n"); // if not valid input retrun this message 
			}
		}

	}

	// FEATURE 5 - PHASE OF FLIGHT 
	public static void Feature5phase(List<AADAS> crash) throws FileNotFoundException{
		Scanner s = new Scanner(System.in); // declare new scanner
		String inputflight = ""; // declare input for flight
		 // declare input for year

		System.out.println("Please specify the phase of flight you would like to view the options are:\n"); // output
																											// message
																											// to user
		flightPhase(crash); // call method to output all phases of flight
		System.out.println("\nSelection: "); // print out prompt for user to enter choice
		inputflight = s.nextLine().toUpperCase(); // input for user must always go to uppercase as csv is uppercase

		
		List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
		

		for (AADAS c : crash) { // reading through inital array list through whole csv
			if (c.BroadPhaseofFlight.equals(inputflight)) // if user inputs meets
																							// conditions add that
																							// current csv string in to
																							// the array
				matches.add(c); // add into array matches
			

		}

		 

		// for (AADAS c: matches)
		// System.out.println(c.getYear()+", "+c.AirCarrier);

		outputCrashes(matches); // call method to output all crashes with the array matches for what to print
		System.out.println("\nThere are " + matches.size() + " records that contain " + inputflight);  // print out message showing user how many records match

	}
	
	// FEATURE 5 - AIRCRAFT TYPE
	public static void Featre5Aircraft(List<AADAS> crash) throws FileNotFoundException{
		int p = 0; // initialised int p for counter later of how many phases are read through to
		// display
		ArrayList<String> aircraft = new ArrayList<String>(); // new arraylist called phases
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			aircraft.add(currentCrash.AirCarrier);
		}

		TreeSet<String> newTreeSet = new TreeSet<String>(); // initialising new treeset called myTreeSet
		newTreeSet.addAll(aircraft); // adding all data from phases array to tree set (ordered set)
		for (Object s : newTreeSet) // reading through tree set
			System.out.println(s); // output phases in order
		for (int y = 0; y < newTreeSet.size(); y++) { // for loop which calculates how many times new tree size loops
											// and prints
			p++; // +1 every loop meaning that outcome will be amount of phases printed
		}
	}
	
	//FEATURE 5 - MAKE 
	public static void Featre5make(List<AADAS> crash) throws FileNotFoundException{
		int p = 0; // initialised int p for counter later of how many phases are read through to
		// display
		ArrayList<String> make = new ArrayList<String>(); // new arraylist called phases
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			make.add(currentCrash.Make);
		}

		TreeSet<String> newTreeSet = new TreeSet<String>(); // initialising new treeset called myTreeSet
		newTreeSet.addAll(make); // adding all data from phases array to tree set (ordered set)
		for (Object s : newTreeSet) // reading through tree set
			System.out.println(s); // output phases in order
		for (int y = 0; y < newTreeSet.size(); y++) { // for loop which calculates how many times new tree size loops
											// and prints
			p++; // +1 every loop meaning that outcome will be amount of phases printed
		}
	}
	
	// FEATURE 5 - TYPE 
	public static void Featre5type(List<AADAS> crash) throws FileNotFoundException{
		int p = 0; // initialised int p for counter later of how many phases are read through to
		// display
		ArrayList<String> type = new ArrayList<String>(); // new arraylist called phases
		for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
			AADAS currentCrash = crash.get(i); // populating array with lines
			type.add(currentCrash.Model);
		}

		TreeSet<String> newTreeSet = new TreeSet<String>(); // initialising new treeset called myTreeSet
		newTreeSet.addAll(type); // adding all data from phases array to tree set (ordered set)
		for (Object s : newTreeSet) // reading through tree set
			System.out.println(s); // output phases in order
		for (int y = 0; y < newTreeSet.size(); y++) { // for loop which calculates how many times new tree size loops
											// and prints
			p++; // +1 every loop meaning that outcome will be amount of phases printed
		}
	}
	
	// FEATURE 5 - MAKE AND TYPE
	public static void Feature5MakeAndType(List<AADAS> crash) throws FileNotFoundException {

		Scanner s = new Scanner(System.in); // declare new scanner
		String inputmake = ""; // declare input for flight
		String inputtype = ""; // declare input for year

		System.out.println("Please specify the make of plane you would like to view the options are:\n"); // output
																											// message
																											// to user
	    Featre5make(crash); // call method to output all phases of flight
		System.out.println("\nSelection: "); // print out prompt for user to enter choice
		inputmake = s.nextLine().toUpperCase(); // input for user must always go to uppercase as csv is uppercase

		System.out.println("\nPlease specify the model you would like to view the options are:\n"); // print prompt for
																									// years
		Featre5type(crash); // method to print years
		System.out.println("\nYear selection: "); // prompt for year input
		inputtype = s.nextLine(); // take year input

		List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches

		for (AADAS c : crash) { // reading through inital array list through whole csv
			if (c.Make.equals(inputmake) && c.Model.equals(inputtype)) // if user inputs meets
																							// conditions add that
																							// current csv string in to
																							// the array
				matches.add(c); // add into array matches

		}

		System.out.println("\nThere are " + matches.size() + " records that contain " + inputmake
				+ " and match the year " + inputtype); // print out message showing user how many records match

		// for (AADAS c: matches)
		// System.out.println(c.getYear()+", "+c.AirCarrier);

		outputCrashes(matches); // call method to output all crashes with the array matches for what to print

	}
	
	// FEATURE 5- MAIN MENU
	public static void menuFeature5(List<AADAS> matches) throws FileNotFoundException { // DECLARE PUBLIC CLASS

		ArrayList<AADAS> crash = readFile("src/aviationdata.csv"); // Crash array list read from the .csv file
		Scanner s = new Scanner(System.in); // Initialise Scanner
		String userInput = ""; // Allow for user input

		// while loop to output menu and read the users input
		while (!userInput.equals("q")) {

			System.out.println(" \n  Additional Filtering    "); 
			System.out.println("[ 1 - 10 year period                           ]");
			System.out.println("[ 2 - Phase of flight                          ]");
			System.out.println("[ 3 - Aircraft Make and Type                   ]");
		    System.out.println("[ Q - Quit                                     ]\n");
			System.out.print("Enter Choice:");
			userInput = s.nextLine().toUpperCase();

			// Switch statement to allow the user to select which method to load
			switch (u0serInput) {

			case "1":
				System.out.println("\n-- You have selected 10 year period --\n");
				System.out.println("-- Below you have a list of all of the crashes recorded --\n");
				Feature5years(matches);
				Feature4(crash);
				break;
			case "2":
				System.out.println("\n-- You have selected Phase of flight --\n");
				System.out.println("-- Below you have a list of all of the Event dates --\n");
				Feature5phase(matches);
				Feature4(crash);
				
				break;
			case "3":
				System.out.println("\n-- You have selected Aircraft Make and Type --\n");
				System.out.println("-- Below you will see all of the phases of flight --\n");
				Feature5MakeAndType(matches);
				Feature4(crash);
				break;
		
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
	
	//FEATURE 5 - SUBMENU
	public static void Feature5SubMenu() {
		System.out.println("Would you like to further refine your search");
		System.out.println("Y - Access the menu of more options");
		System.out.println("N - Return to the Feature 4 menu");
		System.out.println("M - Return to the Main Menu");
		System.out.print("Choice:");
	}
    
	//FEATURE 5 - 10 YEAR 
	public static void Feature5years(List<AADAS> crash) {
		System.out.println("This option will show you all records for the option previously selected in a 10 year window of your choice.");// output message to user
		
		year(crash); // call year method
		System.out.println("Above are the years we have on record, please enter one below and we will show all records from that date to 10 years ahead of that date"); // output message of what will happen
		System.out.println("choice: "); // prompt
		String choice = reader.nextLine(); // scanner
		
		int chosenYear = Integer.parseInt(choice); // INT event year = user choice but parses to an int
		int tenyear = chosenYear + 10; // int ten year is event date + 10 to give us a stop point 10 years in the future
		List<AADAS> matches = new ArrayList<>(); // new array 

		
			for(AADAS c : crash) { // each loop of eventdate (2001, 2002, 2003....) run the whole array
				int year = c.getYearparse();
				if (year >= chosenYear && year <= tenyear)
				{ // get year parse uses the get year method and parses it to an int for comparison reasons
					                         // get year parse will check   for each loop if i has any matches if it does add those to the array 
					matches.add(c); // add to array
				}
			}

		
//		for(int i = chosenYear; i <= tenyear; i++) { // i = event date and iterate eventdate until it is equal to ten year 
//			for(AADAS c : crash) { // each loop of eventdate (2001, 2002, 2003....) run the whole array 
//				if (c.getYearparse() == i) { // get year parse uses the get year method and parses it to an int for comparison reasons
//					                         // get year parse will check   for each loop if i has any matches if it does add those to the array 
//					matches.add(c); // add to array
//				}
//			}
//			}
		outputCrashes(matches); // output all crashes in array 
		System.out.println("\nThere are " + matches.size() + " records which match that criteria in this 10 year period between " + choice + " and " + tenyear); // output letting user know how records match 
		}
		
		public static void featureH(List<AADAS>country) {
			Scanner s = new Scanner(System.in);
			String inputCountry = "";
			
			System.out.println("Please choose a Country");
			
			inputCountry = reader.nextLine();
			
			
			
		}
	
	// SYSTEM MAIN MENU 
	public static void menu() throws FileNotFoundException { // DECLARE PUBLIC CLASS
		ArrayList<AADAS> crash = readFile("src/aviationdata.csv"); // Crash array list read from the .csv file
		Scanner s = new Scanner(System.in); // Initialise Scanner
		String userInput = ""; // Allow for user input

		// while loop to output menu and read the users input
		while (!userInput.equals("q")) {

			System.out.println(" \n      -----Menu-----");
			System.out.println("[ 1 - All Recorded Crashes                      ]");
			System.out.println("[ 2 - Event Dates                               ]");
			System.out.println("[ 3 - Phases of Flight                          ]");
			System.out.println("[ 4 - Specific phase of flight and year         ]");
			System.out.println("[ 5 - Specifcs of crashes                       ]");
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

				year(crash);
				break;
			case "3":
				System.out.println("\n-- You have selected Phases of Flight --\n");
				System.out.println("-- Below you will see all of the phases of flight --\n");
				flightPhase(crash);
				break;
			case "4":
				System.out.println("\n-- You have selected specific phase of flight and year --\n");
				System.out.println(
						"-- Below you have a list of all of the accidents recorded for the options you have chosen --\n");
				Feature3(crash);
				break;
			case "5":
				System.out.println("\n-- You have selected Specifcs of crashes --\n");
				System.out.println("-- Below you have a list of all the specifc records we can provide --");
				Feature4(crash);
				break;
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


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class AADAS {


	public static Scanner reader = new Scanner(System.in); // declaring all strings that will be produced from the csv
															// file into the array.
	public final String SEP = ",";
	public String Eventid;
	public String InvestigationType;
	public String accidetnNumber;
	public String EventDate;
	public String Location;
	public String state;
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
	public String TotalFatalInjuries;
	public String TotalSeriousInjuries;
	public String TotalMinorInjuries;
	public String TotalUninjured;
	public String WeatherCondition;
	public String BroadPhaseofFlight;
	public String ReportStatus;
	public String PublicationDate;

	public AADAS(String csvString) { // reading the strings into an array
		String[] csvParts = csvString.split(SEP);
		int i = 0;
		Eventid = csvParts[i++];
		InvestigationType = csvParts[i++];
		accidetnNumber = csvParts[i++];
		EventDate = csvParts[i++];
		Location = csvParts[i++];
		state = csvParts[i++];
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
		TotalFatalInjuries = csvParts[i++];
		TotalSeriousInjuries = csvParts[i++];
		TotalMinorInjuries = csvParts[i++];
		TotalUninjured = csvParts[i++];
		WeatherCondition = csvParts[i++];
		BroadPhaseofFlight = csvParts[i++];
		ReportStatus = csvParts[i++];
		PublicationDate = csvParts[i++];

	}

	public String toCSVString() { // how to strings will be formatted if all were printed and how they can be
									// called from the array list
		return Eventid + SEP + InvestigationType + SEP + accidetnNumber + SEP + EventDate + SEP + Location + SEP + state
				+ SEP + Country + SEP + Latitude + SEP + Longitude + SEP + Airportcode + SEP + AirportName + SEP
				+ InjurySeverity + SEP + AircraftDamage + SEP + AircraftCategory + SEP + RegistrationNumber + SEP + Make
				+ SEP + Model + SEP + AmateurBuilt + SEP + NunberOfEngines + SEP + EngineType + SEP + FARDescription
				+ SEP + Schedule + SEP + PurposeOfFlight + SEP + AirCarrier + SEP + TotalFatalInjuries + SEP
				+ TotalSeriousInjuries + SEP + TotalMinorInjuries + TotalUninjured + SEP + WeatherCondition + SEP
				+ BroadPhaseofFlight + SEP + ReportStatus + SEP + PublicationDate;

	}

	public String getYear() {
		return EventDate.substring(6, 10);
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
						+ currentCrash.state + " country: " + currentCrash.Country + " Latitude: "
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

	// FEATURE 3
	public static void Feature3(List<AADAS> crash) {
		
		Scanner s = new Scanner(System.in); // declare new scanner
		String inputflight = ""; // declare input for flight
		String inputyear = ""; // declare input for year 

		System.out.println("Please specify the phase of flight you would like to view the options are:\n"); // output message to user
		flightPhase(crash); // call method to output all phases of flight
		System.out.println("\nSelection: "); // print out prompt for user to enter choice
		inputflight = s.nextLine().toUpperCase(); // input for user must always go to uppercase as csv is uppercase
		

		System.out.println("\nPlease specify the year you would like to view the options are:\n"); // print prompt for years
		year(crash); // method to print years
		System.out.println("\nYear selection: "); // prompt for year input
		inputyear = s.nextLine(); //take year input 
	

		List<AADAS> matches = new ArrayList<>(); // initalise new arraylist called matches
		
		for (AADAS c : crash) { // reading through inital array list through whole csv
			if (c.BroadPhaseofFlight.equals(inputflight) && c.getYear().equals(inputyear)) // if user inputs meets conditions add that current csv string in to the array
				matches.add(c); // add into array matches

		}

		System.out.println("\nThere are " + matches.size() + " records that contain " + inputflight + " and match the year "+ inputyear); // print out message showing user how many records match 
		
//		for (AADAS c: matches)
//			System.out.println(c.getYear()+", "+c.AirCarrier);
		
		outputCrashes(matches); // call method to output all crashes with the array matches for what to print

		

	}

	// basic menu method - will be adjusted

	public static void menu() throws FileNotFoundException { // DECLARE PUBLIC CLASS
		ArrayList<AADAS> crash = readFile("src/csv.csv"); // Crash array list read from the .csv file
		Scanner s = new Scanner(System.in); // Initialise Scanner
		String userInput = ""; // Allow for user input

		// while loop to output menu and read the users input
		while (!userInput.equals("q")) {

			System.out.println(" \n      -----Menu-----");
			System.out.println("[ 1 - All Recorded Crashes                      ]");
			System.out.println("[ 2 - Event Dates                               ]");
			System.out.println("[ 3 - Phases of Flight                          ]");
			System.out.println("[ 4 - Specific phase of flight and year         ]");
			System.out.println("[ Q - Quit                                      ]\n");
			System.out.println("Enter Choice:");
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
				// accidents(crash);
				Feature3(crash);
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

   

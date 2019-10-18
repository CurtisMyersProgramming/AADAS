import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.*;

import static java.lang.Double.parseDouble;

public class AADAS {

    public static Scanner reader = new Scanner(System.in); // declaring all strings that will be produced from the csv file into the array.
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
    public String  TotalSeriousInjuries;
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

    public String toCSVString() { // how to strings will be formatted if all were printed and how they can be called from the array list
        return Eventid + SEP + InvestigationType + SEP + accidetnNumber + SEP + EventDate + SEP + Location + SEP + state + SEP + Country + SEP + Latitude + SEP +
                Longitude + SEP + Airportcode + SEP + AirportName + SEP + InjurySeverity + SEP + AircraftDamage + SEP + AircraftCategory + SEP +
                RegistrationNumber + SEP + Make + SEP + Model + SEP + AmateurBuilt + SEP + NunberOfEngines + SEP + EngineType + SEP + FARDescription + SEP + Schedule + SEP +
                PurposeOfFlight + SEP + AirCarrier + SEP + TotalFatalInjuries + SEP + TotalSeriousInjuries + SEP + TotalMinorInjuries + TotalUninjured  + SEP + WeatherCondition + SEP + BroadPhaseofFlight
                + SEP + ReportStatus + SEP + PublicationDate;

    }

     // main method currently contains file reader and basic menu system to be updated as more work is added
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<AADAS> crash = readFile("src/csv.csv");
        menu();
        String input = reader.nextLine();
        if (input.startsWith("all crashes")) {
            outputCrashes(crash);
        } else if (input.startsWith("hello")) {
            System.out.println("hello");
        } else if(input.startsWith("year")){
            year(crash);
        } else if(input.startsWith("POF")) {
        	phase(crash);
        }


    }
    // test class which outputs all data from csv to test file size
    private static void outputCrashes(List<AADAS> crash) {
        for (int i = 0; i < crash.size(); i++) {
            AADAS currentCrash = crash.get(i);
            if (currentCrash != null) {
                System.out.println("Crash id: "+ currentCrash.Eventid + " Investigation Type: " +currentCrash.InvestigationType + " Accident Number: " + currentCrash.accidetnNumber + " Event Date: " + currentCrash.EventDate + " Location: " + currentCrash.Location + currentCrash.state + " country: " + currentCrash.Country + " Latitude: " +currentCrash.Latitude +
                       " Longitude: " + currentCrash.Longitude + " Airport Code: " + currentCrash.Airportcode + " Airport name: " + currentCrash.AirportName + " Injury Severity: " + currentCrash.InjurySeverity + " Aircraft Damage: " + currentCrash.AircraftDamage + " Aircraft Catagory: " + currentCrash.AircraftCategory + " Registration Number "+ currentCrash.RegistrationNumber +
                         " Make: " + currentCrash.Make + " Model " + currentCrash.Model + " Amateur built: " + currentCrash.AmateurBuilt + " Number of engines: " + currentCrash.NunberOfEngines + " Engine type: " + currentCrash.EngineType + " FAR Description: " + currentCrash.FARDescription + " Schedule: " + currentCrash.Schedule + " Purpose of flight: " + currentCrash.PurposeOfFlight +
                        " Air Carrier: " + currentCrash.AirCarrier + " Total Fatal injuries: " + currentCrash.TotalFatalInjuries + " Total Serious Injuries: " + currentCrash.TotalSeriousInjuries + " Total Minor injuries: " + currentCrash.TotalMinorInjuries + " Total Uninjured: " + currentCrash.TotalUninjured + " Weather condition: " + currentCrash.WeatherCondition + " Broad phase of flight: " + currentCrash.BroadPhaseofFlight + " Report status: " + currentCrash.ReportStatus + " Publication Date: " + currentCrash.PublicationDate);


            }
        }

    }
    // FEATURE 1 - OUTPUT ALL YEARS
    public static void year(List<AADAS> crash) { // DECLARE PUBLIC CLASS
       int j =0; // initialised int j for counter later of how many years are read through to display
        ArrayList<String> years = new ArrayList<String>(); // new arraylist called years
        for (int i = 0; i < crash.size(); i++) { // reading through inital array list through whole csv
            AADAS currentCrash = crash.get(i); // populating array with lines
            years.add(currentCrash.EventDate.substring(6, 10)); // adding EventDate to years arraylist characted 6 - 10 (year 4 digits)

        }
         TreeSet myTreeSet = new TreeSet(); // initialising new treeset called myTreeSet
            myTreeSet.addAll(years); // adding all data from years array (all dates) to tree set (ordered set)
            for (Object s: myTreeSet) // reading through tree set
                System.out.println(s); // output dates in order
        for(int y=0; y < myTreeSet.size(); y++){ // for loop which calculates how many times my tree size loops and prints
            j++; // +1 every loop meaning that outcome will be amount of years printed


        }
        System.out.println("There are " + j + " years of data available"); // prints how many years of data are shown from treeset
    }
    //FEATURE 2 - OUTPUT ALL PHASES OF FLIGHT
    public static void phase(List<AADAS> crash) { //DECLARE PUBLIC CLASS
    	ArrayList<String> phases = new ArrayList<String>();//Creating new Array list for Phases of Flight
    	for(int i = 0; i < crash.size(); i++ ) { //this reads through the original Array List Crash
    		AADAS phaseOfFlight = crash.get (i); // populates string to add to array
    		phases.add(phaseOfFlight.BroadPhaseofFlight);//adds the information to phases for BPOF
    		}
    	TreeSet pofTreeSet = new TreeSet();//Creating a new Tree Set for Phases of Flight
    	pofTreeSet.addAll(phases);//Adding array to the tree set.
    	for (Object f: pofTreeSet) {
    		System.out.println(f);
    	
    	}
    	
    	
    	
    	
    	
    }
    

// basic menu method - will be adjusted
    public static void menu() {
        System.out.println("Welcome to the Air Accident data Analysis System, below are the options of what records we have to offer: ");
        System.out.println("all crashes, year, POF, hello");
        System.out.print("Please enter the option you would like as you see it above: ");

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




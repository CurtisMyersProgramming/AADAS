import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class AADAS {

    public static Scanner reader = new Scanner(System.in);
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


    public AADAS(String csvString) {
        String[] csvParts = csvString.split(SEP, -1);
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

    public String toCSVString() {
        return Eventid + SEP + InvestigationType + SEP + accidetnNumber + SEP + EventDate + SEP + Location + SEP + state + SEP + Country + SEP + Latitude + SEP +
                Longitude + SEP + Airportcode + SEP + AirportName + SEP + InjurySeverity + SEP + AircraftDamage + SEP + AircraftCategory + SEP +
                RegistrationNumber + SEP + Make + SEP + Model + SEP + AmateurBuilt + SEP + NunberOfEngines + SEP + EngineType + SEP + FARDescription + SEP + Schedule + SEP +
                PurposeOfFlight + SEP + AirCarrier + SEP + TotalFatalInjuries + SEP + TotalSeriousInjuries + SEP + TotalMinorInjuries + TotalUninjured  + SEP + WeatherCondition + SEP + BroadPhaseofFlight
                + SEP + ReportStatus + SEP + PublicationDate;

    }


    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<AADAS> crash = readFile("src/csv.csv");
        menu();
        String input = reader.nextLine();
        if (input.startsWith("all crashes")) {
            outputCrashes(crash);
        } else if (input.startsWith("hello")) {
            System.out.println("hello");
        }
        ;

    }

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

    public static void menu() {
        System.out.println("Welcome to the Air Accident data Analysis System, below are the options of what records we have to offer: ");
        System.out.println("all crashes, year, hello");
        System.out.print("Please enter the option you would like as you see it above: ");

    }

    public static ArrayList<AADAS> readFile(String filename) throws FileNotFoundException {
        ArrayList<AADAS> crashes = new ArrayList<>();
        File csvFile = new File(filename);
        Scanner csvScan = new Scanner(csvFile);

        csvScan.nextLine(); // read header
        while (csvScan.hasNextLine()) {
            String line = csvScan.nextLine();

            AADAS crash = new AADAS(line);

                crashes.add(crash);
           
        }


        csvScan.close();
        return crashes;

    }
}




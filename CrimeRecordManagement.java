import java.util.*;

abstract class CrimeRecord 
{
    private String CriminalName;  // private access
    protected int CriminalID;      // protected access
    String CrimeType;               // package-private access

   CrimeRecord(String CriminalName, int CriminalID, String CrimeType) 
   {
    this.CriminalName = CriminalName;
    this.CriminalID = CriminalID;
    this.CrimeType = CrimeType;
}

    String getCriminalName() 
    {
        return CriminalName;
    }

    int getCriminalID() 
    {
        return CriminalID;
    }

    String getCrimeType()
    {
        return CrimeType;
    }

    void printDetails() 
    {
        System.out.println("Criminal ID: " + getCriminalID());
        System.out.println("Criminal Name: " + getCriminalName());
        System.out.println("Crime Type: " + getCrimeType());
    }
}

interface ExtraDetails 
{
    String getPlace();
    String DateOfCrime();
    String DateOfArrest();
}

class CompleteDetails extends CrimeRecord implements ExtraDetails 
{
    private String CrimePlace;      // private access
    String CrimeDate;               // package-private access
    protected String ArrestDate;    // protected access

    CompleteDetails(String CN, int CId, String CD, String CP, String CT, String A) 
    {
        super(CN, CId, CD);
        CrimePlace = CP;
        CrimeDate = CT;
        ArrestDate = A;
    }

    public String getPlace() 
    {
        return CrimePlace;
    }

    public String DateOfCrime()
    {
        return CrimeDate;
    }

    public String DateOfArrest()
    {
        return ArrestDate;
    }

    protected void printDetails() {
        super.printDetails();
        System.out.println("Crime Place: " + getPlace());
        System.out.println("Date of Crime: " + DateOfCrime());
        System.out.println("Date of Arrest: " + DateOfArrest());
        System.out.println("------------------------------");
    }
}

class CriminalRecordManager {
    private ArrayList<CompleteDetails> records;  // private access

    // Public constructor
    public CriminalRecordManager() {
        records = new ArrayList<>();
    }

    // Public method with public access
    public void addCriminalRecord(String name, int id, String crimeType, String place, String dateOfCrime, String arrestDate) {
        if (records.size() < 100) {
            CompleteDetails record = new CompleteDetails(name, id, crimeType, place, dateOfCrime, arrestDate);
            records.add(record);
        } else {
            System.out.println("The record limit has been exceeded");
        }
    }

    // Public method with protected access
    protected void removeCriminalRecord(int id) {
        int indexToRemove = -1;

        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getCriminalID() == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            records.remove(indexToRemove);
            System.out.println("Criminal record with ID " + id + " removed successfully.");
        } else {
            System.out.println("Criminal record with ID " + id + " not found.");
        }
    }

    // Public method with default access
    void searchCrimeRecord(int criminalID) {
        try {
            for (CompleteDetails record : records) {
                if (record.getCriminalID() == criminalID) {
                    System.out.println("Crime record found for Criminal ID " + criminalID + ":");
                    System.out.println("Criminal ID: " + record.getCriminalID());
                    System.out.println("Criminal Name: " + record.getCriminalName());
                    System.out.println("Crime Type: " + record.getCrimeType());
                    System.out.println("Crime Place: " + record.getPlace());
                    System.out.println("Date of Crime: " + record.DateOfCrime());
                    System.out.println("Date of Arrest: " + record.DateOfArrest());
                    return;
                }
            }
            throw new RuntimeException("Crime record not found for ID: " + criminalID);
        } catch (Exception e) {
            System.out.println("Error searching for crime record: " + e.getMessage());
        }
    }

    // Public method with default access
    void displayCrimeRecords() {
        for (CompleteDetails record : records) {
            System.out.println("Criminal ID: " + record.getCriminalID());
            System.out.println("Criminal Name: " + record.getCriminalName());
            System.out.println("Crime Type: " + record.getCrimeType());
            System.out.println("Crime Place: " + record.getPlace());
            System.out.println("Date of Crime: " + record.DateOfCrime());
            System.out.println("Date of Arrest: " + record.DateOfArrest());
            System.out.println("------------------------------");
        }
    }

}
class CrimeRecordManagement{
    public static void main(String[] args) {
        CriminalRecordManager manager = new CriminalRecordManager();

        manager.addCriminalRecord("Sumitra Singh", 1, "Robbery", "Gandhi-Bazaar, Anatapur", "23rd July, 1999", "9th January, 2000");
        manager.addCriminalRecord("Devesh Rathod", 2, "Assault", "Highway, Hyderabad", "4th March, 2012", "5th March, 2017");
        manager.addCriminalRecord("John Doe", 1, "Robbery", "City Center, Springfield", "5th March, 2020", "15th March, 2020");
        manager.addCriminalRecord("Alice Johnson", 2, "Assault", "Suburb, Oakville", "12th June, 2019", "18th June, 2019");
        manager.addCriminalRecord("Robert Smith", 3, "Burglary", "Downtown, Metro City", "8th September, 2021", "20th September, 2021");
        manager.addCriminalRecord("Mary Brown", 4, "Fraud", "Business District, Capital City", "3rd April, 2018", "12th April, 2018");
        manager.addCriminalRecord("Michael White", 5, "Kidnapping", "Residential Area, Riverside", "15th July, 2017", "23rd July, 2017");
        manager.addCriminalRecord("Emily Davis", 6, "Vandalism", "Historic District, Oldtown", "20th January, 2022", "3rd February, 2022");
        manager.addCriminalRecord("Daniel Wilson", 7, "Drug Trafficking", "Warehouse Area, Harbor City", "9th November, 2020", "28th November, 2020");
        // manager.addCriminalRecord("Sophia Martinez", 8, "Cybercrime");
        manager.addCriminalRecord("Ethan Taylor", 9, "Identity Theft", "Financial District, Megatown", "7th March, 2019", "Unknown");
        manager.addCriminalRecord("Olivia Turner", 10, "Arson", "Industrial Zone, Milltown", "22nd August, 2016", "5th September, 2016");
        manager.addCriminalRecord("Matthew Harris", 11, "Embezzlement", "Corporate Park, Techville", "14th February, 2015", "27th February, 2015");
        manager.addCriminalRecord("Ava Clark", 12, "Car Theft", "Parking Lot, Sunset City", "10th May, 2020", "19th May, 2020");
        manager.addCriminalRecord("Noah Turner", 13, "Money Laundering", "Financial District, Metropolis", "6th June, 2018", "14th June, 2018");
        manager.addCriminalRecord("Emma Carter", 14, "Homicide", "Residential Area, Hillside", "2nd October, 2019", "9th October, 2019");
        manager.addCriminalRecord("Liam Walker", 15, "Smuggling", "Dockyards, Ocean City", "18th July, 2017", "4th August, 2017");
        manager.addCriminalRecord("Isabella Murphy", 16, "Counterfeiting", "Black Market, Underground City", "25th March, 2021", "2nd April, 2021");
        manager.addCriminalRecord("Mason Evans", 17, "Extortion", "Red Light District, Shadowtown", "13th December, 2018", "22nd December, 2018");
        manager.addCriminalRecord("Mia Reed", 18, "Trespassing", "Abandoned Building, Ghostville", "16th September, 2016", "Unknown");
        manager.addCriminalRecord("James Perez", 19, "Money Forgery", "Forgery Workshop, Underworld", "11th April, 2020", "25th April, 2020");
        manager.addCriminalRecord("Ella Flores", 20, "Public Intoxication", "Entertainment District, Neon City", "30th June, 2018", "Unknown");

        System.out.println("Enter the details of the criminal:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of Criminal : ");
        String name = sc.nextLine();
        System.out.println("Enter the criminal ID : ");
        int id = sc.nextInt();
        System.out.println("Enter the type of crime : ");
        String crimeType = sc.next();
        sc.nextLine();
        System.out.println("Enter the place of Crime");
        String place = sc.nextLine();
        System.out.println("Enter the date of crime commited : ");
        String dateofCrime = sc.nextLine();
        System.out.println("Enter the arrest date : ");
        String arrestDate = sc.nextLine();
        
        System.out.println("Crime Records:");
        manager.addCriminalRecord(name, id, crimeType, place, dateofCrime, arrestDate);
        System.out.println("------------------------------");
        manager.displayCrimeRecords(); 
        System.out.println("------------------------------");
        System.out.println("Enter the ID of criminal to search");
        int search_id =sc.nextInt();
        manager.searchCrimeRecord(search_id); 
        System.out.println("------------------------------");
        System.out.println("Enter the ID to remove Crime");
        int remove_id = sc.nextInt();
        manager.removeCriminalRecord(remove_id);

    }
}

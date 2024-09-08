import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Home ClassTo hold house data

class Home {
    private int squareFeet;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String modelName;
    private String saleStatus;

    //constructor
    public Home(int squareFeet, String address, String city, String state, int zipCode, String modelName, String saleStatus) {
        this.squareFeet = squareFeet;
        this.address =address;
        this.city = city;
        this.state =state;
        this.zipCode = zipCode;
        this.modelName =modelName;
        this.saleStatus =saleStatus;
     }

    //Getters / Setters
     public int getSquareFeet() { return squareFeet; }
     public void setSquareFeet(int squareFeet) { this.squareFeet = squareFeet; }

     public String getAddress() { return address; }
     public void setAddress(String address) { this.address = address; }

     public String getCity() { return city; }
     public void setCity (String city) { this.city = city;}

     public String getState() { return state; }
     public void setState(String state) { this.state = state;}

     public int getZipCode() { return zipCode; }
     public void setZipCode(int zipCode) { this.zipCode = zipCode;}

     public String getModelName() { return modelName;}
     public void setModelName(String modelName) { this.modelName = modelName;}

     public String getSaleStatus() { return saleStatus; }
     public void setSaleStatus (String saleStatus) { this.saleStatus = saleStatus;}

     //Print Method
     public void printHome() {
        System.out.println("Square Feet; " + squareFeet);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("ZipCode: " + zipCode);
        System.out.println("Model Name: " + modelName);
        System.out.println("Sale Status: " + saleStatus);
     }
}

//Home inventory class to manage houses
public class HomeInventory {
    private ArrayList<Home> homes = new ArrayList<>();

    //Add new home method
    public String addHome(Home home) {
        try {
            homes.add(home);
            return "Home added successfully.";
        } catch (Exception e ) {
            return "Failed to add home: " + e.getMessage();
        }
    }

    //method to remove a home by address
    public String removeHome(String address) {
        try {
            for (Home home : homes) {
                if (home.getAddress().equalsIgnoreCase(address)) {
                    homes.remove(home);
                    return "Home removed Successfully." ;
                }
            }
            return "Home not found.";
        } catch (Exception e) {
            return "Failed to remove home: " + e.getMessage();
        }
    }

    //Update sale status Method
    public String updateHomeSaleStatus(String Address, String newSaleStatus) {
        try{
            for (Home home : homes) {
                if ( home.getAddress().equalsIgnoreCase(address)) { 
                    home.setSaleStatus(newSaleStatus);
                    return "Sale status successfully updated.";
                }
            }
            return "Home not found.";
        } catch (Exception e) {
            return "Failed to update sale status: " + e.getMessage();
        }
    }
    
    //List all homes method
    public void listHomes() {
        if (homes.isEmpty()) {
            System.out.println("No homes available.");
        } else {
            for (Home home : homes) {
                home.printHome();
                System.out.println("--------------");
            }
        }
    }

    //Print to file method

    public void printToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)){
            for (Home home : homes) {
                writer.write("Square Feet: " + home.getSquareFeet() + "\n");
                writer.write("Address: " + home.getAddress() + "\n");
                writer.write("City: " + home.getCity() + "\n");
                writer.write("State: " + home.getState() + "\n");
                writer.write("Zip Code: " + home.getZipCode() + "\n");
                writer.write("Model Name: " + home.getModelName() + "\n");
                writer.write("Sale Status: " + home.getSaleStatus() + "\n");
                writer.write("-----------------------\n");
        }
        System.out.println("File written successfully to " + filePath);
     } catch (IOException e) { 
        System.out.println("Failed to write to file: " + e.getMessage());
        }
    }

//Method to handle user inputs
public static void main(String[] args) {
    HomeInventory inventory = new HomeInventory();
    Scanner scanner = new scanner(System.in);
    int choice;

    do {
        System.out.println("Home inventory management program");
        System.out.println("1.) Add a home");
        System.out.println("2.) Remove a home");
        System.out.println("3.) Update a homes sale status");
        System.out.println("4.) List all homes");
        System.out.println("5.) Print all homes to a file");
        System.out.println("6.) Exit");
        System.out.println("Please choose an option");

        try {
            choice = scanner.nextInt();
            scanner.nextLine(); //consume newline

            switch (choice) {
                case 1:
                //Add a home
                    System.out.println("Enter square feet: ");
                    int squareFeet = scanner.nextInt();
                    System.out.println("Enter address :");
                    String address = scanner.nextInt();
                    System.out.println("Enter City: ");
                    String city = scanner.nextInt();
                    System.out.println("Enter State: ");
                    String state = scanner.nextInt();
                    System.out.println("Enter Zip Code: ");
                    int ZipCode = scanner.nextInt();
                    scanner.nextLine(); // consume next line
                    System.out.println("Enter Model Name: ");
                    String modelName = scanner.nextInt();
                    System.out.println("Enter Sale Status (Sold, Avaialable, Under Contract)");
                    String saleStatus = scanner.nextInt();

                    Home newHome = new Home(squareFeet, address, city, state, zipCode, modelName, saleStatus);
                    System.out.println(inventory.addHome(newHome));
                    break;
                case 2:
                    //Remove Home
                    System.out.print("Enter address of home to remove");
                    String removeAddress = scanner.nextLine();
                    System.out.println(inventory.removeHome(removeAddress));
                    break;
                case 3:
                    //update sale status
                    System.out.println("Enter address of home to update: " );
                    String updateAddress = scanner.nextLine();
                    System.out.println("Enter a new sale status (sold, available, under contract)");
                    String newSaleStatus = scanner.nextLine();
                    System.out.println(inventory.updateHomeSaleStatus(updateAddress, newSaleStatus));
                    break;
                case 4:
                    //list Homes
                    inventory.listHomes();
                    break;
                
                case 5:
                    //print to file
                    System.out.print("Enter file path to save (e.g., C:\\Temp\\Home.txt): ");
                    String filePath = scanner.nextLine();
                    inventory.printToFile(filePath);
                    break;
                
                case 6:
                    //Exit
                    System.out.print("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); //Clear invalid input
            choice = 0; // reset choice to continue loop
        }
    } while (choice != 6);

    scanner.close();
    }
}

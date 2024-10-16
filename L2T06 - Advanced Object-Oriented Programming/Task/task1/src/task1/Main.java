package task1;

// The Main class serves as the entry point for the program.
public class Main {
    
    public static void main(String[] args) {
        // Create an instance of Scientist with specified attributes and print its description.
        Scientist scientist = new Scientist(175, "Brown", true, "red", "");
        scientist.printScientistDescription();
        
        System.out.println(); // Print an empty line for better readability
        
        // Create an instance of Doctor with specified attributes and print its description.
        Doctor doctor = new Doctor(180, "Black", true, 8);
        doctor.printDoctorDescription();
    }
}

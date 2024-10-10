package task1;

// The Doctor class extends the Person class and represents a specialized type of person.
public class Doctor extends Person {
    
    // Attributes to store additional information about the doctor.
    private int yearsExperience;    // Years of experience as a doctor
    private String ranking;         // Ranking or position of the doctor based on experience

    // Constructor to initialize the doctor's attributes and the inherited attributes from Person.
    public Doctor(int height, String hairColor, boolean is18OrOlder, int yearsExperience) {
        super(height, hairColor, is18OrOlder);
        this.yearsExperience = yearsExperience;
        determineRanking(); // Determine the ranking based on experience
    }

    // Private method to determine the ranking of the doctor based on years of experience.
    private void determineRanking() {
        if (yearsExperience >= 0 && yearsExperience <= 6) {
            ranking = "Medical student";
        } else if (yearsExperience >= 7 && yearsExperience <= 8) {
            ranking = "Intern";
        } else if (yearsExperience >= 9 && yearsExperience <= 16) {
            ranking = "Resident";
        } else if (yearsExperience >= 17 && yearsExperience <= 20) {
            ranking = "Fellow";
        } else {
            ranking = "Attending";
        }
    }

    // Method to print a description of the doctor's attributes.
    public void printDoctorDescription() {
    	System.out.println("Doctor:");
        System.out.println("Ranking: " + ranking);
        System.out.println("Years of Experience: " + yearsExperience);
        System.out.println("Height: " + getHeight());
        System.out.println("Hair Color: " + getHairColor());
        System.out.println("Is 18 or older: " + is18OrOlder());
    }
}

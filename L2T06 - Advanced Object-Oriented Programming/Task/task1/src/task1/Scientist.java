package task1;

// The Scientist class extends the Person class and represents a specialized type of person.
public class Scientist extends Person {
    
    // Attributes to store additional information about the scientist.
    private String labCoatColor;        // Color of the scientist's lab coat
    private String typeOfScientist;     // Type or field of science the scientist specializes in

    // Constructor to initialize the scientist's attributes and the inherited attributes from Person.
    public Scientist(int height, String hairColor, boolean is18OrOlder, String labCoatColor, String typeOfScientist) {
        super(height, hairColor, is18OrOlder);
        this.labCoatColor = labCoatColor;
        this.setTypeOfScientist(typeOfScientist);
    }

    // Method to determine the type of scientist based on lab coat color.
    public String determineScientistType() {
        switch (labCoatColor.toLowerCase()) {
            case "green":
                return "Biologist";
            case "purple":
                return "Physicist";
            case "white":
                return "Pharmacist";
            case "blue":
                return "Climatologist";
            case "yellow":
                return "Geneticist";
            case "red":
                return "Zoologist";
            default:
                return "Unknown Scientist";
        }
    }

    // Method to print a description of the scientist's attributes.
    public void printScientistDescription() {
    	System.out.println("Scientist:");
        System.out.println("Scientist Type: " + determineScientistType());
        System.out.println("Lab Coat Color: " + labCoatColor);
        System.out.println("Height: " + getHeight());
        System.out.println("Hair Color: " + getHairColor());
        System.out.println("Is 18 or older: " + is18OrOlder());
    }

    // Getter method to retrieve the type of scientist.
    public String getTypeOfScientist() {
        return typeOfScientist;
    }

    // Setter method to set the type of scientist.
    public void setTypeOfScientist(String typeOfScientist) {
        this.typeOfScientist = typeOfScientist;
    }
}

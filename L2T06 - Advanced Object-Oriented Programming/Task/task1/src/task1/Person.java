package task1;

// The Person class represents a basic entity with attributes related to a person.
public class Person {

    // Attributes to store information about the person.
    private int height;             // Height of the person in cm
    private String hairColor;       // Hair color of the person
    private boolean is18OrOlder;    // Indicates if the person is 18 years or older

    // Constructor to initialize the attributes of the person.
    public Person(int height, String hairColor, boolean is18OrOlder) {
        this.height = height;
        this.hairColor = hairColor;
        this.is18OrOlder = is18OrOlder;
    }

    // Getter method to retrieve the height of the person.
    public int getHeight() {
        return height;
    }

    // Getter method to retrieve the hair color of the person.
    public String getHairColor() {
        return hairColor;
    }

    // Getter method to check if the person is 18 years or older.
    public boolean is18OrOlder() {
        return is18OrOlder;
    }
}

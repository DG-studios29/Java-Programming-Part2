package compulsorytask;

// Dog class representing a dog with its attributes and methods
public class Dog {
    private String name;
    private int age;
    private String breed;
    private boolean isMale;
    private double weight;

    // Constructor to initialize the Dog object with its attributes
    public Dog(String name, int age, String breed, boolean isMale, double weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.isMale = isMale;
        this.weight = weight;
    }

    // Method to generate a formatted string representation of the Dog object
    public String toString() {
        return "Dog: " + name + ", Age: " + age + " years, Breed: " + breed +
               ", Gender: " + (isMale ? "Male" : "Female") + ", Weight: " + weight + " kg";
    }
}

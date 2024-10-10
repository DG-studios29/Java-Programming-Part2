package compulsorytask;

// Cat class representing a cat with its attributes and methods
public class Cat {
    private String name;
    private int age;
    private String breed;
    private boolean isMale;
    private double weight;

    // Constructor to initialize the Cat object with its attributes
    public Cat(String name, int age, String breed, boolean isMale, double weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.isMale = isMale;
        this.weight = weight;
    }

    // Method to generate a formatted string representation of the Cat object
    public String toString() {
        return "Cat: " + name + ", Age: " + age + " years, Breed: " + breed +
               ", Gender: " + (isMale ? "Male" : "Female") + ", Weight: " + weight + " kg";
    }
}

package compulsorytask;

// School class containing the main method to demonstrate the Dog and Cat classes
public class School {
    public static void main(String[] args) {
        // Creating Dog objects with different attributes
        Dog dog1 = new Dog("Buddy", 3, "Labrador Retriever", true, 25.5);
        Dog dog2 = new Dog("Max", 2, "German Shepherd", true, 30.0);
        Dog dog3 = new Dog("Luna", 5, "Golden Retriever", false, 22.0);

        // Displaying information about each Dog using their toString method
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());

        // Creating Cat objects with different attributes
        Cat cat1 = new Cat("Whiskers", 4, "Siamese", true, 4.5);
        Cat cat2 = new Cat("Misty", 2, "Persian", false, 5.0);
        Cat cat3 = new Cat("Tiger", 3, "Bengal", true, 6.2);

        // Displaying information about each Cat using their toString method
        System.out.println(cat1.toString());
        System.out.println(cat2.toString());
        System.out.println(cat3.toString());
    }
}

package task2;

import java.util.Map;

public class Customer {
    private int orderNumber;
    private String name;
    private String contactNumber;
    private String address;
    private String location;
    private String email;
    private Map<String, Integer> orderedMeals;
    private Map<String, Double> mealPrices;
    private String specialInstructions;

    public Customer(int orderNumber, String name, String contactNumber, String address, String location, String email,
                    Map<String, Integer> orderedMeals, Map<String, Double> mealPrices, String specialInstructions) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.location = location;
        this.email = email;
        this.orderedMeals = orderedMeals;
        this.mealPrices = mealPrices;
        this.specialInstructions = specialInstructions;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Integer> getOrderedMeals() {
        return orderedMeals;
    }

    public Map<String, Double> getMealPrices() {
        return mealPrices;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }
}





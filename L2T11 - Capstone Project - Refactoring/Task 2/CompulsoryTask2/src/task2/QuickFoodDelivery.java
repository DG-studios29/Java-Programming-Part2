package task2;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class QuickFoodDelivery {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		try {
			// Capture customer details
			System.out.println("Enter order number: ");
			int orderNumber = scanner.nextInt();
			// Consume the newline
			scanner.nextLine(); 
			System.out.println("Enter customer name: ");
			String customerName = scanner.nextLine();
			System.out.println("Enter customer contact number: ");
			String customerContactNumber = scanner.nextLine();
			System.out.println("Enter customer address: ");
			String customerAddress = scanner.nextLine();
			System.out.println("Enter customer location (city): ");
			String customerLocation = scanner.nextLine();
			System.out.println("Enter customer email address: ");
			String customerEmail = scanner.nextLine();

			// Capture ordered meals
			Map<String, Integer> orderedMeals = new HashMap<>();
			Map<String, Double> mealPrices = new HashMap<>();
			while (true) {
				System.out.println("Enter meal name (or 'done' to finish): ");
				String mealName = scanner.nextLine();
				if (mealName.equalsIgnoreCase("done")) {
					break;
				}
				System.out.println("Enter quantity: ");
				int quantity = scanner.nextInt();
				System.out.println("Enter price per item: ");
				double price = scanner.nextDouble();
				scanner.nextLine(); // Consume the newline
				orderedMeals.put(mealName, quantity);
				mealPrices.put(mealName, price);
			}

			// Capture special instructions
			System.out.println("Enter special instructions: ");
			String specialInstructions = scanner.nextLine();

			Customer customer = new Customer(orderNumber, customerName, customerContactNumber, customerAddress,
					customerLocation, customerEmail, orderedMeals, mealPrices, specialInstructions);

			// Capture restaurant details
			System.out.println("Enter restaurant name: ");
			String restaurantName = scanner.nextLine();
			System.out.println("Enter restaurant location: ");
			String restaurantLocation = scanner.nextLine();
			System.out.println("Enter restaurant contact number: ");
			String restaurantContactNumber = scanner.nextLine();

			Restaurant restaurant = new Restaurant(restaurantName, restaurantLocation, restaurantContactNumber);

			// Read driver information from drivers.txt
			List<Driver> drivers = readDriversFromFile("drivers.txt");

			// Find the nearest driver with the smallest load
			Driver nearestDriver = findNearestDriver(drivers, restaurant.getLocation());

			// Generate the invoice
			generateInvoice(customer, restaurant, nearestDriver);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter valid data.");
		} catch (IOException e) {
			System.out.println("An error occurred while reading the driver information.");
		} finally {
			scanner.close();
		}
	}

	// Read driver information from a file and return a list of drivers
	private static List<Driver> readDriversFromFile(String fileName) throws IOException {
		List<Driver> drivers = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					String name = parts[0].trim();
					String location = parts[1].trim();
					int load = Integer.parseInt(parts[2].trim());
					drivers.add(new Driver(name, location, load));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Invalid load value in the file.");
		}

		return drivers;
	}

	// Find the nearest driver with the smallest load in the same location as the
	// restaurant
	private static Driver findNearestDriver(List<Driver> drivers, String restaurantLocation) {
		Driver nearestDriver = null;
		int minLoad = Integer.MAX_VALUE;

		for (Driver driver : drivers) {
			if (driver.getLocation().equalsIgnoreCase(restaurantLocation) && driver.getLoad() < minLoad) {
				nearestDriver = driver;
				minLoad = driver.getLoad();
			}
		}

		return nearestDriver;
	}

	// Generate the invoice and write it to a file
	private static void generateInvoice(Customer customer, Restaurant restaurant, Driver driver) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("invoice.txt"))) {
			if (driver != null) {
				writer.write("Order number " + customer.getOrderNumber() + "\n");
				writer.write("Customer: " + customer.getName() + "\n");
				writer.write("Email: " + customer.getEmail() + "\n");
				writer.write("Phone number: " + customer.getContactNumber() + "\n");
				writer.write("Location: " + customer.getLocation() + "\n\n");
				writer.write("You have ordered the following from " + restaurant.getName() + " in "
						+ restaurant.getLocation() + ":\n");

				double totalAmount = 0.0;
				for (Map.Entry<String, Integer> entry : customer.getOrderedMeals().entrySet()) {
					String mealName = entry.getKey();
					int quantity = entry.getValue();
					double price = customer.getMealPrices().get(mealName);
					double subtotal = price * quantity;
					totalAmount += subtotal;
					writer.write(quantity + " x " + mealName + " (R" + price + ") = R" + subtotal + "\n");
				}

				writer.write("Special instructions: " + customer.getSpecialInstructions() + "\n");
				writer.write("Total: R" + totalAmount + "\n");

				writer.write("\n" + driver.getName()
						+ " is nearest to the restaurant and so he will be delivering your order to you at:\n");
				writer.write(customer.getAddress() + "\n");
				writer.write(customer.getLocation() + "\n");

				writer.write("\nIf you need to contact the restaurant, their number is " + restaurant.getContactNumber()
						+ ".\n");
			} else {
				writer.write("Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
			}

			System.out.println("Invoice generated successfully. Check invoice.txt");
		} catch (IOException e) {
			System.out.println("An error occurred while generating the invoice: " + e.getMessage());
		}
	}
}

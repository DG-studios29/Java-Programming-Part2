package task1;

public class IQ {
    public static void main(String[] args) {
        // Create an array called 'testResults' to store the IQ test scores of 5 people
        int[] testResults = { 115, 130, 10, 95, 120 };

        // Calculate the average IQ score
        double averageIQ = calculateAverageIQ(testResults);

        // Assign the description based on the average IQ
        String description = assignDescription(averageIQ);

        // Print the average IQ and the assigned description
        System.out.println("Average IQ: " + averageIQ);
        System.out.println("Description: " + description);
    }

    // Method to calculate the average IQ score
    private static double calculateAverageIQ(int[] testResults) {
        int sum = 0;
        for (int score : testResults) {
            sum += score;
        }
        return (double) sum / testResults.length;
    }

    // Method to assign the appropriate description based on the IQ score
    private static String assignDescription(double averageIQ) {
        if (averageIQ >= 130) {
            return "Very superior";
        } else if (averageIQ >= 120) {
            return "Superior";
        } else if (averageIQ >= 110) {
            return "High average";
        } else if (averageIQ >= 90) {
            return "Average";
        } else if (averageIQ >= 80) {
            return "Low average";
        } else if (averageIQ >= 70) {
            return "Borderline";
        } else {
            return "Extremely low";
        }
    }
}

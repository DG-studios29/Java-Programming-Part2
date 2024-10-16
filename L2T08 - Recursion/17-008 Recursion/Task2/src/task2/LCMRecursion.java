package task2;

public class LCMRecursion {
    public static void main(String[] args) {
        int x = 12;
        int y = 18;
        int lcm = calculateLCM(x, y);
        System.out.println("LCM of " + x + " and " + y + " is: " + lcm);
    }

    public static int calculateLCM(int x, int y) {
        return (x * y) / calculateGCD(x, y);
    }

    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }
}



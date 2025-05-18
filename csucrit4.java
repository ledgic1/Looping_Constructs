import java.util.Scanner;

public class NumberStats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float sum = 0;
        float biggest = Float.NEGATIVE_INFINITY;
        float smallest = Float.POSITIVE_INFINITY;
        int i = 0;

        System.out.println("Please enter 5 decimal numbers:");

        while (i < 5) {
            System.out.print("Number " + (i + 1) + ": ");
            if (input.hasNextFloat()) {
                float num = input.nextFloat();
                sum += num;

                if (num > biggest) {
                    biggest = num;
                }
                if (num < smallest) {
                    smallest = num;
                }

                i++;
            } else {
                System.out.println("That wasn't a valid number. Try again.");
                input.next(); // Clear bad input
            }
        }

        float average = sum / 5;
        float interest = sum * 0.20f;

        System.out.println("\n--- Results ---");
        System.out.printf("Total: %.2f\n", sum);
        System.out.printf("Average: %.2f\n", average);
        System.out.printf("Highest: %.2f\n", biggest);
        System.out.printf("Lowest: %.2f\n", smallest);
        System.out.printf("20%% Interest on total: %.2f\n", interest);

        input.close();
    }
}

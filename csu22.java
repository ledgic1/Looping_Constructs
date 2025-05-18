import java.util.Scanner;

public class caleculateweeklytaxes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weekly income: $");
        double income = scanner.nextDouble();
        double Weeklytax;
        double taxes;

        if (income < 500) {
            Weeklytax = 0.10;
        } else if (income < 1500) {
            Weeklytax = 0.15;
        } else if (income < 2500) {
            Weeklytax = 0.20;
        } else {
            Weeklytax = 0.30;
        }

        taxes = income * Weeklytax;

        System.out.printf("Weekly average taxes: $%.2f\n", taxes);
        scanner.close();
    }
}
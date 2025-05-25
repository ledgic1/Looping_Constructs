import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        boolean running = true;

        while (running) {
            System.out.print("Enter a day of the week (Monday–Sunday) or type 'week' to view the report: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("week")) {
                if (days.isEmpty()) {
                    System.out.println("No data entered yet.");
                } else {
                    System.out.println("\n--- Weekly Temperature Report ---");
                    double total = 0;
                    for (int i = 0; i < days.size(); i++) {
                        System.out.println(days.get(i) + ": " + temperatures.get(i) + "°");
                        total += temperatures.get(i);
                    }
                    double average = total / temperatures.size();
                    System.out.printf("Weekly Average Temperature: %.2f°\n\n", average);
                }
            } else {
                boolean validDay = false;
                for (String day : validDays) {
                    if (day.equalsIgnoreCase(input)) {
                        validDay = true;
                        String formattedDay = capitalize(input);

                        // Avoid duplicate entries
                        if (days.contains(formattedDay)) {
                            System.out.println("You've already entered a temperature for " + formattedDay + ".");
                        } else {
                            System.out.print("Enter the average temperature for " + formattedDay + ": ");
                            try {
                                double temp = Double.parseDouble(scanner.nextLine());
                                days.add(formattedDay);
                                temperatures.add(temp);
                                System.out.println("Recorded: " + formattedDay + " - " + temp + "°\n");
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid temperature input. Please enter a numeric value.\n");
                            }
                        }
                        break;
                    }
                }

                if (!validDay) {
                    System.out.println("Invalid input. Please enter a valid day (Monday–Sunday) or type 'week'.\n");
                }
            }

           
            System.out.print("Would you like to exit the program? (y/n): ");
            String quit = scanner.nextLine().trim();
            if (quit.equalsIgnoreCase("y")) {
                running = false;
                System.out.println("Exiting program. Goodbye!");
            }
        }

        scanner.close();
    }

    
    public static String capitalize(String str) {
        if (str.isEmpty()) return str;
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}

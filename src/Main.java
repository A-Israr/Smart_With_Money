import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------");
        System.out.printf("%-100s%n" , "Smart With Money");
        System.out.println("-------------------------------");


        System.out.println("Press enter to continue to the main menu");
        input.nextLine();
        clearScreen();

        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Set or Change Monthly Budget");
            System.out.println("2. Add to your Monthly Expenses");
            System.out.println("3. Check your monthly budget summary");
            System.out.println("0. Exit");

            int option = input.nextInt();

            switch (option) {
                case 1: {
                    Budget budget = new Budget();
                    System.out.print("Enter the new monthly budget: ");
                    double userBudget = input.nextDouble();
                    budget.setMonthlyBudget(userBudget);
                    break;
                }
                case 2: {
                    Expense expense = new Expense();
                    expense.inputExpense();
                    try {
                        WriteExpense.writeToFile(expense);
                        System.out.println("Expense written to file successfully.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    ExpenseSummary expenseSummary = new ExpenseSummary();
                    ReadExpense.readExpensesAndUpdateSummary(expenseSummary);
                    expenseSummary.generateSummary();
                    break;
                }
                case 0: {
                    System.out.println("Are you sure you want to exit the program? (Yes/No)");
                    String confirmation = input.next();
                    if (confirmation.equalsIgnoreCase("Yes")) {
                        System.out.println("Exiting the program.");
                        return;
                    } else if (confirmation.equalsIgnoreCase("No")) {
                        System.out.println("Returning to the main menu.");
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                        break;
                    }
                }
                default: {
                    System.out.println("Invalid option. Please select a valid option.");
                }
            }
        }
    }
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
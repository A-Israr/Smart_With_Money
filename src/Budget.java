import java.io.*;
import java.util.*;

class Budget {
    private double monthlyBudget;
    private static final String BUDGET_FILE = "budget.txt";

    public Budget() {
        loadBudget();
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
        saveBudget();
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    private void saveBudget() {
        File file = new File(BUDGET_FILE);
        try ( FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.valueOf(monthlyBudget));
        } catch (IOException e) {
            System.out.println("Error saving budget: " + e.getMessage());
        }
    }

    private void loadBudget() {
        try (Scanner fileScanner = new Scanner(new File(BUDGET_FILE))) {
            if (fileScanner.hasNextLine()) {
                String budgetStr = fileScanner.nextLine();
                monthlyBudget = Double.parseDouble(budgetStr);
            }
            }

        catch (Exception e) {
            System.out.println("Error loading budget: " + e.getMessage());
        }
    }
}


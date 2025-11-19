import java.io.*;
import java.util.*;

public class ReadExpense {

    public static void readExpensesAndUpdateSummary(ExpenseSummary expenseSummary) {
        try (Scanner fileScanner = new Scanner(new File("expenses.csv"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");

                String expenseName = data[0];
                Category category = parseCategory(data[1]);
                double expenseAmount = Double.parseDouble(data[2]);

                Expense expense = new Expense(expenseName, category, expenseAmount);
                expenseSummary.addExpense(expense);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading expenses from file: " + e.getMessage());
        }
    }

    private static Category parseCategory(String categoryName) {
        for (Category category : Category.values()) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName.trim())) {
                return category;
            }
        }
        throw new IllegalArgumentException("No category found for: " + categoryName);
    }
}

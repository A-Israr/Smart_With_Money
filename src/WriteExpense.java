import java.io.*;

public class WriteExpense {
    public static void writeToFile(Expense expense) {
        String File = "expenses.csv";
        try {
            FileWriter writer = new FileWriter(File, true);
            writer.append(expense.name);
            writer.append(",");
            writer.append(expense.category.getCategoryName());
            writer.append(",");
            writer.append(String.valueOf(expense.amount));
            writer.append("\n");
            writer.flush();
            writer.close();
            System.out.println("Expense added to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}


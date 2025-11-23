# Smart With Money 💰

Smart With Money is a simple Java console-based budgeting application that helps users manage their monthly budget and track expenses from the command line. It provides a menu-driven interface to set a monthly budget, add expenses, and view a summary of how much of the budget has been used.

> ✅ This project advanced to the **second round of the Project Showcase segment of the National Steam Olympiad Bangladesh 2023**.

---

## Features

When you run the program, you’ll see a simple main menu:

1. **Set or Change Monthly Budget**  
   - Enter a new monthly budget amount.
   - Updates the current budget for the month.

2. **Add to Your Monthly Expenses**  
   - Input a new expense via the `Expense` class.
   - The expense is written to a file using `WriteExpense.writeToFile(...)`.

3. **Check Your Monthly Budget Summary**  
   - Reads all stored expenses using `ReadExpense.readExpensesAndUpdateSummary(...)`.
   - Uses `ExpenseSummary` to compute and display a summary of:
     - Total expenses
     - Remaining budget
     - Whether you’ve exceeded your budget

0. **Exit**  
   - Asks for confirmation (`Yes/No`) before exiting the program.

There is also a `clearScreen()` utility method that attempts to clear the console between screens (works best in a real terminal).

---

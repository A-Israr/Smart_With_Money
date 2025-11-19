public class ExpenseSummary {
    private final double[] categoryExpenses;
    Budget budget = new Budget();

    public ExpenseSummary() {
        categoryExpenses = new double[Category.values().length];
    }

    public void addExpense(Expense expense) {
        Category category = expense.category;
        double amount = expense.amount;
        categoryExpenses[category.ordinal()] += amount;
    }

    public void generateSummary() {
        double totalExpense = 0;
        for (double expense : categoryExpenses) {
            totalExpense += expense;
        }

        System.out.println("Expense Summary:");
        System.out.println("-------------------------------");
        System.out.printf("%-60s%-15s%-15s%-15s%n", "Category", "Expense", "Percentage", "Target");
        System.out.println("-------------------------------");
        for (Category category : Category.values()) {
            double categoryExpense = categoryExpenses[category.ordinal()];
            double percentage = (categoryExpense / budget.getMonthlyBudget()) * 100;
            double targetPercentage = category.getPercentage();

            if(percentage > targetPercentage){
                System.out.println();
                System.out.println("You've exceeded budget for " + category.getCategoryName() + "category!!");
                System.out.println();
            }

            System.out.printf("%-60s%-15.2f%-15.2f%-15.2f%n", category.getCategoryName(), categoryExpense, percentage, targetPercentage);
        }
        System.out.println("-------------------------------");
        System.out.printf("%-60s%-15.2f%n", "Total Expense:", totalExpense);
        System.out.println("-------------------------------");
        System.out.printf("%-60s%-15.2f%n", "Your monthly budget: " , budget.getMonthlyBudget());
        double remainingBudget = budget.getMonthlyBudget() - totalExpense;
        System.out.printf("%-60s%-15.2f%n", "Your remaining budget: " , remainingBudget);
        if(remainingBudget < 0){
            System.out.printf("%-60s%n", "You've exceeded your budget this month!!");
        }
    }
}


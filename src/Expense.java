import java.util.*;
public class Expense {
    String name;
    Category category;
    double amount;
    public Expense(){}
    public Expense(String name, Category category, double amount){
        this.name = name;
        this.category = category;
        this.amount = amount;
    }
    public void inputExpense(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expense name: ");
        this.name = input.nextLine();
        System.out.print("Select an expense category: ");
        for (Category c : Category.values()) {
            System.out.println(c.ordinal() + 1 + ". " + c.getCategoryName());
        }
        int categoryChoice = input.nextInt();
        this.category = Category.values()[categoryChoice - 1];

        System.out.print("Enter expense amount: ");
        this.amount = input.nextDouble();


    }


}

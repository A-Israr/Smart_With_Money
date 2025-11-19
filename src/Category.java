public enum Category {
    HOUSING("Housing (rent or hostel)", 30),
    UTILITIES("Utilities (electricity or water or internet)", 10),
    FOOD("Food (groceries or eating out)", 15),
    TRANSPORTATION("Transportation", 15),
    MEDICAL_EXPENSES("Medical Expenses", 5),
    TEXTBOOK_AND_SCHOOL_SUPPLIES("Textbook and school supplies", 5),
    ENTERTAINMENT("Entertainment and Social Activities", 5),
    PERSONAL_EXPENSES("Personal expenses (clothing or toiletries etc.)", 5),
    MISCELLANEOUS("Miscellaneous", 10),
    SAVINGS("Savings", 10);

    private final String categoryName;
    private final int percentage;

    Category(String categoryName, int percentage) {
        this.categoryName = categoryName;
        this.percentage = percentage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getPercentage() {
        return percentage;
    }
}

package yandexPracticum.sprints.sprint2;

class MonthFlowItem {

    String itemName;
    boolean isExpense;
    int quantity;
    int unitPrice;

    public MonthFlowItem(String itemName, boolean isExpense, int quantity, int unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }
}

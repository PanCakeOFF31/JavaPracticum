package yandexPracticum.sprints.sprint2;

import java.util.ArrayList;
import java.util.HashMap;

public class MonthReporter {
    HashMap<String, ArrayList<MonthFlowItem>> monthFlows = new HashMap<>();
    ArrayList<MonthFlowItem> monthItems = new ArrayList<>();
    ArrayList<String> listLine;
    private final String[] monthNames = {"Январь", "Февраль", "Март"}; // Строковые ключи месяцев


    //    item_name,is_expense,quantity,unit_price
    public void loadFile(ArrayList<String> months) {
        FileReader fileReader = new FileReader();
        for (int i = 0; i < months.size();++i) {
            String monthPath = months.get(i);

            listLine = fileReader.readFileContents(monthPath);

            for (int j = 1; j < listLine.size(); ++j) {
                String[] lineContent = listLine.get(j).split(",");
                if (lineContent.length != 4) {
                    continue;
                }
                String itemName = lineContent[0];
                boolean isExpense = Boolean.parseBoolean(lineContent[1]);
                int quantity = Integer.parseInt(lineContent[2]);
                int unitPrice = Integer.parseInt(lineContent[3]);

                MonthFlowItem monthFlowItem;
                monthFlowItem = new MonthFlowItem(itemName, isExpense, quantity, unitPrice);

                monthItems.add(monthFlowItem);
            }

            monthFlows.put(monthNames[i], monthItems);
        }

        System.out.println("Месячный отчеты успешно считаны");

    }
}

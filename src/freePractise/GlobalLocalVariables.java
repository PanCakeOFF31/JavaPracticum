package freePractise;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

class GlobalLocalVariables {
    private static final int illustration = 10;
    static void globalLocalVariables() {
        printSection("Пример перекрытия переменной класса - затенение:");
//        Затенение переменной класса
        int illustration = 20;
        System.out.println("illustration = " + illustration);
        System.out.println("GlobalLocalVariable.illustration = " + GlobalLocalVariables.illustration);
        printSectionEnding();
    }
}

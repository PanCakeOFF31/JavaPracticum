package freePractise.asStream;

import static helpers.Helpers.*;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class AsStream {
   public static void asStream() {
       printSection("AsStream:");

       ArrList list = new ArrList();
       list.filter((n) -> n);

       printSectionEnding();
   }

}
class ArrList extends MyStream {
    private Integer[] innerValue;
    public ArrList() {

    }
}
class MyStream {
    private Integer[] innerValue;

    public MyStream() {
    }


    public MyStream(Integer[] innerValue) {
        this.innerValue = innerValue;
    }

    public Integer[] filter(UnaryOperator function) {
        return (Integer[]) function.apply(innerValue);
    }

}



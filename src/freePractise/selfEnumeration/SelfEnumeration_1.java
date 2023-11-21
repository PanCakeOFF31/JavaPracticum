package freePractise.selfEnumeration;

public class SelfEnumeration_1 {
    static void selfEnumeration_1() {
        SeasonOfYear seasons = SeasonOfYear.WINTER;
        seasons = SeasonOfYear.SUMMER;
        System.out.println("seasons.toString() = " + seasons.toString());
        System.out.println("SeasonOfYear.WINTER = " + SeasonOfYear.WINTER);

        System.out.println(seasons.getOrdinal());
        System.out.println(SeasonOfYear.WINTER.getOrdinal());
    }
}

abstract class SeasonOfYear {
    public static final SeasonOfYear WINTER = new Winter();
    public static final SeasonOfYear SUMMER = new Summer();
    private static final SeasonOfYear[] seasons = {WINTER, SUMMER};
    private final String title;
    protected final int ordinal;

    protected SeasonOfYear(String title, int ordinal) {
        this.title = title;
        this.ordinal = ordinal;
    }

    abstract public String toString();

    protected String getTitle() {
        return title;
    }

    protected int getOrdinal() {
        return ordinal;
    }
}

class Winter extends SeasonOfYear {
    protected Winter() {
        super("WINTER",1);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}

class Summer extends SeasonOfYear {
    protected Summer() {
        super("SUMMER",2);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}


//class SOY {
//    private static final SOY SEASONS = new SOY("SOY");
//    public static final SOY.WINTER WINTER = SEASONS.new WINTER("WINTER");
////    public static final SOY SUMMER = SOY.SUMMER;
////    private static final SOY[] seasons = {WINTER, SUMMER};
//    private static int commonOrdinal = 0;
//    private final String title;
//
//    //    private final int ordinal;
//    @Override
//    public String toString() {
//        return title;
//    }
//
//    private SOY(String title) {
//        this.title = title;
//    }
//
//    private class WINTER {
//        private final String title = "WINTER";
//
//        public WINTER(String title) {
//            this.
//        }
//    }
//
//    private class SUMMER {
//        private final String title = "SUMMER";
//    }
//}
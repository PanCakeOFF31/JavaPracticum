package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class Coordinates<T extends TwoDimensional> {

    private T[] coordinates;

    public T[] getCoordinates() {
        return coordinates;
    }

    public Coordinates(T[] coordinates) {
        this.coordinates = coordinates;
    }

    //    public static void showXY(Coordinates<?> coordinates) {
    public static void showXY(Coordinates<? super FourDimensional> coordinates) {
        for (TwoDimensional coordinate : coordinates.getCoordinates()) {
            System.out.println(coordinate.getX() + " " + coordinate.getY());
        }
    }


    public static void showXYZ(Coordinates<? extends ThreeDimansional> coordinates) {
        for (ThreeDimansional coordinate : coordinates.getCoordinates()) {
            System.out.println(coordinate.getX() + " " + coordinate.getY() + " " +
                    coordinate.getZ());
        }
    }

    public static void showXYZT(Coordinates<? extends FourDimensional> coordinates) {
        for (FourDimensional coordinate : coordinates.getCoordinates()) {
            System.out.println(coordinate.getX() + " " + coordinate.getY() + " " +
                    coordinate.getZ() + " " + coordinate.getT());
        }
    }
}

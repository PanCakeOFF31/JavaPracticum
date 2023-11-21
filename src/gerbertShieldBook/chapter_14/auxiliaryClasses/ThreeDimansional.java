package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class ThreeDimansional extends TwoDimensional {
    protected double z;

    public ThreeDimansional(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }
}

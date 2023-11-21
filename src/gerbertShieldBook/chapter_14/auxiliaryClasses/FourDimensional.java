package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class FourDimensional extends ThreeDimansional{
    protected double t;

    public FourDimensional(double x, double y, double z, double t) {
        super(x, y, z);
        this.t = t;
    }

    public double getT() {
        return t;
    }
}

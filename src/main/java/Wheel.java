public class Wheel {
    private int diameter;
    private int height;
    private int ar;
    private boolean centerZ;

    public Wheel(int diameter, int height, int ar, boolean centerZ) {
        this.diameter = diameter;
        this.height = height;
        this.ar = ar;
        this.centerZ = centerZ;
    }


    public int getDiameter() {
        return diameter;
    }

    public int getHeight() {
        return height;
    }

    public int getAr() {
        return ar;
    }

    public boolean isCenterZ() {
        return centerZ;
    }
}

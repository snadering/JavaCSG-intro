public class BoxLights {
    private int xSize;
    private int ySize;
    private int zSize;
    private boolean centerZ;

    public BoxLights(int xSize, int ySize, int zSize, boolean centerZ) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.centerZ = centerZ;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getzSize() {
        return zSize;
    }

    public boolean isCenterZ() {
        return centerZ;
    }
}

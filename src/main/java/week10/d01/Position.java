package week10.d01;

public class Position {

    private double posZ;
    private double posX;
    private double posY;

    public Position(double posX, double posY, double posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public Position(double posZ) {
        this.posX = 0.0;
        this.posY = 0.0;
        this.posZ = posZ;
    }

    public double getPosZ() {
        return posZ;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

}

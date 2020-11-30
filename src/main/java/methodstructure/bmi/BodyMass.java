package methodstructure.bmi;

public class BodyMass {

    private double weight;

    private double height;

    public BodyMass(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double bodyMassIndex() {
        return 1.0 * weight / Math.pow(height, 2);
    }

    public BmiCategory body() {
        double d = bodyMassIndex();
        if (d < 18.5) {
            return BmiCategory.UNDERWEIGHT;
        } else if (d > 25.0) {
            return BmiCategory.OVERWEIGHT;
        } else {
            return BmiCategory.NORMAL;
        }
    }

    public boolean isThinnerThan(BodyMass bm) {
        return bodyMassIndex() < bm.bodyMassIndex();
    }

}

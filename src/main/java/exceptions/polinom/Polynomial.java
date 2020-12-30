package exceptions.polinom;

public class Polynomial {

    private double[] coefficients;

    public Polynomial(double[] coefficients) {
        if (coefficients == null) {
            throw new NullPointerException("coefficients is null");
        }
        this.coefficients = coefficients;
    }

    public Polynomial(String[] coefficientStrs) {
        if (coefficientStrs == null) {
            throw new NullPointerException("coefficientStrs is null");
        }
        try {
            double[] coefficients = new double[coefficientStrs.length];
            for (int i = 0; i < coefficientStrs.length; i++) {
                coefficients[i] = Double.parseDouble(coefficientStrs[i]);
            }
            this.coefficients = coefficients;
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Illegal coefficients, not a number", iae);
        }
    }

    public double evaluate(double x) {
        int n = coefficients.length - 1;
        double sum = 0;
        for (int j = n; j >= 0; j--) {
            sum += coefficients[j] * Math.pow(x, (double) n - j);
        }
        return sum;
    }

    public double[] getCoefficients() {
        return coefficients;
    }

}

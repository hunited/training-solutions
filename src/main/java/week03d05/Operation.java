package week03d05;

public class Operation {

    private int leftOperand;
    private int rightOperand;

    public Operation(String operands) {
        int plusSign = operands.indexOf("+");
        if (plusSign > 0) {
            leftOperand = Integer.parseInt(operands.substring(0, plusSign).trim());
            rightOperand = Integer.parseInt(operands.substring(plusSign + 1).trim());
        } else {
            System.out.println("Nem adtál meg Plusz karaktert!");
        }
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }

}

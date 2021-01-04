package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String checkboxes) {
        try {
            return converter.binaryStringToBooleanArray(checkboxes);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }
    }

    public int answerTruePercent(String answers) {
        int answer = 0;
        for (int i = 0; i < answers.length(); i++) {
            if (answers.charAt(i) == '1') {
                answer++;
            }
        }
        double temp = 100.0 * answer / answers.length();
        return (int) temp;
    }

}

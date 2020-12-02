package methodvarargs.examstats;

public class ExamStats {

    private int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        chechEmpty(results);
        int i = 0;
        for (int result : results) {
            if (result >= limitInPercent) {
                i++;
            }
        }
        return i;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        chechEmpty(results);
        int i = 0;
        for (int result : results) {
            if (result < limitInPercent) {
                i++;
            }
        }
        return i > 0;
    }

    private void chechEmpty(int[] results) {
        if (results == null || results.length < 1) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    }

    public int getMaxPoints() {
        return maxPoints;
    }

}

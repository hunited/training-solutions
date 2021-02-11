package week15.d04;

public class Case implements Comparable<Case> {

    private final int cases;
    private final String yearAndWeek;

    public Case(int cases, String yearAndWeek) {
        this.cases = cases;
        this.yearAndWeek = yearAndWeek;
    }

    public int getCases() {
        return cases;
    }

    public String getYearAndWeek() {
        return yearAndWeek;
    }

    @Override
    public int compareTo(Case o) {
        return this.getCases() - o.getCases();
    }

}

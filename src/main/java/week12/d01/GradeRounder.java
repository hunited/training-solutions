package week12.d01;

public class GradeRounder {

    public int[] roundGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 0 || grades[i] > 100) {
                throw new IllegalArgumentException("Non valid numbers");
            } else if (grades[i] >= 40 && grades[i] % 5 > 2) {
                grades[i] += (5 - grades[i] % 5);
            }
        }
        return grades;
    }

}

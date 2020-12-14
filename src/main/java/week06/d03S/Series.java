package week06.d03S;

import java.util.List;

public class Series {

    public SeriesType calculateSeriesType(List<Integer> nums) {
        checkSize(nums);
        SeriesType type = nums.get(0) < nums.get(1) ? SeriesType.ASCENDING : SeriesType.DESCENDING;
        for (int i = 2; i < nums.size(); i++) {
            if ((nums.get(i - 1) < nums.get(i) && type == SeriesType.DESCENDING) ||
                    (nums.get(i - 1) > nums.get(i) && type == SeriesType.ASCENDING)) {
                return SeriesType.OTHER;
            }
        }
        return type;
    }

    private void checkSize(List<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            throw new IllegalArgumentException("Legalább két elem kell a listába!");
        }
    }

}

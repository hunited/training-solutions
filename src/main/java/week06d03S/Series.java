package week06d03S;

import java.util.List;

public class Series {

    private SeriesType type = SeriesType.OTHER;

    public SeriesType calculateSeriesType(List<Integer> nums) {
        boolean asc = true;
        boolean desc = true;
        for (int i = 1; i < nums.size() && (desc || asc); ++i) {
            if (nums.get(i - 1) < nums.get(i)) {
                desc = false;
            } else {
                asc = false;
            }
        }
        if (asc) {
            return SeriesType.ASCENDING;
        }
        if (desc) {
            return SeriesType.DESCENDING;
        }
        return type;
    }

}

package week06d01;

import java.util.List;

public class ListSelector {

    public StringBuilder evenSelector(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("A lista null!");
        }
        StringBuilder sb = new StringBuilder("");
        sbPrePostGenerator(list, sb, '[');
        forGenerator(list, sb);
        sbPrePostGenerator(list, sb, ']');
        return sb;
    }

    public void forGenerator(List<String> list, StringBuilder sb) {
        for (int i = 0; i < list.size(); i = i + 2) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(list.get(i));
        }
    }

    public void sbPrePostGenerator(List<String> list, StringBuilder sb, char c) {
        if (list.size() != 0) {
            sb.append(c);
        }
    }

}

package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class NewsPaper implements Printable {

    private List<String> newsPapers = new ArrayList<>();

    @Override
    public int getLength() {
        return newsPapers.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return newsPapers.get(pageNumber);
    }

    public void addPage(String page) {
        newsPapers.add(page);
    }

}

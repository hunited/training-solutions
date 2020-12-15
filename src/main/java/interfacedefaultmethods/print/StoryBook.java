package interfacedefaultmethods.print;

import java.util.ArrayList;
import java.util.List;

public class StoryBook implements Printable {

    private List<ColoredPage> coloredPages = new ArrayList<>();

    @Override
    public int getLength() {
        return coloredPages.size();
    }

    @Override
    public String getPage(int pageNumber) {
        return coloredPages.get(pageNumber).getPage();
    }

    @Override
    public String getColor(int pageNumber) {
        return coloredPages.get(pageNumber).getColor();
    }

    public void addPage(String page, String color) {
        coloredPages.add(new ColoredPage(page, color));
    }

}

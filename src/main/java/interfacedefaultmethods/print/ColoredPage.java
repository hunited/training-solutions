package interfacedefaultmethods.print;

public class ColoredPage {

    private String page;
    private String color;

    public ColoredPage(String content, String color) {
        this.page = content;
        this.color = color;
    }

    public ColoredPage(String content) {
        this.page = content;
        this.color = Printable.BLACK;
    }

    public String getPage() {
        return page;
    }

    public String getColor() {
        return color;
    }

}

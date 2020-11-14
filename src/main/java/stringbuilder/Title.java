package stringbuilder;

public enum Title {

    MR("Mr."),MRS("Ms."), MS("Ms."), DR("Dr."), PROF("Prof.");

    private String titleString;

    Title(String titleString) {
        this.titleString = titleString;
    }

    public String getTitleString() {
        return titleString;
    }
}

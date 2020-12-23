package stringconcat.stringconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this(familyName, middleName, givenName);
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public String concatNameWesternStyle() {
        String fullname = "";
        if (title != null) {
            fullname += title.getTitleString() + " ";
        }
        fullname += givenName + " ";
        if (middleName != null && !"".equals(middleName)) {
            fullname += middleName + " ";
        }
        fullname += familyName;
        return fullname;
    }

    public String concatNameHungarianStyle() {
        String fullname = "";
        if (title != null) {
            fullname = fullname.concat(title.getTitleString() + " ");
        }
        fullname = fullname.concat(familyName + " ");
        if (middleName != null && !"".equals(middleName)) {
            fullname = fullname.concat(middleName + " ");
        }
        fullname = fullname.concat(givenName);
        return fullname;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}

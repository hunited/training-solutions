package stringbuilder;

public class NameBuilder {

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder nameString = new StringBuilder("");

        if (title != null) {
            nameString.append(title.getTitleString()).append(" ").append(givenName);
        } else {
            nameString.append(givenName);
        }
        nameString.append(" ");
        if (middleName != null && !"".equals(middleName)) {
            nameString.append(middleName).append(" ");
        }
        nameString.append(familyName);

        return nameString.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder nameString = new StringBuilder("");

        if (title != null) {
            nameString.append(title.getTitleString()).append(" ").append(familyName);
        } else {
            nameString.append(familyName);
        }
        nameString.append(" ");
        if (middleName != null && !"".equals(middleName)) {
            nameString.append(middleName).append(" ");
        }
        nameString.append(givenName);

        return nameString.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder ins = new StringBuilder(name);
        ins.insert(ins.indexOf(where) + 1, (title.getTitleString() + " "));
        return ins.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder del = new StringBuilder(name);
        del.delete(name.indexOf(delete), name.indexOf(delete) + delete.length());
        return del.toString();
    }

    public boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}

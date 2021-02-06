package collectionsmap;

import java.time.LocalDate;

public class Entry {

    private final String ipAddress;
    private final LocalDate entryDate;
    private final String login;

    public Entry(String ipAddress, LocalDate entryDate, String login) {
        this.ipAddress = ipAddress;
        this.entryDate = entryDate;
        this.login = login;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public String getLogin() {
        return login;
    }

}

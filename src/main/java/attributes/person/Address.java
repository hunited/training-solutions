package attributes.person;

public class Address {

    private String country;

    private String city;

    private String streetNumber;

    private String zipCode;

    public Address(String country, String city, String streetNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }

    public void correctData(String country, String city, String streetNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String addressToString() {
        return getCountry() +
                ", " + getZipCode() +
                " " + getCity() +
                ", " + getStreetNumber() + ".";
    }

}

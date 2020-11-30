package immutable.satellite;

public class Satellite {

    private String registerIdent;

    private CelestialCoordinates destinationCC;

    public Satellite(CelestialCoordinates destinationCC, String registerIdent) {
        isEmpty(registerIdent, "Register ident must not be empty!");
        this.registerIdent = registerIdent;
        this.destinationCC = destinationCC;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCC = new CelestialCoordinates(
                destinationCC.getX() + diff.getX(),
                destinationCC.getY() + diff.getY(),
                destinationCC.getZ() + diff.getZ()
        );
    }

    public CelestialCoordinates getDestinationCC() {
        return destinationCC;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public String toString() {
        return registerIdent + ": " + destinationCC.toString();
    }

    private void isEmpty(String str, String msg) {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException(msg);
        }
    }

}

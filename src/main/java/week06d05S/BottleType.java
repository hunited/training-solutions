package week06d05S;

public enum BottleType {

    GLASS_BOTTLE(300), PET_BOTTLE(500);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

}

package week02d02;

public enum Category {
    FROZEN(0), DAIRY(0), BAKEDGOODS(0), OTHER(0);

    private int piece;

    Category(int piece) {
        this.piece = piece;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }
}

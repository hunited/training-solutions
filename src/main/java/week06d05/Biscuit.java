package week06d05;

public class Biscuit {

    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        if (gramAmount < 1) {
            throw new IllegalArgumentException("A mennyiség nem lehet egynél kevesebb!");
        }
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType biscuitType, int gramAmount) {
        return new Biscuit(biscuitType, gramAmount);
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    public static void main(String[] args) {
        Biscuit hk = of(BiscuitType.HAZTARTASIKEKSZ, 300);
        System.out.print(hk.getType());
        System.out.print(" ");
        System.out.print(hk.getGramAmount());
    }

}

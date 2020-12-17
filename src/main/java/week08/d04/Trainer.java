package week08.d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer t1 = new Trainer(new GoodMood());
        Trainer t2 = new Trainer(new BadMood());
        System.out.println(t1.giveMark());
        System.out.println(t2.giveMark());
    }


}

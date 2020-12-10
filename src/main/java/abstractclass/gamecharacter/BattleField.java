package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        boolean temp = attacker.isAlive() && attacker.isAlive();
        if (temp) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
        }
        return temp;
    }

    public Character fight(Character one, Character other) {
        while (one.isAlive() && other.isAlive()) {
            oneHit(one, other);
            oneHit(other, one);
            round++;
        }
        return one.isAlive() && !other.isAlive() ? one : other;
    }

}

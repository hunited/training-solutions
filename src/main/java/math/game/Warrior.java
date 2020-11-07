package math.game;

import java.util.Random;

public class Warrior {

    private final Random rnd = new Random();

    private String name;
    private Point position;
    private int stamina;
    private double skill;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        this.stamina = rnd.nextInt(81) + 20;
        this.skill = rnd.nextDouble();
    }

    public void move(Warrior forward) {
        int newX = position.getX();
        int newY = position.getY();
        if (forward.getPosition().getX() - position.getX() > 0) {
            newX++;
        } else if (forward.getPosition().getX() - position.getX() < 0) {
            newX--;
        }
        if (forward.getPosition().getY() - position.getY() > 0) {
            newY++;
        } else if (forward.getPosition().getY() - position.getY() < 0) {
            newY--;
        }
        position = new Point(newX, newY);
    }

    public void attack(Warrior warrior) {
        if (rnd.nextDouble() < skill) {
            warrior.stamina -= rnd.nextInt(3) + 1;
        }
    }

    public double distance(Warrior other) {
        return position.distance(other.position);
    }

    public boolean isAlive() {
        return stamina > 0;
    }

    public String toString() {
        return name + ": (" + position.getX() + "," + position.getY() + ") " + stamina;
    }

    public Point getPosition() {
        return position;
    }

}

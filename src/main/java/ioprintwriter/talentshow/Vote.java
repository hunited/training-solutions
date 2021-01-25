package ioprintwriter.talentshow;

public class Vote {

    private final int id;
    private int number;

    public Vote(int id, int number) {
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void incNum() {
        this.number += 1;
    }

}

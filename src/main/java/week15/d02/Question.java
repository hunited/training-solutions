package week15.d02;

public class Question {

    private String question;
    private String answer;
    private int point;
    private String theme;

    public Question(String question, String answer, int point, String theme) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoint() {
        return point;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Question: " + question + " Answer: " + answer + ", point: " + point + ", theme: " + theme + ".";
    }

}

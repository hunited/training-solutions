package week08.d01;

public class Robot {

    public Position dirrection(Position position, String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'F') {
                position.setY(position.getY() + 1);
            } else if (input.charAt(i) == 'L') {
                position.setY(position.getY() - 1);
            } else if (input.charAt(i) == 'B') {
                position.setX(position.getX() - 1);
            } else if (input.charAt(i) == 'J') {
                position.setX(position.getX() + 1);
            } else {
                throw new IllegalArgumentException("Hibás utasítás!");
            }
        }
        return position;
    }

}

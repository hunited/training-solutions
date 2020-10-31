package statements;

public class StatementMain {
    public static void main(String[] args) {
        int x = 5 + 6;

        int y = 11 - x;

        int z = 8;

        boolean b = x > y; // ? true : false; Ez itt nem kell feltétlen boolean esetén

        boolean c = b || (z > 5); // ? true : false; szintén

        z++;

    }
}

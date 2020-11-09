package literals;

public class LiteralsMain {

    public static void main(String[] args) {

        System.out.println("" + 1 + 2);
        System.out.println(1 + "" + 2);
        System.out.println(Integer.toString(12));

        double quotient = 3 / 4;
        quotient = 3 / 4D;
        System.out.println(quotient);

        long big = 3_244_444_444L;

        String s = "árvíztűrőtükörfúrógép";
        System.out.println(s);

        String word = "title".toUpperCase();
        System.out.println(word);

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-2));

        System.out.println(0b00000001);

    }

}

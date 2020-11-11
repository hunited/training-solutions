package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        WhichType whichType = new WhichType();

        System.out.println(whichType.whichType("127"));
        System.out.println(whichType.whichType("32767"));
        System.out.println(whichType.whichType("2147483647"));
        System.out.println(whichType.whichType("9223372036854775807"));

        System.out.println(Byte.MIN_VALUE + " tól " + Byte.MAX_VALUE + " ig.");
        System.out.println(Short.MIN_VALUE + " tól " + Short.MAX_VALUE + " ig.");
        System.out.println(Integer.MIN_VALUE + " tól " + Integer.MAX_VALUE + " ig.");
        System.out.println(Long.MIN_VALUE + " tól " + Long.MAX_VALUE + " ig.");

    }

}

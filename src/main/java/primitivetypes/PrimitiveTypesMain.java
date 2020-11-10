package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {

        System.out.println("100");
        System.out.println(new PrimitiveTypes().toBinaryString(100));
        System.out.println(Integer.toBinaryString(100));

        System.out.println("-100");
        System.out.println(new PrimitiveTypes().toBinaryString(-100));
        System.out.println(Integer.toBinaryString(-100));

        System.out.println("-3485");
        System.out.println(new PrimitiveTypes().toBinaryString(-3485));
        System.out.println(Integer.toBinaryString(-3485));

        System.out.println("-10");
        System.out.println(new PrimitiveTypes().toBinaryString(-10));
        System.out.println(Integer.toBinaryString(-10));

        System.out.println("-10 re");
        int i = 0b11111111111111111111111111110110;
        System.out.println(i);

        Integer integerSum = new Integer(1) + new Integer(2);
        System.out.println(new Integer(1) + new Integer(2));
        System.out.println(integerSum);

    }

}

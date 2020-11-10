package operators;

public class OperatorsMain {

    public static void main(String[] args) {

        Operators operators = new Operators();

        System.out.println(operators.isEven(7));
        System.out.println(operators.isEven(6));

        System.out.println(Integer.toBinaryString(16 >> 1));
        System.out.println(Integer.toBinaryString(16 << 1));
        System.out.println(Integer.toBinaryString(13 >> 1));
        System.out.println(Integer.toBinaryString(13 << 1));

        /**
         * Osztás és szorzás. A jobbra léptetés osztja kettővel,a balra léptetés szorozza kettővel.
         * A 13 páratlan, ezért a típuskonverzió miatt adatvesztés történik.
         */

        System.out.println(operators.multiplyByPowerOfTwo(16, 3));

        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        //int j = Integer.parseInt(s, 2);
        //System.out.println(j);

        /**
         * Azért ad hibát, és azért megoldás rá a Long, mert a 32 darab egyes az int max értéke,
         * és nem tudja hogy negatívként kell értelmeznie, vagy nem. A Long típusba viszont ez a kifejezés
         * még bőven benne van az értelmezési tartományban.
         */

        System.out.println(0333);
        System.out.println(Integer.parseInt("0333", 8));

        /**
         * 8-as számrendszerben van megadva,illetve úgy érzékeli a fordító.
         */

    }

}

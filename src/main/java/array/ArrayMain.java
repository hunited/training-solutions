package array;

public class ArrayMain {
    public static void main(String[] args) {

        String[] a = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

        System.out.println(a[1] + " " + a.length);

        int[] b = new int[5];

        for (int i = 0; i < b.length; i++) {
            b[i] = (int) Math.pow(2, (i+1));
            System.out.println(b[i]);
        }

        boolean[] c = {false, true, false, true, false, true};

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

    }
}

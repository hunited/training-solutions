package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1 = new Person("Gábor", 41);
        Person person2 = new Person("Józsi", 34);

        Person person3 = person1;

        person2 = person1;

        person2.setName("Feri");

        System.out.println("Első: " + person1.getName() + ", második: " + person2.getName());

        int elso = 24;

        int masodik = elso;

        masodik += 1;

        System.out.println("Első: " + elso + ", második: " + masodik);

        Person person4 = person3;

        System.out.println("Harmadik: " + person3.getName() + ", negyedik: " + person4.getName());

        /**

        Az objektum típusú változóknál csak hivatkozás történik a referenciára.
        Mindegyik person ugyan arra mutat. Amikor a másodikat átneveztük, ezért
        mivel mindegyiknél ugyan oda mutat a heap-ben, mind átneveződött.

        Primitív típusnál ha az egyik változónak egy másik értékét adod, azzal lemásolod
        az akkori pillanatnyi értéket, de ha később módosítod akkor az eredeti
        változó értéke nem módosul.

         */

    }

}

package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        PersonMain personMain = new PersonMain();

        Person person = new Person("Gipsz Jakab", "GiJa");
        Address address = new Address("Hungary", "Budapest", "Álmos utca 3", "1111");
        person.moveTo(address);

        System.out.println(person.personToString());
        System.out.println(person.getAddress().addressToString());

        person.correctData("Új Nevem Van", "A001");
        System.out.println(person.personToString());

        person.getAddress().correctData("Hungary", "Budapest", "Fáradt utca 1", "1171");
        System.out.println(person.getAddress().addressToString());

        Address newAddress = new Address("Mars", "12. hold", "Kék duna kráter 1", "MA12HKDK1");
        person.moveTo(newAddress);
        System.out.println(person.getAddress().addressToString());

    }

}

package objects;

public class ObjectsHowManyInstance {

    public static void main(String[] args) {

        Book book1 = new Book(); // 1. book
        Book book2 = new Book(); // 2. book
        Book book3 = new Book(); // 3. book
        Book book4 = book1; // ez azonos mint a book1
        Book book5 = book2; // ez azonos mint a book2
        Book book6 = book3; // ez azonos mint a book3
        Book book7 = null; // ez a 4. book de az értéke null marad végig,
        book4 = book5; // ez a book5 értékével / book2 értékével azonos
        book5 = new Book(); // ez az 5. book
        book6 = null; // ez csak törli a book3 objektumára mutatást

        // 4 darab objektumunk marad a végére, és 4 objektum is jön létre, a többi csak hivatkozik már meglévőre.

        System.out.println("Book1: " + book1 + "\nBook2: " + book2 + "\nBook3: " + book3 + "\nBook4: " + book4 + "\nBook5: " + book5 + "\nBook6: " + book6 + "\nBook7: " + book7);

    }

}

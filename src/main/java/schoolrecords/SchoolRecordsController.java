package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    public ClassRecords cr;

    public SchoolRecordsController(ClassRecords cr) {
        this.cr = cr;
    }

    public Scanner scanner = new Scanner(System.in);

    private List<Tutor> tutors = new ArrayList<>();

    private List<Subject> subjects = new ArrayList<>();

    public List<Tutor> getTutors() {
        return tutors;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public SchoolRecordsController(List<Tutor> tutors, List<Subject> subjects) {
        this.tutors = tutors;
        this.subjects = subjects;
    }

    public void initSchool() {

        tutors.add(new Tutor("Nagy Csilla", Arrays.asList(new Subject("matematika"), new Subject("fizika"))));
        tutors.add(new Tutor("Gipsz Jakab", Arrays.asList(new Subject("andul"), new Subject("német"))));
        tutors.add(new Tutor("Teszt Elek", Arrays.asList(new Subject("nyelvtan"), new Subject("irodalom"))));
        tutors.add(new Tutor("Min Tamás", Arrays.asList(new Subject("kémia"), new Subject("testnevelés"))));

        subjects.add(new Subject("matematika"));
        subjects.add(new Subject("fizika"));
        subjects.add(new Subject("andul"));
        subjects.add(new Subject("német"));
        subjects.add(new Subject("nyelvtan"));
        subjects.add(new Subject("irodalom"));
        subjects.add(new Subject("kémia"));
        subjects.add(new Subject("testnevelés"));
    }

    public void startMenu() {
        System.out.println(
                cr.getClassName() + " osztálynapló. Kérem válasszon funkciót:\n" +
                        "1. Diákok nevének listázása\n" +
                        "2. Diák név alapján keresése\n" +
                        "3. Diák létrehozása\n" +
                        "4. Diák név alapján törlése\n" +
                        "5. Diák feleltetése\n" +
                        "6. Osztályátlag kiszámolása\n" +
                        "7. Tantárgyi átlag kiszámolása\n" +
                        "8. Diákok átlagának megjelenítése\n" +
                        "9. Diák átlagának kiírása\n" +
                        "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                        "11. Kilépés"
        );
    }

    public void runMenu() {
        startMenu();
        int selection;
        try {
            selection = Integer.parseInt(scanner.nextLine());
            if (selection == 1) {
                menu1();
            } else if (selection == 2) {
                menu2();
            } else if (selection == 3) {
                menu3();
            } else if (selection == 4) {
                menu4();
            } else if (selection == 5) {
                menu5();
            } else if (selection == 6) {
                menu6();
            } else if (selection == 7) {
                menu7();
            } else if (selection == 8) {
                menu8();
            } else if (selection == 9) {
                menu9();
            } else if (selection == 10) {
                menu10();
            } else if (selection == 11) {
                menu11();
                return;
            } else {
                nonValid();
            }
        } catch (IllegalArgumentException iae) {
            iaError(iae.getMessage());
        }
        runMenu();
    }

    public void findStudent(String whatToDo) {
        try {
            System.out.println("Kérem adja meg a " + whatToDo + "diák nevét:");
            System.out.println(cr.findStudentByName(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            System.out.println("Nincs ilyen nevű gyermek. Újra próbálja? 1: igen, más szám: vissza a menübe.");
            int tryAgain = Integer.parseInt(scanner.nextLine());
            if (tryAgain == 1) {
                findStudent("");
            } else {
                return;
            }
        }
    }

    public MarkType findMarkType(int sMark){
        MarkType sMarkType = null;
        if (MarkType.A.getValue() == sMark) {
            sMarkType = MarkType.A;
        } else if (MarkType.B.getValue() == sMark) {
            sMarkType = MarkType.B;
        } else if (MarkType.C.getValue() == sMark) {
            sMarkType = MarkType.C;
        } else if (MarkType.D.getValue() == sMark) {
            sMarkType = MarkType.D;
        } else if (MarkType.F.getValue() == sMark) {
            sMarkType = MarkType.F;
        } else {
            throw new IllegalArgumentException("Nincs ilyen osztályzat");
        }
        return sMarkType;
    }

    public void menu1() {
        try {
            System.out.println(cr.listStudentNames());
        } catch (StringIndexOutOfBoundsException sioobe) {
            System.out.println("Még nincs diák az osztályban. Használja a 3-as menüpontot.");
        }
    }

    public void menu2() {
        try {
            if (cr.listStudentNames() != null) {
                findStudent("keresett ");
            }
        } catch (StringIndexOutOfBoundsException sioobe) {
            System.out.println("Még nincs diák az osztályban. Használja a 3-as menüpontot.");
        }
    }

    public void menu3() {
        System.out.println("Adja meg az új diák nevét!");
        try {
            cr.addStudent(new Student(scanner.nextLine()));
        } catch (IllegalArgumentException iae) {
            System.out.println("Hiba történt. Próbálja újra. " + iae.getMessage());
        }
    }

    public void menu4() {
        try {
            findStudent("törlendő ");
            Student toDel = cr.findStudentByName(scanner.nextLine());
            cr.removeStudent(toDel);
            System.out.println("Sikeresen kitöröltük " + toDel.toString() + " nevét a listából.");
        } catch (IllegalArgumentException iae) {
            System.out.println("Nincs ilyen nevű gyermek. Újra próbálja? 1: igen, más szám: vissza a menübe.");
        }
    }

    public void menu5() {
        try {
            Student whoRepetition = cr.repetition();
            System.out.println("Felel a következő diák: " + whoRepetition.getName());
            System.out.println("Kapott osztályzat: ");
            MarkType sMarkType = findMarkType(Integer.parseInt(scanner.nextLine()));
            System.out.println("Tantárgy neve: ");
            Subject sSubject = new Subject(scanner.nextLine());
            System.out.println("Tanár neve: ");
            String sTeacher = scanner.nextLine();
            whoRepetition.grading(new Mark(sMarkType, sSubject, new Tutor(sTeacher, Arrays.asList(sSubject))));
            System.out.println(whoRepetition.toString());
        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu6() {
        try {
            System.out.println(subjects);
            System.out.println(tutors);
        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu7() {
        try {

        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu8() {
        try {

        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu9() {
        try {

        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu10() {
        try {

        } catch (Exception e) { //Milyen kivétel?

        }
    }

    public void menu11() {
        System.out.println("Viszont látásra!");
    }

    public void nonValid() {
        System.out.println("Hibás menüválasztás. Próbálja újra.");
    }

    public void iaError(String msg) {
        System.out.println("Hiba történt. Próbálja újra. " + msg);
    }

    public static void main(String[] args) {

        SchoolRecordsController src = new SchoolRecordsController(new ClassRecords("Fourth Grade A", new Random(5)));
        src.runMenu();

    }

}

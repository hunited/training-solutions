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

    public void initSchool() {

        Subject math = new Subject("matematika");
        subjects.add(math);
        Subject physics = new Subject("fizika");
        subjects.add(physics);
        Subject english = new Subject("angol");
        subjects.add(english);
        Subject german = new Subject("német");
        subjects.add(german);
        Subject grammar = new Subject("nyelvtan");
        subjects.add(grammar);
        Subject literature = new Subject("irodalom");
        subjects.add(literature);
        Subject chemistry = new Subject("kémia");
        subjects.add(chemistry);
        Subject gym = new Subject("testnevelés");
        subjects.add(gym);

        Tutor csilla = new Tutor("Nagy Csilla", Arrays.asList(math, physics));
        tutors.add(csilla);
        Tutor jakab = new Tutor("Gipsz Jakab", Arrays.asList(english, german));
        tutors.add(jakab);
        Tutor elek = new Tutor("Teszt Elek", Arrays.asList(grammar, literature));
        tutors.add(elek);
        Tutor tamas = new Tutor("Min Tamás", Arrays.asList(chemistry, gym));
        tutors.add(tamas);

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

    public MarkType findMarkType(int sMark) {
        for (MarkType markType : MarkType.values()) {
            if (markType.getValue() == sMark) {
                return markType;
            }
        }
        return null;
    }

    public Subject sSubjectWorker() {
        System.out.println("Tantárgy neve: ");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println("" + (i + 1) + " " + subjects.get(i).getSubjectName());
        }
        int selection = Integer.parseInt(scanner.nextLine());
        Subject sSubject = null;
        for (int i = 0; i < subjects.size(); i++) {
            if (selection == i + 1) {
                sSubject = subjects.get(i);
            }
        }
        return sSubject;
    }

    public String sTeacherWorker(Subject subject) {
        System.out.println("Tanár neve: ");
        List<String> temp = new ArrayList<>();
        int temp2 = 0;
        for (int i = 0; i < tutors.size(); i++) {
            if (tutors.get(i).tutorTeachingSubject(subject)) {
                temp.add(tutors.get(i).getName());
                temp2++;
                System.out.println("" + (temp2) + " " + tutors.get(i).getName());
            }
        }
        int selection = Integer.parseInt(scanner.nextLine());
        String sTeacher = null;
        for (int i = 0; i < temp.size(); i++) {
            if (selection == i + 1) {
                sTeacher = temp.get(i);
            }
        }
        return sTeacher;
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
            System.out.println("FIGYELEM! Kérjük a diák nevének ismételt beírásával erősítse meg törlési szándékát!");
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
            if (sMarkType == null) {
                System.out.println("Hibás osztályzat, kérem javítsa!");
                sMarkType = findMarkType(Integer.parseInt(scanner.nextLine()));
            }
            Subject sSubject = null;
            sSubject = sSubjectWorker();
            String sTeacher = null;
            sTeacher = sTeacherWorker(sSubject);
            whoRepetition.grading(new Mark(sMarkType, sSubject, new Tutor(sTeacher, Arrays.asList(sSubject))));
            System.out.println("Felelet rögzítve: " + whoRepetition.getName() + " nevű diák "
                    + sSubject.getSubjectName() + " tantárgyból "
                    + sTeacher + " tanártól az alábbi osztályzatot kapta: "
                    + sMarkType.getValue() + " Értékelése: " + sMarkType.getDescription()
            );
        } catch (IllegalStateException ise) {
            System.out.println("Hiba történt, kezdje újra az utolsó műveletet. " + ise.getMessage());
            runMenu();
        }
    }

    public void menu6() {
        try {
            System.out.println("Az osztály tantárgyfüggetlen átlaga: " + cr.calculateClassAverage());
        } catch (ArithmeticException ae) {
            throw new IllegalStateException("Hiba történt: " + ae.getMessage());
        }
    }

    public void menu7() {
        try {
            System.out.println("Melyik tantárgy átlagára kíváncsi?");
            Subject sSubject = null;
            sSubject = sSubjectWorker();
            System.out.println(cr.calculateClassAverageBySubject(sSubject));
        } catch (ArithmeticException ae) {
            throw new IllegalStateException("Hiba történt: " + ae.getMessage());
        }
    }

    public void menu8() {
        try {
            for (StudyResultByName sr : cr.listStudyResults()) {
                System.out.println("A(z) " + sr.getStudentName() + " nevű tanuló átlaga: " + sr.getStudyAverage() + ".");
            }
        } catch (IllegalStateException ise) {
            System.out.println("Hiba történt: " + ise.getMessage());
        }
    }

    public void menu9() {
        try {
            System.out.println("Melyik diák átlagára kíváncsi?");
            String find = scanner.nextLine();
            System.out.println(cr.findStudentByName(find).getName() + " átlaga: " + cr.findStudentByName(find).calculateAverage() + ".");
        } catch (IllegalStateException ise) {
            System.out.println("Hiba történt: " + ise.getMessage());
        }
    }

    public void menu10() {
        try {
            System.out.println("Melyik diák átlagára kíváncsi?");
            String find = scanner.nextLine();
            Subject sSubject = null;
            sSubject = sSubjectWorker();
            System.out.println(cr.findStudentByName(find).getName()
                    + " " + sSubject.getSubjectName() + " átlaga: "
                    + cr.findStudentByName(find).calculateSubjectAverage(sSubject) + ".");
        } catch (NullPointerException npe) {
            System.out.println("Hiba történt: " + npe.getMessage());
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

/* Ez a rész csak játékból került be, nincs a menübe implementálva már.
   Kilistázza melyik tanár melyik tárgyat tanítjhatja és vica versa.
    public void teachersAndSubjects() {
        for (int i = 0; i < tutors.size(); i++) {
            for (int j = 0; j < subjects.size(); j++) {
                if (tutors.get(i).tutorTeachingSubject(subjects.get(j))) {
                    System.out.println(tutors.get(i).getName() + " taníthat " + subjects.get(j).getSubjectName() + " tantárgyat.");
                }
            }
        }
    }

    public void subjectsAndTeachers() {
        for (int j = 0; j < subjects.size(); j++) {
            for (int i = 0; i < tutors.size(); i++) {
                if (tutors.get(i).tutorTeachingSubject(subjects.get(j))) {
                    System.out.println("A(z) " + subjects.get(j).getSubjectName() + " tantárgyat " + tutors.get(i).getName() + " taníthatja.");
                }
            }
        }
    }
*/

    public static void main(String[] args) {

        SchoolRecordsController src = new SchoolRecordsController(new ClassRecords("Fourth Grade A", new Random(5)));
        src.initSchool();
        src.runMenu();

    }

}

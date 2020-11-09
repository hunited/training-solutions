package introconstructors;

public class TaskMain {

    public static void main(String[] args) {

        Task task = new Task("Leckét megcsinálni", "Elkészíteni a leckét, majd feltölteni a GitHub repoba");

        task.start();

        task.setDuration(60);

        System.out.println("A feladat címe: " + task.getTitle()
                + "\nA feladat leírása: " + task.getDescription()
                + "\nA feladat kezdő időpontja: " + task.getStartDateTime()
                + "\nA feladat időtartama: " + task.getDuration() + " perc."
        );

    }

}

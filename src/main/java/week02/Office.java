package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames() {
        for (int i = 1; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        int i = 1;
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println("A(z) " + i + ". tárgyaló neve: "
                    + meetingRoom.getName() + ", szélessége: "
                    + meetingRoom.getWidth() + " m, hosszúsága: "
                    + meetingRoom.getLength() + " m, területe: "
                    + meetingRoom.getArea() + " m\u00B2."
            );
            i++;
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().equals(name.toLowerCase())) {
                System.out.println("Tárgyaló neve: "
                        + meetingRoom.getName() + ", szélessége: "
                        + meetingRoom.getWidth() + " m, hosszúsága: "
                        + meetingRoom.getLength() + " m, területe: "
                        + meetingRoom.getArea() + " m\u00B2."
                );
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        boolean found = false;
        int i = 0;
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println("Tárgyaló neve: "
                        + meetingRoom.getName() + ", szélessége: "
                        + meetingRoom.getWidth() + " m, hosszúsága: "
                        + meetingRoom.getLength() + " m, területe: "
                        + meetingRoom.getArea() + " m\u00B2."
                );
                found = true;
                i++;
            }
        }
        System.out.println(found ? i + " találat." : "Nincs találat.");
    }

    public void printAreasLargerThan(int area) {
        boolean found = false;
        int i = 0;
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println("A tárgyaló neve: "
                        + meetingRoom.getName() + ", szélessége: "
                        + meetingRoom.getWidth() + " m, hosszúsága: "
                        + meetingRoom.getLength() + " m, területe: "
                        + meetingRoom.getArea() + " m\u00B2."
                );
                found = true;
                i++;
            }
        }
        System.out.println(found ? i + " találat." : "Nincs találat.");
    }

}

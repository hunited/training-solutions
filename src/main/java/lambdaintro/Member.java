package lambdaintro;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private final String name;
    private final List<String> skills;
    private final Sex gender;
    private final List<String> messages = new ArrayList<>();

    public Member(String name, List<String> skills, Sex gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Sex getGender() {
        return gender;
    }

    public List<String> getMessages() {
        return messages;
    }

}

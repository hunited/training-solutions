package lambdaoptional;

import java.util.List;

public class Member {

    private final String name;
    private final List<String> skills;
    private final Sex gender;

    public Member(String name, List<String> skills, Sex gender) {
        this.name = name;
        this.skills = skills;
        this.gender = gender;
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

}

package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private final String name;

    private final List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... cvSkills) {
        for (String row : cvSkills) {
            int value = Integer.parseInt(row.substring(row.length() - 2, row.length() - 1));
            String skillName = row.substring(0, row.length() - 4);
            skills.add(new Skill(skillName, value));
        }
    }

    public int findSkillLevelByName(String skillName) {
        int skillLevel = 0;
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)) {
                skillLevel = skill.getLevel();
            }
        }
        if (skillLevel == 0) {
            throw new SkillNotFoundException("Skill not found");
        }
        return skillLevel;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

}

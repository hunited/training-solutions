package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    public void connect(String name, String otherName) {
        Member first = findByName(name);
        try {
            first.connectMember(findByName(otherName));
        } catch (NullPointerException nullPointerException) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Cannot find first!", nullPointerException);
        }
    }

    private Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> bidirectionalConnections = new ArrayList<>();
        for (Member member : members) {
            for (Member connectedMember : member.getConnections()) {
                if (connectedMember.getConnections().contains(member)) {
                    bidirectionalConnections.add(member.getName() + " - " + connectedMember.getName());
                }
            }
        }
        return bidirectionalConnections;
    }

    @Override
    public String toString() {
        return members.toString();
    }

}

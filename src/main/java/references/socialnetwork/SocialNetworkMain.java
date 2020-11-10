package references.socialnetwork;

public class SocialNetworkMain {

    public static void main(String[] args) {

        SocialNetwork socialNetwork = new SocialNetwork();

        socialNetwork.addMember("Anita");
        socialNetwork.addMember("Ágota");
        socialNetwork.addMember("Beáta");
        socialNetwork.addMember("Cecília");
        socialNetwork.addMember("Csilla");
        socialNetwork.addMember("Diána");

        System.out.println(socialNetwork);
        socialNetwork.connect("Anita", "Ágota");
        System.out.println(socialNetwork);
        socialNetwork.connect("Ágota", "Anita");
        System.out.println(socialNetwork);

        System.out.println(socialNetwork.bidirectionalConnections());

    }

}

package introjunit;

public class Gentleman {

    public String sayHello(String name) {
        if (name == null || "".equals(name)) {
            return "Hello Anonymous";
        } else {
            return "Hello " + name;
        }
    }


}

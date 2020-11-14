package stringbasic.stringbasic;

public class StringCreator {

    public String createStringForHeap() {
        return new String("Ez egy String");
    }

    public String createStringForPool() {
        return "Ez egy String";
    }

}

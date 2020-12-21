package controlselection.accents;

public class WithoutAccents {

    public  char convertToCharWithoutAccents(char c) {
        int temp = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ".indexOf(c);
        if (temp >= 0) {
            return "aeiooouuuAEIOOOUUU".charAt(temp);
        } else {
            return c;
        }
    }

}

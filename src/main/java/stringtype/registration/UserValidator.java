package stringtype.registration;

public class UserValidator {
    public boolean isValidUsername(String username){
        return username.length()>0;// != null && !"".equals(username);
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.length()>7 && password2.equals(password1);
    }

    public boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int dot = email.indexOf('.');

        return at > 0 && dot > at+1 && dot<(email.length()-1);
    }
}

package exception.problem_04.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String firstName;
    private String email;


    public Person(String firstName, String email) {
        setFirstName(firstName);
        setEmail(email);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(firstName);
        if(matcher.find()) {
            throw new IllegalArgumentException("This is not valid name");
        }
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

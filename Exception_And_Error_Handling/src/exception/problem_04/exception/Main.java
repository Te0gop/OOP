package exception.problem_04.exception;


public class Main {
    public static void main(String[] args) {
        try {
            Person student = new Person("George", "email@gmail.com");
            System.out.println(student.getFirstName() + " " + student.getEmail());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

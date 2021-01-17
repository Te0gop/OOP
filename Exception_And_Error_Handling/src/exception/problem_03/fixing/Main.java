package exception.problem_03.fixing;

public class Main {
    public static void main(String[] args) {
        try {
            Person employee = new Person("George", "", 20);
            Person person = new Person("", "Scott", 100);
            Person worker = new Person("George", "Scott", 121);
            Person student = new Person("George", "Scott", 24);

            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getAge());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}

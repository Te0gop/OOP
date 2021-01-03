package task_02_salary;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    private double bonus;


    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {

        if (getAge() < 30) {
            setSalary(getSalary() + (getSalary() * ((bonus / 2) / 100)));
        } else {
            setSalary(getSalary() + (getSalary() * (bonus / 100)));
        }
    }


    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " gets " + getSalary() + " leva";
    }
}

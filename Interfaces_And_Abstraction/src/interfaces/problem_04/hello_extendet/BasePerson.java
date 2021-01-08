package interfaces.problem_04.hello_extendet;

public abstract class BasePerson implements Person{
    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}

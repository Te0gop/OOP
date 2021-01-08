package interfaces.problem_04.hello_extendet;

public class Bulgarian extends BasePerson {
    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Zdr";
    }
}

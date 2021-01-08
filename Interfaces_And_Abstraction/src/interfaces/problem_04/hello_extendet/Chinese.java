package interfaces.problem_04.hello_extendet;

public class Chinese extends BasePerson {
    private String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Sin chao";
    }
}

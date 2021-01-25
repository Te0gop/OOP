package factory_pattern;

import java.util.List;

public class Repository {
    private List<Integer> numbers;

    void saveEntity(Integer number) {
        numbers.add(number);
    }
}

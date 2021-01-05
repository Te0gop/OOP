package reusing_classes.problem_04.random_ArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        Random random = new Random();
        int index = random.nextInt(this.size());
        return this.get(index);
    }

}

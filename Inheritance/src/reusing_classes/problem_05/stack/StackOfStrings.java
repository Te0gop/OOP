package reusing_classes.problem_05.stack;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;
    private int lastElementIndex;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        lastElementIndex = -1;
    }

    public void push(String item) {
        lastElementIndex++;
        data.add(item);

    }
    public String pop() {
        if (lastElementIndex < 0) {
            throw new NoSuchElementException("No suck element.");
        }
        return data.remove(lastElementIndex--);

    }
    public String peek() {
        if (lastElementIndex < 0) {
            throw new NoSuchElementException("No suck element.");
        }
        return data.get(lastElementIndex);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}

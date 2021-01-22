package facade_pattern;

public class Main {
    public static void main(String[] args) {
        ImageManipulatorFacade imageManipulatorFacade = new ImageManipulatorFacade();
        Image image = new Image(imageManipulatorFacade);
        image.display();
    }
}

package facade_pattern;

public class Image {
    private ImageManipulatorFacade imageManipulatorFacade;

    public Image(ImageManipulatorFacade imageManipulatorFacade) {
        this.imageManipulatorFacade = imageManipulatorFacade;
    }

    public void display() {
     this.imageManipulatorFacade.resizeImage(this);
    }
}

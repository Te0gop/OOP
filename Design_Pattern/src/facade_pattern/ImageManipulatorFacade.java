package facade_pattern;

public class ImageManipulatorFacade {

    public void resizeImage(Image image) {
        // we have to change the code only in the facade if method is deprecated
        new ImageLibrary().fitToSizeFrom(11, 12);
    }
}

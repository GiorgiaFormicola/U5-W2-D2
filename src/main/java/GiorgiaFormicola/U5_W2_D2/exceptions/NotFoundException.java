package GiorgiaFormicola.U5_W2_D2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String resource, long resourceId) {
        super("The " + resource + " with id " + resourceId + " has not been found");
    }
}

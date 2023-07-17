package summerProject.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super("not found " + message);
    }
}

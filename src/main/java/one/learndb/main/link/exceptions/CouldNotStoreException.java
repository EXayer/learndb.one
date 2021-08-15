package one.learndb.main.link.exceptions;

public class CouldNotStoreException extends RuntimeException {

    private CouldNotStoreException(String message) {
        super(message);
    }

    public static CouldNotStoreException linkAlreadyExists() {
        return new CouldNotStoreException("Link already exists");
    }
}

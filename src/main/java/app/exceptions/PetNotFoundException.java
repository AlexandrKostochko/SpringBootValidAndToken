package app.exceptions;

public class PetNotFoundException extends  RuntimeException {

    public PetNotFoundException(long id) {
        super ("Pet with id " + id + " not found");
    }
}

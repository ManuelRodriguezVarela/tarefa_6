package gal.san.clemente.tarefa6_acceso_datos.exception;

public class ProjectException extends Exception {
    
    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProjectException(Throwable cause) {
        super(cause);
    }
}

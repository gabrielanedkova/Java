package bg.uni.sofia.fmi.mjt.cache;

public class CapacityExceededException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CapacityExceededException(String message) {
        super(message);
    }
}

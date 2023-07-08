package jpabook.jpashop.exception;

public class NottEnoughStockException extends RuntimeException {
    public NottEnoughStockException() {
        super();
    }

    public NottEnoughStockException(String message) {
        super(message);
    }

    public NottEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NottEnoughStockException(Throwable cause) {
        super(cause);
    }

}

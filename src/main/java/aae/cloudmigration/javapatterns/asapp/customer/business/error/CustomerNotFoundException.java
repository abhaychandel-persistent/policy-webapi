package aae.cloudmigration.javapatterns.asapp.customer.business.error;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

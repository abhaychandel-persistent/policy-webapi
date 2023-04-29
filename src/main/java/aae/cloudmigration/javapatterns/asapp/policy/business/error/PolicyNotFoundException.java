package aae.cloudmigration.javapatterns.asapp.policy.business.error;

public class PolicyNotFoundException extends RuntimeException {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}

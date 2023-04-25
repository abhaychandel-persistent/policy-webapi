package aae.cloudmigration.javapatterns.asapp.customer.dto;

public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;

    public CustomerDto() {
	}

	public CustomerDto(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

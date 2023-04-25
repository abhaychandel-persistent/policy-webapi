package aae.cloudmigration.javapatterns.asapp.customer.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CustomerEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_generator")
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_seq", allocationSize = 1)
    private Integer id;

    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

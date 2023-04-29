package aae.cloudmigration.javapatterns.asapp.policy.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "policy")
public class PolicyEntity {

    public PolicyEntity(String policyNo, String policyName, String description, Boolean isActive, String type) {
        this.policyNo = policyNo;
        this.policyName = policyName;
        this.description = description;
        this.isActive = isActive;
        this.type = type;
    }

    public PolicyEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policy_id_generator")
    @SequenceGenerator(name = "policy_id_generator", sequenceName = "policy_id_seq", allocationSize = 1)
    private Integer id;

    private String policyNo;
    private String policyName;
    private String description;
    private Boolean isActive;
    private String type;
    public Integer getId() {
        return id;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getType() {
        return type;
    }
}

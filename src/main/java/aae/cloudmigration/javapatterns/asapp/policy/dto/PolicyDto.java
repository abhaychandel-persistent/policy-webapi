package aae.cloudmigration.javapatterns.asapp.policy.dto;

public class PolicyDto {

    private String id;
    private String policyNo;
    private String policyName;
    private String description;
    private Boolean isActive;
    private String type;

    public PolicyDto() {
	}

    public PolicyDto(String id, String policyNo, String policyName, String description, Boolean isActive, String type) {
        this.id = id;
        this.policyNo = policyNo;
        this.policyName = policyName;
        this.description = description;
        this.isActive = isActive;
        this.type = type;
    }

    public String getId() {
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

package aae.cloudmigration.javapatterns.asapp.policy.business.api;

import java.util.List;

import aae.cloudmigration.javapatterns.asapp.policy.dto.PolicyDto;

public interface PolicyService {

	PolicyDto createPolicy(PolicyDto policyDto);

    PolicyDto getPolicy(String policyId);

	List<PolicyDto> getPolicyList();
}

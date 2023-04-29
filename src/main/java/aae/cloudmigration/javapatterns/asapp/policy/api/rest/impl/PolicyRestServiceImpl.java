package aae.cloudmigration.javapatterns.asapp.policy.api.rest.impl;

import java.util.List;

import aae.cloudmigration.javapatterns.asapp.policy.api.rest.PolicyRestService;
import aae.cloudmigration.javapatterns.asapp.policy.dto.PolicyDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import aae.cloudmigration.javapatterns.asapp.policy.business.api.PolicyService;

@RestController
public class PolicyRestServiceImpl implements PolicyRestService {

	private static final Logger LOGGER = LogManager.getLogger(PolicyRestServiceImpl.class);
    private final PolicyService policyService;

    @Autowired
    public PolicyRestServiceImpl(PolicyService policyService) {
        this.policyService = policyService;
    }

	public ResponseEntity<PolicyDto> createPolicy(PolicyDto policyDto) {
		LOGGER.info("Request received for creating policy " + policyDto.toString());
		return ResponseEntity.ok(policyService.createPolicy(policyDto));
	}

	public ResponseEntity<PolicyDto> getPolicy(String policyId) {
		LOGGER.info("Request received for getting policy with Id " + policyId);
		return ResponseEntity.ok(policyService.getPolicy(policyId));
	}

	@Override
	public ResponseEntity<List<PolicyDto>> getPolicyList() {
		LOGGER.info("Request received for getting policy list");
		return ResponseEntity.ok(policyService.getPolicyList());
	}

    

   
}

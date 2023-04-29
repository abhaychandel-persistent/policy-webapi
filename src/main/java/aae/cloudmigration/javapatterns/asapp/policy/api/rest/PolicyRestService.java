package aae.cloudmigration.javapatterns.asapp.policy.api.rest;

import java.util.List;

import aae.cloudmigration.javapatterns.asapp.policy.dto.PolicyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/policies")
public interface PolicyRestService {

	@PostMapping
    ResponseEntity<PolicyDto> createPolicy(@RequestBody PolicyDto policyDto);
	
	@GetMapping()
	ResponseEntity<List<PolicyDto>> getPolicyList();

    @GetMapping("/{id}")
    ResponseEntity<PolicyDto> getPolicy(@PathVariable("id") String policyId);


}

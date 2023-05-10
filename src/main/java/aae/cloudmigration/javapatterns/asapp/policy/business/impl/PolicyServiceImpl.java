package aae.cloudmigration.javapatterns.asapp.policy.business.impl;

import aae.cloudmigration.javapatterns.asapp.policy.data.entity.PolicyEntity;
import aae.cloudmigration.javapatterns.asapp.policy.data.repository.api.PolicyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import aae.cloudmigration.javapatterns.asapp.policy.business.api.PolicyService;
import aae.cloudmigration.javapatterns.asapp.policy.business.error.PolicyNotFoundException;
import aae.cloudmigration.javapatterns.asapp.policy.dto.PolicyDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImpl implements PolicyService {

    private static final Logger LOGGER = LogManager.getLogger(PolicyServiceImpl.class);
    private final PolicyRepository policyRepository;

    @Value("${codeName}")
    private String projectCodeName;

    @Autowired
    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    /**
     * <p>
     * Creates an entity object and passes to
     * {@link aae.cloudmigration.javapatterns.asapp.policy.data.repository.api.PolicyRepository}
     * </p>
     * <p>
     * Maps policy entity to Data transfer object.
     * </p>
     *
     * @param policyDto - Data Transfer Object containing details of policy to
     *                  be created.
     * @return policyDto - Data Transfer Object containing policy details along
     * with Id of newly created policy.
     */
    public PolicyDto createPolicy(PolicyDto policyDto) {
        PolicyEntity policyEntity = policyRepository
                .save(new PolicyEntity(getPolicyNo(), policyDto.getPolicyName(), policyDto.getDescription(),
                        true, policyDto.getType()));
        LOGGER.info("Policy \"" + policyEntity.getPolicyNo() + " " + policyEntity.getPolicyName()
                + "\" created successfully with Id " + policyEntity.getId());
        return mapPolicyEntityToDto(policyEntity);
    }

    private String getPolicyNo() {
        int min = 11004;
        int max = 11999;
        int range = max - min + 1;
        return "CH" + (int) ((Math.random() * range) + min);
    }

    /**
     * <p>
     * Finds a policy by id.
     * </p>
     *
     * @param policyId - Policy id.
     * @return policyDto - Data Transfer Object containing policy details.
     * @throws PolicyNotFoundException
     */
    public PolicyDto getPolicy(String policyId) {
        Optional<PolicyEntity> policyEntityOptional = policyRepository.findById(Integer.valueOf(policyId));
        if (policyEntityOptional.isPresent()) {
            LOGGER.info("Policy with Id " + policyId + " found.");
            return mapPolicyEntityToDto(policyEntityOptional.get());
        }
        LOGGER.error("Policy with Id " + policyId + " not found.");
        throw new PolicyNotFoundException("Policy with Id " + policyId + " not found.");
    }

    @Override
    public List<PolicyDto> getPolicyList() {
        LOGGER.info("Project codeName: " + projectCodeName);
        List<PolicyEntity> policyEntityList = policyRepository.findAll();
        return policyEntityList.stream()
                .map(entity -> mapPolicyEntityToDto(entity))
                .collect(Collectors.toList());
    }

    /*
     * Maps an Entity object to a Data Transfer Object
     */
    private PolicyDto mapPolicyEntityToDto(PolicyEntity policyEntity) {
        return new PolicyDto(String.valueOf(policyEntity.getId()), policyEntity.getPolicyNo(),
                policyEntity.getPolicyName(), policyEntity.getDescription(), policyEntity.getActive(), policyEntity.getType());
    }

}

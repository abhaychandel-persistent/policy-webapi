package aae.cloudmigration.javapatterns.asapp.policy.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

import aae.cloudmigration.javapatterns.asapp.policy.data.entity.PolicyEntity;

public interface PolicyRepository extends JpaRepository<PolicyEntity, Integer> {
}

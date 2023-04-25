package aae.cloudmigration.javapatterns.asapp.customer.data.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;

import aae.cloudmigration.javapatterns.asapp.customer.data.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}

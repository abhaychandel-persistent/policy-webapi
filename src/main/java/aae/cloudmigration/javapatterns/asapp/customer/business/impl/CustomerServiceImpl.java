package aae.cloudmigration.javapatterns.asapp.customer.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import aae.cloudmigration.javapatterns.asapp.customer.business.api.CustomerService;
import aae.cloudmigration.javapatterns.asapp.customer.business.error.CustomerNotFoundException;
import aae.cloudmigration.javapatterns.asapp.customer.data.entity.CustomerEntity;
import aae.cloudmigration.javapatterns.asapp.customer.data.repository.api.CustomerRepository;
import aae.cloudmigration.javapatterns.asapp.customer.dto.CustomerDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);
	private final CustomerRepository customerRepository;

	@Value("${codeName}")
	private String projectCodeName;

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * <p>
	 * Creates an entity object and passes to
	 * {@link aae.cloudmigration.javapatterns.aksapp.customer.data.repository.api.CustomerRepository}
	 * </p>
	 * <p>
	 * Maps customer entity to Data transfer object.
	 * </p>
	 * 
	 * @param customerDto - Data Transfer Object containing details of customer to
	 *                    be created.
	 * @return customerDto - Data Transfer Object containing customer details along
	 *         with Id of newly created customer.
	 */
	public CustomerDto createCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = customerRepository
				.save(new CustomerEntity(customerDto.getFirstName(), customerDto.getLastName()));
		LOGGER.info("Customer \"" + customerEntity.getFirstName() + " " + customerEntity.getLastName()
				+ "\" created successfully with Id " + customerEntity.getId());
		return mapCustomerEntityToDto(customerEntity);
	}

	/**
	 * <p>
	 * Finds a customer by customer id.
	 * </p>
	 * 
	 * @param customerId - Customer id.
	 * @return customerDto - Data Transfer Object containing customer details.
	 * @throws aae.cloudmigration.javapatterns.aksapp.customer.business.error.CustomerNotFoundException
	 */
	public CustomerDto getCustomer(String customerId) {
		Optional<CustomerEntity> customerEntityOptional = customerRepository.findById(Integer.valueOf(customerId));
		if (customerEntityOptional.isPresent()) {
			LOGGER.info("Customer with Id " + customerId + " found.");
			return mapCustomerEntityToDto(customerEntityOptional.get());
		}
		LOGGER.error("Customer with Id " + customerId + " not found.");
		throw new CustomerNotFoundException("Customer with Id " + customerId + " not found.");
	}

	/*
	 * Maps an Entity object to a Data Transfer Object
	 */
	private CustomerDto mapCustomerEntityToDto(CustomerEntity customerEntity) {
		return new CustomerDto(String.valueOf(customerEntity.getId()), customerEntity.getFirstName(),
				customerEntity.getLastName());
	}

	@Override
	public List<CustomerDto> getCustomerList() {
		LOGGER.info("Project codeName: " + projectCodeName);
		List<CustomerEntity> customerEntityList = customerRepository.findAll();
		return customerEntityList.stream().map(
				entity -> new CustomerDto(String.valueOf(entity.getId()), entity.getFirstName(), entity.getLastName()))
				.collect(Collectors.toList());
	}

}

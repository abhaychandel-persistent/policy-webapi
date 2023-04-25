package aae.cloudmigration.javapatterns.asapp.customer.api.rest.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import aae.cloudmigration.javapatterns.asapp.customer.api.rest.CustomerRestService;
import aae.cloudmigration.javapatterns.asapp.customer.business.api.CustomerService;
import aae.cloudmigration.javapatterns.asapp.customer.dto.CustomerDto;

@RestController
public class CustomerRestController implements CustomerRestService {

	private static final Logger LOGGER = LogManager.getLogger(CustomerRestController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

	public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
		LOGGER.info("Request received for creating customer " + customerDto.toString());
		return ResponseEntity.ok(customerService.createCustomer(customerDto));
	}

	public ResponseEntity<CustomerDto> getCustomer(String customerId) {
		LOGGER.info("Request received for getting customer with Id " + customerId);
		return ResponseEntity.ok(customerService.getCustomer(customerId));
	}

	@Override
	public ResponseEntity<List<CustomerDto>> getCustomerList() {
		return ResponseEntity.ok(customerService.getCustomerList());
	}

    

   
}

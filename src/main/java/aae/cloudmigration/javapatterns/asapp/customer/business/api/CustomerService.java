package aae.cloudmigration.javapatterns.asapp.customer.business.api;

import java.util.List;

import aae.cloudmigration.javapatterns.asapp.customer.dto.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(String customerId);

	List<CustomerDto> getCustomerList();
}

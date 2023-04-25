package aae.cloudmigration.javapatterns.asapp.customer.api.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import aae.cloudmigration.javapatterns.asapp.customer.dto.CustomerDto;


@RequestMapping("/customers")
public interface CustomerRestService {

	@PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto);
	
	@GetMapping()
	ResponseEntity<List<CustomerDto>> getCustomerList();

    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") String customerId);


}

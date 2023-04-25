package aae.cloudmigration.javapatterns.asapp.customer.api.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import aae.cloudmigration.javapatterns.asapp.customer.api.rest.impl.CustomerRestController;
import aae.cloudmigration.javapatterns.asapp.customer.business.error.CustomerNotFoundException;

@ControllerAdvice(basePackageClasses = CustomerRestController.class)
public class CustomerRestServiceAdvice {

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	String handleCustomerNotFoundException(CustomerNotFoundException e) {
		return e.getMessage();
	}
}

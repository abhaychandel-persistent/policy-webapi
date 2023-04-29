package aae.cloudmigration.javapatterns.asapp.policy.api.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import aae.cloudmigration.javapatterns.asapp.policy.api.rest.impl.PolicyRestServiceImpl;
import aae.cloudmigration.javapatterns.asapp.policy.business.error.PolicyNotFoundException;

@ControllerAdvice(basePackageClasses = PolicyRestServiceImpl.class)
public class PolicyRestServiceAdvice {

	@ExceptionHandler(PolicyNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	String handlePolicyNotFoundException(PolicyNotFoundException e) {
		return e.getMessage();
	}
}

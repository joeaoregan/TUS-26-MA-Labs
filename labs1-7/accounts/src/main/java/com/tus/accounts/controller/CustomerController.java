package com.tus.accounts.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tus.accounts.dto.CustomerDetailsDto;
import com.tus.accounts.service.ICustomersService;

import jakarta.validation.constraints.Pattern;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CustomerController {
	private final ICustomersService iCustomerService;

	public CustomerController(ICustomersService iCustomerService) {
		this.iCustomerService = iCustomerService;
	}

	@GetMapping("/customers")
	public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {
		CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber);
		return ResponseEntity.ok(customerDetailsDto);
	}
}

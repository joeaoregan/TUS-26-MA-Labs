package com.tus.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final ICustomersService iCustomerService;

    public CustomerController(ICustomersService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(
            @RequestHeader("tusbank-correlation-id") String correlationId,
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {
        logger.debug("TusBank-correlation-id: gound:{}", correlationId);
        CustomerDetailsDto customerDetailsDto = iCustomerService.fetchCustomerDetails(mobileNumber, correlationId);
        return ResponseEntity.ok(customerDetailsDto);
    }
}

package com.tus.accounts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tus.accounts.constants.AccountsConstants;
import com.tus.accounts.dto.CustomerDto;
import com.tus.accounts.dto.ResponseDto;
import com.tus.accounts.service.IAccountsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
//import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@Validated
public class AccountController {

	private IAccountsService iAccountsService;
	
	// Single arg constructor for dependency injection
	public AccountController(IAccountsService iAccountsService) {
		this.iAccountsService = iAccountsService;
	}

	@Value("${build.version}")
	private String buildVersion;

	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello World";
	}

	@PostMapping()
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
		iAccountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
	}

	@GetMapping()
	public ResponseEntity<CustomerDto> fetchAccountDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}

	@PutMapping()
	public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
		boolean isUpdated = iAccountsService.updateAccount(customerDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
		}
	}

	@DeleteMapping()
	public ResponseEntity<ResponseDto> deleteAccountDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_500, AccountsConstants.MESSAGE_500));
		}
	}
}

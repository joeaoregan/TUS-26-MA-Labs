package com.tus.loans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tus.loans.constants.LoansConstants;
import com.tus.loans.dto.LoansContactInfoDto;
import com.tus.loans.dto.LoansDto;
import com.tus.loans.dto.ResponseDto;
import com.tus.loans.service.ILoansService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
//import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
@Validated
public class LoansController {

	private ILoansService iLoansService;

	private static final Logger logger = LoggerFactory.getLogger(LoansController.class);

	private LoansContactInfoDto loansContactInfoDto;

	public LoansController(ILoansService iLoansService, LoansContactInfoDto loansContactInfoDto) {
		this.iLoansService = iLoansService;
		this.loansContactInfoDto = loansContactInfoDto;
	}

	@Value("${build.version}")
	private String buildVersion;

	@Autowired
	private Environment environment;

	@GetMapping("/java-version")
	public ResponseEntity<String> getJavaVersion() {
		return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
	}

	@GetMapping("/build-info")
	public ResponseEntity<String> getBuildInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
	}

	@GetMapping("/contact-info")
	public ResponseEntity<LoansContactInfoDto> getContactInfo() {
		return ResponseEntity.status(HttpStatus.OK).body(loansContactInfoDto);
	}

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello World";
	}

	@PostMapping("/loans")
	public ResponseEntity<ResponseDto> createAccount(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		iLoansService.createLoan(mobileNumber);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
	}

	@GetMapping("/loans")
	public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("tusbank-correlation-id") String correlationId,
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		LoansDto loansDto = iLoansService.fetchLoan(mobileNumber);
		logger.debug("TusBank-correlation-id: found:{}", correlationId);
		System.out.println("Build Version: " + buildVersion);
		return ResponseEntity.status(HttpStatus.OK).body(loansDto);
	}

	@PutMapping("/loans")
	public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto) {
		boolean isUpdated = iLoansService.updateLoan(loansDto);
		if (isUpdated) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(LoansConstants.STATUS_500, LoansConstants.MESSAGE_500));
		}
	}

	@DeleteMapping("/loans")
	public ResponseEntity<ResponseDto> deleteLoanDetails(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(LoansConstants.STATUS_500, LoansConstants.MESSAGE_500));
		}
	}
}

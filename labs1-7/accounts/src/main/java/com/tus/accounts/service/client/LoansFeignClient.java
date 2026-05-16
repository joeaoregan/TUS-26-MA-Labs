package com.tus.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.tus.accounts.dto.LoansDto;

@FeignClient(name = "loans", fallback = LoansFallback.class) // Lab 31
public interface LoansFeignClient {
	
	@GetMapping(value = "/api/loans", consumes = "application/json")
	public ResponseEntity<LoansDto> fetchLoanDetails(@RequestHeader("tusbank-correlation-id") String correlationId,
			@RequestParam String mobileNumber);
}

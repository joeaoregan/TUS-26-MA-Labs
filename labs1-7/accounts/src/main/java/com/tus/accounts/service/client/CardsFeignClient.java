package com.tus.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tus.accounts.dto.CardsDto;

@FeignClient("cards")
public interface CardsFeignClient {
	@GetMapping(value="/api/cards", consumes="application/json")
	public ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}

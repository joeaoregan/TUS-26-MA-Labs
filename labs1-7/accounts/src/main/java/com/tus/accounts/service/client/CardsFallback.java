package com.tus.accounts.service.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tus.accounts.dto.CardsDto;

@Component
public class CardsFallback implements CardsFeignClient {

	@Override
	public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
		return null;
	}
}

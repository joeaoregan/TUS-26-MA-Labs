package com.tus.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CardsDto {
	@NotEmpty(message = "MobileNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
	private String mobileNumber;

	@NotEmpty(message = "Card Number cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits")
	private String cardNumber;

	@NotEmpty(message = "Card Type cannot be null or empty")
	private String cardType;

	@Positive(message = "Total card limit amount should be greater than zero")
	private Integer totalLimit;

	@PositiveOrZero(message = "Total card amount used should be equal or greater than zero")
	private Integer amountUsed;

	@PositiveOrZero(message = "Total available amount should be equal or greater than zero")
	private Integer availableAmount;
}

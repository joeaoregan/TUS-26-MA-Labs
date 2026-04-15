package com.tus.accounts.dto;

import jakarta.validation.constraints.Max; // Lab 7
import jakarta.validation.constraints.Min; // Lab 7
import jakarta.validation.constraints.NotEmpty; // Lab 7
import jakarta.validation.constraints.NotNull; // Lab 7
//import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
//	@NotEmpty(message = "AccountNumber cannot be null or empty")
//	@Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
	@NotNull(message = "AccountNumber cannot be null") // Lab 7
	@Min(value = 1000000000L, message = "AccountNumber must be 10 digits") // Lab 7
	@Max(value = 9999999999L, message = "AccountNumber must be 10 digits") // Lab 7
	private Long accountNumber;

	@NotEmpty(message = "AccountType cannot be null or empty") // Lab 7
	private String accountType;

	@NotEmpty(message = "BranchAddress cannot be null or empty") // Lab 7
	private String branchAddress;
}

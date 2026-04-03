package com.tus.accounts.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {
//	@NotEmpty(message = "AccountNumber cannot be null or empty")
//	@Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
	@NotNull(message = "AccountNumber cannot be null")
	@Min(value = 1000000000L, message = "AccountNumber must be 10 digits")
	@Max(value = 9999999999L, message = "AccountNumber must be 10 digits")
	private Long accountNumber;

	@NotEmpty(message = "AccountType cannot be null or empty")
	private String accountType;

	@NotEmpty(message = "BranchAddress cannot be null or empty")
	private String branchAddress;
}

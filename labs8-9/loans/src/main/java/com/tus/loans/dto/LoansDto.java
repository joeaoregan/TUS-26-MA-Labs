package com.tus.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LoansDto {
	@NotEmpty(message = "MobileNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
	private String mobileNumber;
	
	@NotEmpty(message = "LoanNumber cannot be null or empty")
	@Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
	private String loanNumber;

	@NotEmpty(message = "LaonType cannot be null or empty")
	private String loanType;

	@Positive(message = "Total loan amount should be greater than zero")
	private Integer totalLoan;

	@PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
	private Integer amountPaid;

	@PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
	private Integer outstandingAmount;
}

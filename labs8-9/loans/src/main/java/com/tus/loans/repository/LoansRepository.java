package com.tus.loans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.tus.loans.entity.Loans;

public interface LoansRepository extends JpaRepository<Loans, Long> {

	Optional<Loans> findByMobileNumber(String mobileNumber);
	
	Optional<Loans> findByLoanNumber(String loanNumber);

	@Transactional
	@Modifying
	void deleteByLoanId(Long loanId);
}

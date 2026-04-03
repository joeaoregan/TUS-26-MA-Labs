package com.tus.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.tus.cards.entity.Cards;

public interface CardsRepository extends JpaRepository<Cards, Long> {

	Optional<Cards> findByMobileNumber(String mobileNumber);
	
	Optional<Cards> findByCardNumber(String cardNumber);

	@Transactional
	@Modifying
	void deleteByCardId(Long cardId);
}

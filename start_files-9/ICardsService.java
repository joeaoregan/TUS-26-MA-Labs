package com.tus.cards.service;

import com.tus.cards.dto.CardsDto;

public interface ICardsService {

   
    void createCard(String mobileNumber);
    CardsDto fetchCard(String mobileNumber);
    boolean updateCard(CardsDto cardsDto);
    boolean deleteCard(String mobileNumber);

}
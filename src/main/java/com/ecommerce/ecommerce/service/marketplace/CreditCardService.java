package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CreditCard;
import com.ecommerce.ecommerce.status.Status;

import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAllCards();

    CreditCard getCardById(Integer cardId);

    Status createCard(CreditCard creditCard);

    Status updateCard(CreditCard creditCard);

    Status deleteCard(CreditCard creditCard);
}

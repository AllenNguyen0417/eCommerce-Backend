package com.ecommerce.ecommerce.service.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CartItem;
import com.ecommerce.ecommerce.model.marketplace.CreditCard;
import com.ecommerce.ecommerce.model.marketplace.User;
import com.ecommerce.ecommerce.repository.marketplace.CreditCardRepository;
import com.ecommerce.ecommerce.repository.marketplace.UserRepository;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<CreditCard> getAllCards() {
        List<CreditCard> creditCards = creditCardRepository.findAll();
        return creditCards;
    }

    @Override
    public CreditCard getCardById(Integer cardId) {
        CreditCard creditCard = creditCardRepository.findByCreditCardId(cardId);
        return creditCard;
    }

    @Override
    public Status createCard(CreditCard creditCard) {
        CreditCard creCard = creditCardRepository.findByCreditCardId(creditCard.getCreditCardId());
        List<User> users = userRepository.findAll();
        List<Integer> userIds = new ArrayList<>();
        for (User user: users) {
            userIds.add(user.getUserId());
        }
        if (!userIds.contains(creditCard.getUserId())) {
            return Status.USER_ID_NOT_EXISTS;
        }
        creditCardRepository.save(creditCard);
        return Status.SUCCESS;
    }

    @Override
    public Status updateCard(CreditCard creditCard) {
        CreditCard creCard = creditCardRepository.findByCreditCardId(creditCard.getCreditCardId());
        List<User> users = userRepository.findAll();
        List<Integer> userIds = new ArrayList<>();
        for (User user: users) {
            userIds.add(user.getUserId());
        }

        if (creCard == null) {
            return Status.CREDIT_CARD_NOT_FOUND;
        }

        if (creditCard.getUserId() != null) {
            if (!userIds.contains(creditCard.getUserId())) {
                return Status.USER_ID_NOT_EXISTS;
            }
            creCard.setUserId(creditCard.getUserId());
            creditCardRepository.save(creCard);
        }


        if (creditCard.getCardholderName() != null) {
            creCard.setCardholderName(creditCard.getCardholderName());
            creditCardRepository.save(creCard);
        }

        if (creditCard.getLastFourCardNumber() != null) {
            creCard.setLastFourCardNumber(creditCard.getLastFourCardNumber());
            creditCardRepository.save(creCard);
        }

        if (creditCard.getExpirationYear() != null) {
            creCard.setExpirationYear(creditCard.getExpirationYear());
            creditCardRepository.save(creCard);
        }

        if (creditCard.getExpirationMonth() != null) {
            creCard.setExpirationMonth(creditCard.getExpirationMonth());
            creditCardRepository.save(creCard);
        }
        return Status.SUCCESS;
    }

    @Override
    public Status deleteCard(CreditCard creditCard) {
        CreditCard creCard = creditCardRepository.findByCreditCardId(creditCard.getCreditCardId());
        if (creCard == null) {
            return Status.CREDIT_CARD_NOT_FOUND;
        }
        creditCardRepository.delete(creCard);
        return Status.SUCCESS;
    }
}

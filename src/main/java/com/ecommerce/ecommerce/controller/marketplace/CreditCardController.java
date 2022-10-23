package com.ecommerce.ecommerce.controller.marketplace;

import com.ecommerce.ecommerce.model.marketplace.CreditCard;
import com.ecommerce.ecommerce.service.marketplace.CreditCardService;
import com.ecommerce.ecommerce.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/marketplace")
public class CreditCardController {

    @Autowired
    CreditCardService creditCardService;

    @GetMapping("/cards")
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        List<CreditCard> creditCards = creditCardService.getAllCards();
        if (creditCards.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(creditCards);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping("/card/{creditCardId}")
    public ResponseEntity<CreditCard> getSingleCard(@PathVariable Integer creditCardId) {
        CreditCard creditCard = creditCardService.getCardById(creditCardId);
        if (creditCard == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(creditCard);
        }
    }

    @PostMapping("/createcard")
    public ResponseEntity<String> createCarditCard (@RequestBody CreditCard creditCard) {
        Status stt = creditCardService.createCard(creditCard);
        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Credit Card Create Successfully!");
        }
        else if (stt == Status.USER_ID_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID Not Exist");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updatecard")
    public ResponseEntity<String> updateCreditCard (@RequestBody CreditCard creditCard) {
        Status stt = creditCardService.updateCard(creditCard);

        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Credit Card Update Successfully!");
        }

        else if (stt == Status.CREDIT_CARD_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credit Card Not Found!");
        }

        else if (stt == Status.USER_ID_NOT_EXISTS) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User ID Not Exists!");
        }

        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/deletecard")
    public ResponseEntity<String> deleteCreditCard (@RequestBody CreditCard creditCard) {
        Status stt = creditCardService.deleteCard(creditCard);

        if (stt == Status.SUCCESS) {
            return ResponseEntity.status(HttpStatus.OK).body("Card Delete Successfully!");
        }
        else if (stt == Status.CREDIT_CARD_NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Card Not Found!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

package com.ecommerce.ecommerce.model.marketplace;

import javax.persistence.*;

@Table(name = "credit_cards")
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditCardId;
    private Integer userId;
    private String cardholderName;
    private String lastFourCardNumber;
    private String expirationYear;
    private String expirationMonth;

    public Integer getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(Integer creditCardId) {
        this.creditCardId = creditCardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getLastFourCardNumber() {
        return lastFourCardNumber;
    }

    public void setLastFourCardNumber(String lastFourCardNumber) {
        this.lastFourCardNumber = lastFourCardNumber;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public CreditCard(Integer creditCardId, Integer userId, String cardholderName, String lastFourCardNumber, String expirationYear, String expirationMonth) {
        this.creditCardId = creditCardId;
        this.userId = userId;
        this.cardholderName = cardholderName;
        this.lastFourCardNumber = lastFourCardNumber;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
    }
    public CreditCard(){

    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardId=" + creditCardId +
                ", userId=" + userId +
                ", cardholderName='" + cardholderName + '\'' +
                ", lastFourCardNumber='" + lastFourCardNumber + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                '}';
    }
}

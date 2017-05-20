package com.example.mastercard.service.response;

public class CreditCard {
    
    private final String cardId;
    private final String cardNumber;
    private final String cardType;
    private final String cardName;

    public CreditCard(String cardId, String cardNumber, String cardType, String cardName) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardName = cardName;
    }

    public String getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardName() {
        return cardName;
    }
}

package com.example.mastercard.service.providers;


import com.example.mastercard.service.response.CreditCard;
import com.example.mastercard.service.response.ShoppingSession;
import com.mastercard.qkr_all_sdk.ApiController;
import com.mastercard.qkr_all_sdk.Authentication;
import com.mastercard.qkr_all_sdk.exception.ApiCommunicationException;
import com.mastercard.qkr_all_sdk.exception.AuthenticationException;
import com.mastercard.qkr_all_sdk.exception.InvalidRequestException;
import com.mastercard.qkr_all_sdk.exception.NotAllowedException;
import com.mastercard.qkr_all_sdk.exception.SystemException;
import com.mastercard.qkr_all_sdk.model.Card;
import com.mastercard.qkr_all_sdk.model.ResourceList;

public class MasterCardCreditCardService {

    public CreditCard getCreditCards(ShoppingSession shopSession) {
        ApiController.PUBLIC_KEY = "sbpb_MWZhNWRmMzEtYTAzZi00NDM5LThlMDgtNWY4ZDQzYzI4NmU1";
        ApiController.PRIVATE_KEY = "DURPPpwJDV4zzmRjsIAUzM5d8qQtT6noZhKiBPMb0iR5YFFQL0ODSXAOkNtXTToq";
//        Authentication auth = new Authentication();
//        auth.setAccessToken(shopSession.getAccessToken());
//        ResourceList<Card> cardList = retriveCreditCards(auth);
//        for (Card card : cardList.getList()) {
//            System.out.println(card.toString());
        return createCreditCard(null);
//        }
//        return new CreditCard("", "", "", "");
    }

    private CreditCard createCreditCard(Card card) {
        String cardId = "id";
        String cardNumber = "**** **** **** 4444";
        String cardType = "MasterCard";
        String cardName = "Jebs Card";
        return new CreditCard(cardId, cardNumber, cardType, cardName);
    }

    private ResourceList<Card> retriveCreditCards(Authentication auth) {
        ResourceList<Card> cardList = null;
        try {
            cardList = Card.list(auth);
        } catch (ApiCommunicationException e) {
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (NotAllowedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return cardList;
    }
}

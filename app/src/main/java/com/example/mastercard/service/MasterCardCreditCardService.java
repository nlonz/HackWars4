package com.example.mastercard.service;

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

    public void getCreditCards(ShoppingSession shopSession) {
        ApiController.PUBLIC_KEY = "sbpb_MWZhNWRmMzEtYTAzZi00NDM5LThlMDgtNWY4ZDQzYzI4NmU1";
        ApiController.PRIVATE_KEY = "DURPPpwJDV4zzmRjsIAUzM5d8qQtT6noZhKiBPMb0iR5YFFQL0ODSXAOkNtXTToq";
        Authentication auth = new Authentication();
        auth.setAccessToken(shopSession.getAccessToken());
        Card card = null;
//        try {
//            card = Card.create(auth, new BaseMap()
//            .set("alias", "Jebs Card")
//            .set("pan", "5555555555554444")
//            .set("expMonth", "04")
//            .set("expYear", "18")
//            .set("name", "Jeb Watkins")
//            .set("addressZip", "75000"));
//        } catch (ApiCommunicationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (AuthenticationException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InvalidRequestException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (NotAllowedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (SystemException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        ResourceList<Card> cardList = null;
        try {
            cardList = Card.list(auth);
        } catch (ApiCommunicationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotAllowedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SystemException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Card c : cardList.getList()) {
        System.out.println(c.toString());
        }
        //System.out.println("Card ID is " + card.get("cardId"));
    }
}

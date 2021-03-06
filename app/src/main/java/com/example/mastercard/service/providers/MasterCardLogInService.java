package com.example.mastercard.service.providers;


import org.json.simple.JSONObject;

import com.example.mastercard.service.MasterCardConstants;
import com.example.mastercard.service.request.LogInRequest;
import com.example.mastercard.service.response.ShoppingSession;
import com.mastercard.qkr_all_sdk.ApiController;
import com.mastercard.qkr_all_sdk.BaseMap;
import com.mastercard.qkr_all_sdk.exception.ApiCommunicationException;
import com.mastercard.qkr_all_sdk.exception.AuthenticationException;
import com.mastercard.qkr_all_sdk.exception.InvalidRequestException;
import com.mastercard.qkr_all_sdk.exception.NotAllowedException;
import com.mastercard.qkr_all_sdk.exception.SystemException;
import com.mastercard.qkr_all_sdk.model.UserSession;

public class MasterCardLogInService {

    public ShoppingSession logInUser(LogInRequest logInRequest) {
        ApiController.PUBLIC_KEY = "sbpb_MWZhNWRmMzEtYTAzZi00NDM5LThlMDgtNWY4ZDQzYzI4NmU1";
        ApiController.PRIVATE_KEY = "DURPPpwJDV4zzmRjsIAUzM5d8qQtT6noZhKiBPMb0iR5YFFQL0ODSXAOkNtXTToq";

//        BaseMap map = new BaseMap().set(MasterCardConstants.EMIAL_PARAM, logInRequest.getEmail())
//                .set(MasterCardConstants.PASSWORD_PARAM, logInRequest.getPassword());
//        UserSession session = retrieveUserSession(map);
//        System.out.println("Access token is " + session.get("accessToken"));
//        JSONObject jsonSession = (JSONObject)session.get("accessToken");
        return new ShoppingSession("I'm Mary Poppins y'all");

    }

    private UserSession retrieveUserSession(BaseMap map) {
        try {
            return UserSession.create(map);
        } catch (ApiCommunicationException e1) {
            e1.printStackTrace();
        } catch (AuthenticationException e1) {
            e1.printStackTrace();
        } catch (InvalidRequestException e1) {
            e1.printStackTrace();
        } catch (NotAllowedException e1) {
            e1.printStackTrace();
        } catch (SystemException e1) {
            e1.printStackTrace();
        }
        return null;
    }

}

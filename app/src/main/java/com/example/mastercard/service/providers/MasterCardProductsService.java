package com.example.mastercard.service.providers;

import java.util.ArrayList;
import java.util.List;

import com.example.mastercard.service.response.FlightMenu;
import com.example.mastercard.service.response.MenuProduct;
import com.mastercard.qkr_all_sdk.BaseMap;
import com.mastercard.qkr_all_sdk.exception.ApiCommunicationException;
import com.mastercard.qkr_all_sdk.exception.AuthenticationException;
import com.mastercard.qkr_all_sdk.exception.InvalidRequestException;
import com.mastercard.qkr_all_sdk.exception.NotAllowedException;
import com.mastercard.qkr_all_sdk.exception.SystemException;
import com.mastercard.qkr_all_sdk.model.Merchant;
import com.mastercard.qkr_all_sdk.model.ProdGroup;
import com.mastercard.qkr_all_sdk.model.ResourceList;

public class MasterCardProductsService {

    public FlightMenu getMenu() {
//        ResourceList<Merchant> merchantResourceList = retrieveProducts();
//        for (Merchant merchant : merchantResourceList.getList()) {
//            System.out.println(merchant);
//        }
//
//        Merchant merchant = merchantResourceList.getList().get(0);
//        JSONArray outlets = (JSONArray) merchant.get("outlets");
//        JSONObject firstOutlet = (JSONObject) outlets.get(0);
//        JSONArray prodGroups = (JSONArray) firstOutlet.get("prodGroupSummaries");
//        JSONObject menu = (JSONObject) prodGroups.get(0);
//        String prodGroupId = menu.get("id").toString();
//        ProdGroup prodGroup = null;
//        try {
//            prodGroup = ProdGroup.find(prodGroupId);
//        } catch (ApiCommunicationException e) {
//            e.printStackTrace();
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//        } catch (InvalidRequestException e) {
//            e.printStackTrace();
//        } catch (ObjectNotFoundException e) {
//            e.printStackTrace();
//        } catch (NotAllowedException e) {
//            e.printStackTrace();
//        } catch (SystemException e) {
//            e.printStackTrace();
//        }
//        System.out.println("ProdGroup is " + prodGroup);
//
        return createFlightMenu(null);
    }

    private FlightMenu createFlightMenu(ProdGroup prodGroup) {
        // TODO Parse response here
        MenuProduct jackDan = new MenuProduct("Jack Daniels", "5.00", "12345");
        MenuProduct bud = new MenuProduct("Bud Light", "3.50", "67890");
        List<MenuProduct> drinks = new ArrayList<>();
        drinks.add(jackDan);
        drinks.add(bud);
        String outletId = "102938";
        String locatedScanId = "665748";
        return new FlightMenu(drinks, new ArrayList<MenuProduct>(), outletId, locatedScanId);
    }

    private ResourceList<Merchant> retrieveProducts() {
        try {
            BaseMap baseMapRequest = new BaseMap().set("latitude", "32.7767").set("longitude", "96.7970");
            return Merchant.list(baseMapRequest);
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
        return null;
    }
}

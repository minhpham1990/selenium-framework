package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Credential {

    public static Credential get(String file){
        try {
            ObjectMapper om = new ObjectMapper();
            Credential dj = om.readValue(new File(file),Credential.class);
            return dj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @JsonProperty("product_search")
    String productSearch;

    @JsonProperty("UserCred")
    User user;

    static class User{
        @JsonProperty("username")
        String username;

        @JsonProperty("password")
        String password;
    }

    public String getProductSearch() {
        return productSearch;
    }

    public void setProductSearch(String product){
        this.productSearch=product;
    }

    public String getUserName() {
        return user.username;
    }

    public String getPassword() {
        return user.password;
    }
}

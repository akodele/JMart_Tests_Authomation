package api.models;

import lombok.Data;



public @Data class AuthDataModel {
    private String login;
    private String password;

//    @Override
//    public String toString() {
//        return "{\"login\": \"" + login + "\", \"password\":\"" + password + "\"}";
//    }
}

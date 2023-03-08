package api;

import api.models.AuthDataModel;
import io.restassured.http.ContentType;

import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class AuthAsClient {

    public String getToken(){
        AuthDataModel authDataModel=new AuthDataModel();
        authDataModel.setLogin("rustamtest1@mail.ru");
        authDataModel.setPassword("qwerty123");
        String token=given()
                .spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(authDataModel)
                .when()
                .post("/user/v1/auth/sign-in")
                .then()
                .spec(responseSpec(201))
                .extract().response().path("data.tokens.auth.token");
        return token;
    }
}

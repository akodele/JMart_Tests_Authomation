package api;

import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class AuthAsClient {
    public String getToken(){
        String body="{\"login\": \"rustamtest1@mail.ru\", \"password\": \"qwerty123\"}";
        String token=given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post("/user/v1/auth/sign-in")
                .then()
                .spec(responseSpec(201))
                .extract().response().path("data.tokens.auth.token");
        return token;
    }
}

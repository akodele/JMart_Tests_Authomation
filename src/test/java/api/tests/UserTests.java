package api.tests;

import api.AuthAsClient;
import api.models.ProfileResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class UserTests {
    @Tag("api_test")
    @Test
    @DisplayName("Авторизация пользователя")
    void checkAuth(){
        String body="{\"login\": \"rustamtest1@mail.ru\", \"password\": \"qwerty123\"}";
        String token=given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post("/user/v1/auth/sign-in")
                .then()
                .spec(responseSpec(201))
                .extract().response().path("data.tokens.auth.token");
    }

    @Tag("api_test")
    @Test
    @DisplayName("Получение профиля пользователя")
    void getUserCart(){
        AuthAsClient client=new AuthAsClient();
        String token=client.getToken();
        ProfileResponseModel profile = given()
                .header("Authorization", "Bearer " + token)
                .spec(requestSpec)
                .when()
                .get("/user/v2/profile")
                .then()
                .spec(responseSpec(200)).extract().as(ProfileResponseModel.class);
        Assertions.assertEquals("РУСТАМ",
                profile.getData().getUser().getFirstname());
        Assertions.assertEquals("ЕЛКИН",
                profile.getData().getUser().getLastname());
    }
}

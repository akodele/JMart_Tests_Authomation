package api.tests;

import api.AuthAsClient;
import api.models.AuthDataModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static api.specs.Specs.requestSpec;
import static api.specs.Specs.responseSpec;
import static io.restassured.RestAssured.given;

public class CartTests {

    @Tag("api_test")
    @Test
    @DisplayName("Добавление товара 549819 в количестве 15 в корзину")
    void putProductToCart(){
        AuthAsClient client=new AuthAsClient();
        String token=client.getToken();
        String body = "{\"products\": [{\"product_id\": 549819,\"amount\": 15}]}";
        given()
                .header("Authorization", "Bearer " + token)
                .spec(requestSpec)
                .body(body)
                .when()
                .put("/cart/v2/cart")
                .then()
                .spec(responseSpec(200));

    }

    @Tag("api_test")
    @Test
    @DisplayName("Получение списка корзин пользователя")
    void getUserCart(){
        AuthAsClient client=new AuthAsClient();
        String token=client.getToken();
        given()
                .header("Authorization", "Bearer " + token)
                .spec(requestSpec)
                .when()
                .get("/cart/v2/cart")
                .then()
                .spec(responseSpec(200));

    }

    @Tag("api_test")
    @Test
    @DisplayName("Очистка корзин пользователя")
    void deleteUserCart(){
        AuthAsClient client=new AuthAsClient();
        String token=client.getToken();
        given()
                .header("Authorization", "Bearer " + token)
                .spec(requestSpec)
                .when()
                .delete("/cart/v2/cart")
                .then()
                .spec(responseSpec(200));

    }

}

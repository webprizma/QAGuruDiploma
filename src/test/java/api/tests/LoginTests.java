package api.tests;

import api.enums.Paths;
import api.models.RegistrationAndLoginModel;
import api.models.UserCredentialsModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.helpers.CustomApiListener.withCustomTemplates;
import static api.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests {
    @Epic("ReqresIn api autotests")
    @Story("Login tests")
    @Feature("Successful login test")
    @Tag("login")
    @Tag("api")
    @Test
    void userLoginSuccessfulTest() {
        UserCredentialsModel userCredentialsModel = new UserCredentialsModel();
        userCredentialsModel.setEmail("eve.holt@reqres.in");
        userCredentialsModel.setPassword("cityslicka");

        RegistrationAndLoginModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userCredentialsModel)
                .when()
                .post(Paths.LOGIN.url)
                .then()
                .spec(logResponseSpec)
                .spec(status200ResponseSpec)
                .extract()
                .as(RegistrationAndLoginModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Epic("ReqresIn api autotests")
    @Story("Login tests")
    @Feature("Unsuccessful login test")
    @Tag("login")
    @Tag("api")
    @Test
    void userLoginUnsuccessfulTest() {
        UserCredentialsModel userCredentialsModel = new UserCredentialsModel();
        userCredentialsModel.setEmail("peter@klaven");

        RegistrationAndLoginModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userCredentialsModel)
                .when()
                .post(Paths.LOGIN.url)
                .then()
                .spec(logResponseSpec)
                .spec(status400ResponseSpec)
                .extract()
                .as(RegistrationAndLoginModel.class);

        assertThat(response.getError()).isEqualTo("Missing password");
    }
}

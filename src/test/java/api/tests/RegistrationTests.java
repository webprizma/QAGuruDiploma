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

@Tag("registration")
@Tag("api")
public class RegistrationTests {
    @Epic("ReqresIn api autotests")
    @Story("Registration tests")
    @Feature("Successful registration test")
    @Test
    void userRegistrationSuccessfulTest() {
        UserCredentialsModel userCredentialsModel = new UserCredentialsModel();
        userCredentialsModel.setEmail("eve.holt@reqres.in");
        userCredentialsModel.setPassword("pistol");

        RegistrationAndLoginModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userCredentialsModel)
                .when()
                .post(Paths.REGISTER.url)
                .then()
                .spec(logResponseSpec)
                .spec(status200ResponseSpec)
                .extract()
                .as(RegistrationAndLoginModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Epic("ReqresIn api autotests")
    @Story("Registration tests")
    @Feature("Unsuccessful registration test")
    @Test
    void userRegistrationUnsuccessfulTest() {
        UserCredentialsModel userCredentialsModel = new UserCredentialsModel();
        userCredentialsModel.setEmail("sydney@fife");

        RegistrationAndLoginModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userCredentialsModel)
                .when()
                .post(Paths.REGISTER.url)
                .then()
                .spec(logResponseSpec)
                .spec(status400ResponseSpec)
                .extract()
                .as(RegistrationAndLoginModel.class);

        assertThat(response.getError()).isEqualTo("Missing password");
    }
}

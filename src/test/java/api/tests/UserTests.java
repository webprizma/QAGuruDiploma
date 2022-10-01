package api.tests;

import api.enums.Paths;
import api.models.SingleUserDataModel;
import api.models.UserListModel;
import api.models.UserModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.helpers.CustomApiListener.withCustomTemplates;
import static api.specs.Specs.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("users")
@Tag("api")
public class UserTests {
    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("Get users list test")
    @Test
    void userListTest() {
        UserListModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .when()
                .get(Paths.USERS.url + "?page=2")
                .then()
                .spec(logResponseSpec)
                .spec(status200ResponseSpec)
                .extract()
                .as(UserListModel.class);

        assertThat(response.getTotal()).isEqualTo(12);
    }

    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("Get single user test")
    @Test
    void singleUserTest() {
        SingleUserDataModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .when()
                .get(Paths.USERS.url + "3")
                .then()
                .spec(logResponseSpec)
                .spec(status200ResponseSpec)
                .extract()
                .as(SingleUserDataModel.class);

        assertThat(response.getData().getEmail()).isEqualTo("emma.wong@reqres.in");
    }

    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("User not found test")
    @Test
    void unknownUserTest() {
        given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .when()
                .get(Paths.USERS.url + "23")
                .then()
                .spec(logResponseSpec)
                .spec(status404ResponseSpec);
    }

    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("Create user test")
    @Test
    void userCreateTest() {
        UserModel userModel = new UserModel();
        userModel.setName("neo");
        userModel.setJob("clerk");

        UserModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userModel)
                .when()
                .post(Paths.USERS.url)
                .then()
                .spec(logResponseSpec)
                .spec(status201ResponseSpec)
                .extract()
                .as(UserModel.class);

        assertThat(response.getJob()).isEqualTo("clerk");
    }

    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("Update user test")
    @Test
    void userUpdateTest() {
        UserModel userModel = new UserModel();
        userModel.setName("neo");
        userModel.setJob("chosen one");

        UserModel response = given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .spec(contentTypeJSONRequestSpec)
                .body(userModel)
                .when()
                .patch(Paths.USERS.url + "386")
                .then()
                .spec(logResponseSpec)
                .spec(status200ResponseSpec)
                .extract()
                .as(UserModel.class);

        assertThat(response.getJob()).isEqualTo("chosen one");
    }

    @Epic("ReqresIn api autotests")
    @Story("User tests")
    @Feature("Delete user test")
    @Test
    void userDeleteTest() {
        given()
                .filter(withCustomTemplates())
                .spec(logRequestSpec)
                .when()
                .delete(Paths.USERS.url + "386")
                .then()
                .spec(logResponseSpec)
                .spec(status204ResponseSpec);
    }
}

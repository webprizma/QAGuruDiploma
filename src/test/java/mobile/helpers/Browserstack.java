package mobile.helpers;

import mobile.config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    public static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class, System.getProperties());
    public static String videoUrl(String sessionId) {
        String url = format(driverConfig.getUrl(), sessionId);

        return given()
                .auth().basic(driverConfig.getLogin(), driverConfig.getPassword())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path(driverConfig.getVideoUrl());
    }
}

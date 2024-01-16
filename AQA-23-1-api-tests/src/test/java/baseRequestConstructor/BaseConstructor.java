package baseRequestConstructor;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.UrlsList.ACCOUNT_LOGIN_ENDPOINT;
import static utils.UrlsList.ACCOUNT_V1_USER_ENDPOINT;

public class BaseConstructor {
    //Body for existed user
    public static final String ACCOUNT_1_AUTH_BODY = "{\n" +
            "  \"userName\": \"StasUser1\",\n" +
            "  \"password\": \"P@ssword1\"\n" +
            "}";

    //
    public String getTokenForBaseUser() {
        ExtractableResponse<Response> response =
                postLoginMethod(ACCOUNT_1_AUTH_BODY);
        return response.body().jsonPath().get("token").toString();
    }

    //Add method with
    private ExtractableResponse<Response> postLoginMethod(String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .log()
                .all()
                .when()
                .post(ACCOUNT_LOGIN_ENDPOINT)
                .then().log().all().extract();
    }

    //Get all user`s books list
    public ExtractableResponse<Response> getBooksForUser(String token, String userId) {
        return given()
                .spec(getSpecWithAuth(token)) // Add specification for request like header or cookies
                .log().all()
                .when()
                .get(ACCOUNT_V1_USER_ENDPOINT + userId)
                .then()
                .log().all().extract();
    }

    public RequestSpecification getSpecWithAuth(String bearerToken) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addHeader("Content-Type", "application/json");
        specBuilder.addHeader("Authorization", "Bearer " + bearerToken);
        return specBuilder.build();
    }


}

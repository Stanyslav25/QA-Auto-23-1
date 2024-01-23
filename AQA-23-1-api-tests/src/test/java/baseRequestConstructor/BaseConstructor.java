package baseRequestConstructor;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.Map;

import static baseRequestConstructor.JsonConstructor.getLoginBodyForAccount;
import static baseRequestConstructor.JsonConstructor.getLoginBodyStasUser1;
import static io.restassured.RestAssured.given;
import static utils.UrlsList.*;

public class BaseConstructor {
    @BeforeAll
    public static void setBaseUrl() {
        RestAssured.baseURI = "https://demoqa.com";
        RestAssured.given(getSpecWithoutAuth());
    }

    public String getTokenForBaseUser() {
        ExtractableResponse<Response> response =
                postLoginMethod(getLoginBodyStasUser1());
        return response.body().jsonPath().get("token").toString();
    }

    public String getTokenForAccount(String userName, String pass) {
        ExtractableResponse<Response> response =
                postLoginMethod(getLoginBodyForAccount(userName, pass));
        return response.body().jsonPath().get("token").toString();
    }

    //Add method with
    public ExtractableResponse<Response> postLoginMethod(String payload) {
        return given()
                .header("Content-Type", "application/json")
                .body(payload)
                .log()
                .all()
                .when()
                .post(BASE_ACCOUNT + ACCOUNT_LOGIN_ENDPOINT)
                .then().log().all().extract();
    }

    //Get all user`s books list
    public ExtractableResponse<Response> getBooksForUser(String token, String userId) {
        return requestWithAuth(token)
                .when()
                .get(ACCOUNT_V1_USER_ENDPOINT + userId)
                .then()
                .log().all().extract();
    }

    public RequestSpecification getSpecWithAuth(String bearerToken) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addHeader("Authorization", "Bearer " + bearerToken);
        return specBuilder.build();
    }

    public static RequestSpecification getSpecWithoutAuth() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addHeader("Content-Type", "application/json");
        return specBuilder.build();
    }

    public ExtractableResponse<Response> createNewUser(String userName, String pass) {
        return  given()
                .header("Content-Type", "application/json")
                .body(getLoginBodyForAccount(userName, pass))
                .log().all()
                .when().post("https://demoqa.com/Account/v1/User")
                .then().log().all().extract();
    }

    public ExtractableResponse<Response> deleteUserById(String userId, String token) {
        return  requestBase(getSpecWithAuth(token))
                .when()
                .delete(ACCOUNT_V1_USER_ENDPOINT + userId)
                .then()
                .log().all().extract();
    }

    public ExtractableResponse<Response> generateToken(String userName, String pass){
        return given()
                .header("Content-Type", "application/json")
                .body(getLoginBodyForAccount(userName, pass))
                .log()
                .all()
                .when()
                .post("https://demoqa.com/Account/v1/GenerateToken")
                .then().log().all().extract();
    }

    protected RequestSpecification requestBase(RequestSpecification specification) {
        return given().spec(specification).log().all();
    }

    protected RequestSpecification requestGivenLogAll() {
        return given().log().all();
    }
    protected RequestSpecification requestWithAuth(String token) {
        return requestGivenLogAll()
                .queryParams(Map.of(
                        "Content-Type", "application/json",
                        "token", token
                ));
    }


}

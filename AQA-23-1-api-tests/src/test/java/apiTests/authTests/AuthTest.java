package apiTests.authTests;

import baseRequestConstructor.BaseConstructor;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import utils.FileUtils;

import java.io.File;

import static baseRequestConstructor.JsonConstructor.getLoginBodyForAccount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.TestUsers.BASE_USER_ID;

public class AuthTest extends BaseConstructor {

    String userName = "Stas12332154";
    String pass = "P@ssword1";

    String userId;

    @Test
    public void getUserBooksAfterAuth() throws JSONException {
        ExtractableResponse<Response> extResp =
                getBooksForUser(getTokenForBaseUser(), BASE_USER_ID);
        assertEquals(HttpStatus.SC_OK, extResp.statusCode());

        JSONObject jsonObject = new JSONObject(String.format(FileUtils.readDataFromFile(new File("src/test/resources/assertGetBooks.json")),7777));
        System.out.println("JSON INFO" + jsonObject);

        JSONAssert.assertEquals(
                jsonObject.toString(),
                extResp.asPrettyString(),
                compareBooksExceptIsbnFiled()
        );

//        JSONAssert.assertEquals(
//                extResp.asPrettyString(),
//                jsonObject,
//                JSONCompareMode.LENIENT
//        );

//        String isbnList = extResp.body().jsonPath().getList("books.isbn").toString();
//        assertTrue(isbnList.contains("9781449325862"));

//        assertTrue(extResp.body().jsonPath().get("books.isbn[0]").equals("9781449325862"));

//        assertThat(extResp.body().jsonPath().getList("books.isbn"),
//                allOf(hasItem("9781449325862"),hasItem("9781449337711"))); //Check that list of ISBN contains propper values
//        assertThat((Map<String,String>) extResp.body().jsonPath().getList("books").get(0),
//                allOf(hasKey("isbn"), hasKey("title"))); // Check keys in JSON object after cast to Map object
    }

    public static JSONComparator compareBooksExceptIsbnFiled() {
        return new CustomComparator(JSONCompareMode.LENIENT,
                new Customization("books[author=Richard E. Silverman].isbn", (o1, o2) -> true),
                new Customization("books[author=Glenn Block et al.].isbn", (o1, o2) -> true)
        );
    }

    @Test
    public void createNewUserAndGetToken() {
        //Create user step
        ExtractableResponse<Response> create = createNewUser(userName, pass);
        generateToken(userName, pass);
        //Get user info after login step
        ExtractableResponse<Response> getUserInfo =
                postLoginMethod(getLoginBodyForAccount(userName, pass));

        userId = getUserInfo.jsonPath().getString("userId").toString();
        String token = getUserInfo.body().jsonPath().getString("token").toString();
        //Delete user
        ExtractableResponse<Response> deleteUser = deleteUserById(userId, token);

        //Create user assert
        assertEquals(HttpStatus.SC_CREATED, create.statusCode());
        //Get user info after login assert
        assertEquals(HttpStatus.SC_OK,getUserInfo.statusCode());
        //Delete user assert
        assertEquals(HttpStatus.SC_NO_CONTENT, deleteUser.statusCode());
    }
}

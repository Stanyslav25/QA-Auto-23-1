package apiTests.authTests;

import baseRequestConstructor.BaseConstructor;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.Json;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;
import org.skyscreamer.jsonassert.comparator.JSONComparator;
import utils.FileUtils;

import java.io.File;
import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasKey;
import static utils.TestUsers.BASE_USER_ID;

public class AuthTest extends BaseConstructor {

    @Test
    public void getUserBooksAfterAuth() throws JSONException {
        String token = getTokenForBaseUser(); // Get token for user
        System.out.println("INFO:" + token);
        ExtractableResponse<Response> extResp = getBooksForUser(token, BASE_USER_ID);

        System.out.println("RespINFO:  " + extResp.asString());

        JSONObject jsonObject = new JSONObject(FileUtils.readDataFromFile(new File("src/test/resources/assertGetBooks.json")));

        JSONAssert.assertEquals(
                extResp.asPrettyString(),
                jsonObject.toString(),
                compareBooksExceptIsbnFiled()
        );

        JSONAssert.assertEquals(
                extResp.asPrettyString(),
                jsonObject,
                JSONCompareMode.LENIENT
        );



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

}

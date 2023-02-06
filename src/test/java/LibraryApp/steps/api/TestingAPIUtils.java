package LibraryApp.steps.api;

import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.API_Utils;
import LibraryApp.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apiguardian.api.API;

import java.util.Map;

public class TestingAPIUtils {
    public static void main(String[] args) {
String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiNTgxMyIsImZ1bGxfbmFtZSI6IlRlc3QgTGlicmFyaWFuIDEiLCJlbWFpbCI6ImxpYnJhcmlhbjFAbGlicmFyeSIsInVzZXJfZ3JvdXBfaWQiOiIyIn0sImlhdCI6MTY3NDc3MDI4MSwiZXhwIjoxNjc3MzYyMjgxfQ.sXrtrGZREDZYBtkIm0UvHxrB0Hh74CYSKBd60a4X-u4";

        Map<String, Object> testMap = API_Utils.getRandomUserMap("librarian");

        System.out.println(testMap);

        RestAssured.given().accept(ContentType.JSON)
                .header("x-library-token", token).when().get(ConfigurationReader.getProperty("baseURI") +"/get_book_categories").prettyPeek();

    }




    }

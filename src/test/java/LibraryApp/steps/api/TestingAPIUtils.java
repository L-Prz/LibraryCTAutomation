package LibraryApp.steps.api;

import LibraryApp.utilities.APITestBase;
import LibraryApp.utilities.API_Utils;
import LibraryApp.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apiguardian.api.API;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestingAPIUtils extends APITestBase{
    public static void main(String[] args) {

        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiNTgxMyIsImZ1bGxfbmFtZSI6IlRlc3QgTGlicmFyaWFuIDEiLCJlbWFpbCI6ImxpYnJhcmlhbjFAbGlicmFyeSIsInVzZXJfZ3JvdXBfaWQiOiIyIn0sImlhdCI6MTY3NDc3MDI4MSwiZXhwIjoxNjc3MzYyMjgxfQ.sXrtrGZREDZYBtkIm0UvHxrB0Hh74CYSKBd60a4X-u4";


        JsonPath jsonPath = given().accept(ContentType.JSON).header("x-library-token", token).when().get("https://library2.cydeo.com/rest/v1/get_book_categories").prettyPeek().
                then().statusCode(200)
                .extract().jsonPath();

        List<String> categoryOne=jsonPath.getList("name");
        System.out.println("categoryOne = " + categoryOne);

    }




    }

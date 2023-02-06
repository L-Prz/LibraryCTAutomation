package LibraryApp.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class APITestBase {
    @BeforeAll
    public static void init() {
        baseURI ="https://library2.cydeo.com/rest/v1";

    }
}

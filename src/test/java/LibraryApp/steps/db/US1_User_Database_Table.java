package LibraryApp.steps.db;

import LibraryApp.utilities.DB_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US1_User_Database_Table  {
DB_Utils db_utils=new DB_Utils();

    @Given("the database connection is established")
    public void the_database_connection_is_established() {
       DB_Utils.createConnection();
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
DB_Utils.
    }
    @Then("verify the below columns are listed in the result")
    public void verify_the_below_columns_are_listed_in_the_result(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }



}

package LibraryApp.steps.db;

import LibraryApp.utilities.DB_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.util.List;

public class US1_User_Database_Table {

  //----------------------Setting up global variables--------------------
    DB_Utils db_utils = new DB_Utils();
    List<String> actualColumnNames;

    String totalUserIDCount;
    String uniqueUserIDCount;
//--------------------------AC 1: Column Names are matching------------------
    @Given("the database connection is established")
    public void the_database_connection_is_established() {
        DB_Utils.createConnection();
    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        String query = "select * from users";
        DB_Utils.runQuery(query);
        actualColumnNames=DB_Utils.getAllColumnNamesAsList();

    }

    @Then("verify the below columns are listed in the result")
    public void verify_the_below_columns_are_listed_in_the_result(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedUserColumnNames=dataTable.asList();
        System.out.println("expectedUserColumnNames = " + expectedUserColumnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);
        Assert.assertEquals(expectedUserColumnNames, actualColumnNames);
    }


    //-------------AC 2: Distinct User IDs----------------------------------------
    @When("Execute query to get total count of user ids")
    public void execute_query_to_get_total_count_of_user_ids() {
        String query="select count(id) from users";
        DB_Utils.runQuery(query);
        totalUserIDCount= DB_Utils.getFirstRowFirstColumn();
    }
    @When("execute query to get count of unique user ids")
    public void execute_query_to_get_count_of_unique_user_ids() {
        String query="select count(distinct id) from users";
        DB_Utils.runQuery(query);
        uniqueUserIDCount= DB_Utils.getFirstRowFirstColumn();
    }
    @Then("verify the number of total user ids is equal to unique user ids")
    public void verify_the_number_of_total_user_ids_is_equal_to_unique_user_ids() {
       Assert.assertEquals(totalUserIDCount, uniqueUserIDCount);
    }



}

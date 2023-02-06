package LibraryApp.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class APITestBase {
    @BeforeAll
    public static void init() {
        baseURI ="https://library2.cydeo.com/rest/v1";

    }

   public String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyIjp7ImlkIjoiNTgxMyIsImZ1bGxfbmFtZSI6IlRlc3QgTGlicmFyaWFuIDEiLCJlbWFpbCI6ImxpYnJhcmlhbjFAbGlicmFyeSIsInVzZXJfZ3JvdXBfaWQiOiIyIn0sImlhdCI6MTY3NDc3MDI4MSwiZXhwIjoxNjc3MzYyMjgxfQ.sXrtrGZREDZYBtkIm0UvHxrB0Hh74CYSKBd60a4X-u4";


    // --- E N D P O I N T S ---
    //BOOKS
    public String getBookCategoriesEndpoint="/get_book_categories";

    public static String getBookByIDEndpoint(String id){
        String getBookById="/get_book_by/id/{"+id+"}";
        return getBookById;
    }

    public String addBookEndpoint="/add_book";
    public String updateBookEndpoint="/update_book";

    public static String deleteBookByIdEndpoint(String id){
        String deleteBook="/delete_book/{"+id+"}";
        return deleteBook;
    }

    //BORROWING BOOKS
    public static String getBorrowedBooksByUserEndpoint(String user_id){
        String getBorrowedBooks="/get_borrowed_books_by_user/{"+user_id+"}";
        return getBorrowedBooks;
    }

public String getBookListForBorrowingEndpoint="/get_book_list_for_borrowing";
    public String returnBookEndpoint="/returnBook";
    public String borrowBookEndpoint="/book_borrow";

    //DASHBOARD STATS

    public String getDashboardStatsEndpoint="/dashboard_stats";

}

package LibraryApp.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonIgnoreProperties(value="id", allowSetters = true)//used to specify write-only properties; ones that should not be serialized out, but that may be provided in the deserilization.
public class Book {
    private String name;
    private String isbn;
    private int year;
    private String author;
    private int book_category_id;
    private String description;

    private int bookId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBook_category_id() {
        return book_category_id;
    }

    public void setBook_category_id(int book_category_id) {
        this.book_category_id = book_category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString(){
        return "Book{"+
                "name: "+name+"\n" +
                "isbn: "+isbn+"\n" +
                "year: "+year+"\n" +
                "author: "+author+"\n" +
                "book category id: "+book_category_id+"\n" +
                "description: "+ description;
    }

    public Map<String, String> getBookAsMap(){
        Map<String, String> mappedBook=new LinkedHashMap<>();
        mappedBook.put("id", String.valueOf(bookId));
        mappedBook.put("name", name);
        mappedBook.put("isbn", isbn);
        mappedBook.put("year", String.valueOf(year));
        mappedBook.put("author", author);
        mappedBook.put("book_category_id", String.valueOf(book_category_id));
        mappedBook.put("description", description);

        return mappedBook;

    }
}


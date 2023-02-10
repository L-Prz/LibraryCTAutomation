package LibraryApp.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class Book {
    private String name;
    private String isbn;
    private int year;
    private String author;
    private int book_category_id;
    private String description;

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
}


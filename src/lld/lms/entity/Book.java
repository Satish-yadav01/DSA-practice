package lld.lms.entity;

public class Book {
    private final String bookName;
    private final String bookAuthor;
    private final int publicationYear;


    public Book(String bookName, String bookAuthor, int publicationYear) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.publicationYear = publicationYear;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}

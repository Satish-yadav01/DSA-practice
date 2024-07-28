package lld.lms.entity;

public class Copy {
    private final int id;
    private final Book book;

    public Copy(int id, Book book) {
        this.id = id;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Copies{" +
                "id=" + id +
                ", book=" + book +
                '}';
    }
}

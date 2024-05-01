package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

public class Book {
    private long isbn;
    private String title;

    @ManyToMany
    @JoinTable(name = "writer_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private Set<Writer> writers;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @ManyToOne
    @JoinTable(name = "publisher_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private Publisher publisher;

    public Book() {
        this.isbn = 0;
        this.title = "";
        this.writers = new HashSet<>();
        this.publisher = null;
    }

    public Book(long isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.writers = new HashSet<>();
        this.publisher = null;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Isbn: " + isbn + ", Title: " + title;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

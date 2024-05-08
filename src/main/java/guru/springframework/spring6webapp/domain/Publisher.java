package guru.springframework.spring6webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;

import java.util.*;

@Entity
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books;

  public Publisher() {
    this.name = "";
    this.books = new HashSet<>();
  }

  public Publisher(String name) {
    this.name = name;
    this.books = new HashSet<>();
  }

  public Set<Book> getBooks() {
    return books;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Publisher publisher = (Publisher) o;
    return Objects.equals(id, publisher.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "Publisher{" + "id=" + id + ", name='" + name + '\'' + ", books=" + books + '}';
  }
}

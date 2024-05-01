package guru.springframework.spring6webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Writer {

    private String name;
    private String surname;
    private int age;
    @ManyToMany(mappedBy = "writers")
    private Set<Book> books;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Writer(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.books = new HashSet<>();
    }

    public Writer() {
        this.age = 20;
        this.surname = "No surname";
        this.name = "Unnamed";
        this.books = new HashSet<>();
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author: " + name + ", Surname: " + surname + ", Age: " + age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(id, writer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

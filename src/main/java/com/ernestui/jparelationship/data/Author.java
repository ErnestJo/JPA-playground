package com.ernestui.jparelationship.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 02/04/2023 - 20:13
 * @project jpa-relationship
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "zipcode_id")
    private Zipcode zipcode;
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    public Author(String name, Zipcode zipcode, List<Book> books) {
        this.name = name;
        this.zipcode = zipcode;
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

}
package com.ernestui.jparelationship.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 02/04/2023 - 20:13
 * @project jpa-relationship
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void deleteAuthor(Author author){
        authors.remove(author);
    }
}

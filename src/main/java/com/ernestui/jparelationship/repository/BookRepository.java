package com.ernestui.jparelationship.repository;

import com.ernestui.jparelationship.data.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 10:59
 * @project jpa-relationship
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}

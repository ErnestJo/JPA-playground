package com.ernestui.jparelationship.repository;

import com.ernestui.jparelationship.data.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 10:58
 * @project jpa-relationship
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}

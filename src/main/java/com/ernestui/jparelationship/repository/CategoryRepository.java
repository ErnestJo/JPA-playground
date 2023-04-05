package com.ernestui.jparelationship.repository;

import com.ernestui.jparelationship.data.Category;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 11:01
 * @project jpa-relationship
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

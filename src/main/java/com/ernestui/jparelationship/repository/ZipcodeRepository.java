package com.ernestui.jparelationship.repository;

import com.ernestui.jparelationship.data.Zipcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 10:57
 * @project jpa-relationship
 */
@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {
}

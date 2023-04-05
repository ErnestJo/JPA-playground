package com.ernestui.jparelationship.repository;

import com.ernestui.jparelationship.data.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 10:55
 * @project jpa-relationship
 */

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}

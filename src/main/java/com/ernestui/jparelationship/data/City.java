package com.ernestui.jparelationship.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 02/04/2023 - 20:13
 * @project jpa-relationship
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public City(String name) {
        this.name = name;
    }
}
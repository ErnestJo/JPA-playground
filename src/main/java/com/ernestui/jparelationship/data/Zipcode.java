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
@Table(name = "Zipcode")
public class Zipcode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Zipcode(String name, City city) {
        this.name = name;
        this.city = city;
    }
}

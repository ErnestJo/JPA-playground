package com.ernestui.jparelationship.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 09:04
 * @project jpa-relationship
 */
@Data
public class CategoryResponseDto {
    private Long id;
    private String name;
    private List<String> bookNames;
}

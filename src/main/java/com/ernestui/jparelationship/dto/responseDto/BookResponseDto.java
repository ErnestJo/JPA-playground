package com.ernestui.jparelationship.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 08:58
 * @project jpa-relationship
 */

@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private List<String> authorNames;
    private String categoryName;
}

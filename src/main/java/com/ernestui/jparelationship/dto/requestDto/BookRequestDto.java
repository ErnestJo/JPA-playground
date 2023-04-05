package com.ernestui.jparelationship.dto.requestDto;

import lombok.Data;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 08:48
 * @project jpa-relationship
 */
@Data
public class BookRequestDto {
    private String name;
    private List<Long> authorsIds;
    private Long categoryId;
}

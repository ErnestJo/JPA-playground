package com.ernestui.jparelationship.dto.responseDto;

import lombok.Data;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 03/04/2023 - 08:55
 * @project jpa-relationship
 */

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private List<String> bookNames;
    private String zipcodeName;
}

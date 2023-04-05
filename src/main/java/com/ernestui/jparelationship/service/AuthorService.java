package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Author;
import com.ernestui.jparelationship.dto.requestDto.AuthorRequestDto;
import com.ernestui.jparelationship.dto.responseDto.AuthorResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 04/04/2023 - 18:53
 * @project jpa-relationship
 */
@Service
public interface AuthorService {
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    public List<AuthorResponseDto> getAuthors();
    public AuthorResponseDto getAuthorById(Long authorId );
    public Author getAuthor(Long AuthorId);
    public AuthorResponseDto deleteAuthor (Long AuthorId);
    public AuthorResponseDto editAuthor (Long AuthorId, AuthorRequestDto authorRequestDto);
    public AuthorResponseDto addZipcodeToAuthor (Long AuthorId, Long ZipcodeId);
    public AuthorResponseDto deleteZipcodeToAuthor(Long authorId);

}

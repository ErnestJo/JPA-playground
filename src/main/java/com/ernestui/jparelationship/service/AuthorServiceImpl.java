package com.ernestui.jparelationship.service;

import com.ernestui.jparelationship.data.Author;
import com.ernestui.jparelationship.data.Zipcode;
import com.ernestui.jparelationship.dto.mapper;
import com.ernestui.jparelationship.dto.requestDto.AuthorRequestDto;
import com.ernestui.jparelationship.dto.responseDto.AuthorResponseDto;
import com.ernestui.jparelationship.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 04/04/2023 - 19:14
 * @project jpa-relationship
 */

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final ZipcodeService zipcodeService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ZipcodeService zipcodeService) {
        this.authorRepository = authorRepository;
        this.zipcodeService = zipcodeService;
    }

    @Transactional
    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipcodeId() == null){
            throw new IllegalArgumentException("author need a zipcode");
        }
        Zipcode zipcode = zipcodeService.getZipCode(authorRequestDto.getZipcodeId());
        author.setZipcode(zipcode);
        authorRepository.save(author);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
        List<Author> authors = StreamSupport
                .stream(authorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return mapper.authorToAuthorResponseDtos(authors);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return mapper.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public Author getAuthor(Long AuthorId) {
        Author author = authorRepository.findById(AuthorId).orElseThrow(() -> new IllegalArgumentException("No such author found in a system  " + AuthorId + "found" ));
        return author;
    }

    @Override
    public AuthorResponseDto deleteAuthor(Long AuthorId) {
        Author author = getAuthor(AuthorId);
        authorRepository.delete(author);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto editAuthor(Long AuthorId, AuthorRequestDto authorRequestDto) {
        Author authorToEdit = getAuthor(AuthorId);
        authorToEdit.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipcodeId() != null){
            Zipcode zipcode = zipcodeService.getZipCode(authorRequestDto.getZipcodeId());
            authorToEdit.setZipcode(zipcode);
        }
        return mapper.authorToAuthorResponseDto(authorToEdit);
    }

    @Transactional
    @Override
    public AuthorResponseDto addZipcodeToAuthor(Long AuthorId, Long ZipcodeId) {
        Author author = getAuthor(AuthorId);
        Zipcode zipcode = zipcodeService.getZipCode(ZipcodeId);
        if(Objects.nonNull(author.getZipcode())){
            throw  new IllegalArgumentException("Zipcode is already existed");
        }
        author.setZipcode(zipcode);
        return mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto deleteZipcodeToAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        if(!(Objects.nonNull(author.getZipcode()))){
            throw  new IllegalArgumentException("Zipcode is not existed");
        }
        author.setZipcode(null);
        return mapper.authorToAuthorResponseDto(author);
    }
}
